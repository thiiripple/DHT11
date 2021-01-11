package com.kust.dao;

public class GetInf {
    public static String getHumidity(String str){
        int end = str.lastIndexOf("%");
        String humidity = str.substring(end - 4, end);
        return humidity;
    }

    public static String getTemperatrure(String str){

        int begin = str.lastIndexOf("：");
        int end = str.lastIndexOf("°");
        String temperature = str.substring(begin + 1, end);
        return temperature;
    }

}
