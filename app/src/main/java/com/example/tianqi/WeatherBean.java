package com.example.tianqi;

public class WeatherBean {
    private String time;
    private Cityinfo cityInfo;
    private Data data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Cityinfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(Cityinfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "time='" + time + '\'' +
                ", cityInfo=" + cityInfo +
                ", data=" + data +
                '}';
    }
}

    class Cityinfo{
    String city;
    String citykey;
    String parent;
    String updateTime;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Cityinfo{" +
                    "city='" + city + '\'' +
                    ", citykey='" + citykey + '\'' +
                    ", parent='" + parent + '\'' +
                    ", updateTime='" + updateTime + '\'' +
                    '}';
        }
    }
    class Data{
        String shidu;
        String pm25;
        String pm10;
        String quality;
        String wendu;
        String ganmao;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }


        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "shidu='" + shidu + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", pm10='" + pm10 + '\'' +
                    ", quality='" + quality + '\'' +
                    ", wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    '}';
        }
    }
