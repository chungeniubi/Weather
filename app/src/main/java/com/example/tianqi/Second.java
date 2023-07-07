package com.example.tianqi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Second extends AppCompatActivity {
    private static EditText nihao;
    private static FloatingActionButton ccl;
    String a = " \"city_code\": \"101010100\",\n" +
            "    \"city_name\": \"北京\",\n" +
            "    \"city_code\": \"101020100\",\n" +
            "    \"city_name\": \"上海\",\n" +
            "    \"city_code\": \"101030100\",\n" +
            "    \"city_name\": \"天津\",\n" +
            "    \"city_code\": \"101040100\",\n" +
            "    \"city_name\": \"重庆\",\n" +
            "    \"city_code\": \"101320101\",\n" +
            "    \"city_name\": \"香港\",\n" +
            "    \"city_code\": \"101330101\",\n" +
            "    \"city_name\": \"澳门\",\n" +
            "    \"city_code\": \"101220601\",\n" +
            "    \"city_name\": \"安庆\",\n" +
            "    \"city_code\": \"101220201\",\n" +
            "    \"city_name\": \"蚌埠\",\n" +
            "    \"city_code\": \"101220105\",\n" +
            "    \"city_name\": \"巢湖市\",\n" +
            "    \"city_code\": \"101221701\",\n" +
            "    \"city_name\": \"池州\",\n" +
            "    \"post_code\": \"247100\",\n" +
            "    \"city_code\": \"101221101\",\n" +
            "    \"city_name\": \"滁州\",\n" +
            "    \"post_code\": \"239000\",\n" +
            "    \"city_code\": \"101220801\",\n" +
            "    \"city_name\": \"阜阳\",\n" +
            "    \"city_code\": \"101221201\",\n" +
            "    \"city_name\": \"淮北\",\n" +
            "    \"city_code\": \"101220401\",\n" +
            "    \"city_name\": \"淮南\",\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ccl = (FloatingActionButton)findViewById(R.id.back1);
        ccl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second.this,MainActivity.class);
                startActivity(intent);
            }
        });
        nihao = (EditText) findViewById(R.id.icon);
        nihao.setText(a);
    }
}