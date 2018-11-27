package com.example.ln20181119.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {

    private static String inputStr;

    public static String get(String urlStr){
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            InputStream stream = connection.getInputStream();
            inputStr = getInputStr(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStr;
    }

    private static String getInputStr(InputStream stream) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(stream));
        StringBuffer sb = new StringBuffer();
        String str=null;
        while ((str=bf.readLine())!=null){
            sb.append(str);
        }
        return sb.toString();
    }
}
