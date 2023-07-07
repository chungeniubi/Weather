package com.example.tianqi;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private static String result="nihao";
    private static EditText sheng;
    private static EditText shi;
    private static EditText time;
    private static EditText updatetime;
    private static EditText pm;
    private static EditText high;
    private static EditText low;
    private static EditText name;
    private static EditText weather;
    private static EditText shidu;
    private static EditText wendu;
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private StringBuilder builder;
    private static Button button1;

    private Button button;

    private final int SUCCEED = 1;
    private static String nm="";
    private static String wz="";
    private static int flag = 0;
    private static int flan = 0;
    private static Button button3;
    private static Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button2);
        sheng = (EditText)findViewById(R.id.sheng1);
        shi = (EditText) findViewById(R.id.shi1);
        time = (EditText)findViewById(R.id.time1);
        updatetime =(EditText)findViewById(R.id.updatetime1);
        weather = (EditText)findViewById(R.id.tianqi);
        shidu = (EditText) findViewById(R.id.shidu1);
        wendu = (EditText)findViewById(R.id.wendu2);
        pm = (EditText) findViewById(R.id.pm1);
        name = (EditText)findViewById(R.id.name);
        button1 = (Button) findViewById(R.id.button);
        button3 = (Button)findViewById(R.id.back);
        button4 = (Button)findViewById(R.id.chayue);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                String name = sharedPreferences.getString("name"+flan,"");
                nm+=name;
                initUI();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initUI();
                Toast.makeText(MainActivity.this,"刷新成功!",Toast.LENGTH_SHORT).show();
            }
        });
        nm = "http://t.weather.sojson.com/api/weather/city/";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wz = name.getText().toString();
                if(wz.length()!=9)
                {
                    Toast.makeText(MainActivity.this,"请输入9为城市ID!",Toast.LENGTH_SHORT).show();
                }
                else {
                    nm+=name.getText().toString();
                    initUI();
                    Toast.makeText(MainActivity.this,"获取成功!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
   Handler handler = new Handler(new Handler.Callback() {
       @Override
       public boolean handleMessage(@NonNull Message message) {
           if(message.what == SUCCEED)
           {
               result = message.getData().getString("data");
               JSONObject jsonObject = new JSONObject();
               WeatherBean weatherBean;
               Gson gson = new Gson();
               weatherBean = gson.fromJson(result,WeatherBean.class);
               sheng.setText(weatherBean.getCityInfo().parent);
               shi.setText(weatherBean.getCityInfo().getCity());
               time.setText(weatherBean.getTime());
               updatetime.setText(weatherBean.getCityInfo().getUpdateTime());
               wendu.setText(weatherBean.getData().getWendu());
               shidu.setText(weatherBean.getData().getShidu());
               pm.setText(weatherBean.getData().pm25);
               weather.setText(weatherBean.getData().getQuality());
               SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedPreferences.edit();
               if(flan == 3){flan=0;}
               if(flag<3) {
                   editor.putString("name"+flag, weatherBean.getCityInfo().citykey);
                   flag++;
                   editor.apply();
               }
               else if(flan<3){
                   editor.putString("name"+flan, weatherBean.getCityInfo().citykey);
                   flan++;
                   editor.apply();
               }
       }
           return false;
       }});
    public void initUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = getDataFrom();

                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("data",data);
                message.setData(bundle);
                message.what = SUCCEED;
                handler.sendMessage(message);
                nm = "http://t.weather.sojson.com/api/weather/city/";
            }
        }).start();
    }

    private String getDataFrom() {
        String data = "";
        String formattedJson="";
        try {
            URL url = new URL(nm);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode()== 200) {
                inputStream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                builder = new StringBuilder();
                for (String line = ""; (line = bufferedReader.readLine()) != null; ) {
                    builder.append(line);
                }
            }
            data = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}