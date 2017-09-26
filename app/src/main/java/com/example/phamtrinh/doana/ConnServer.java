package com.example.phamtrinh.doana;

import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;
import java.net.URLConnection;

/**
 * Created by phamtrinh on 7/24/17.
 */

public class ConnServer {

    public String host = "http://172.20.10.6:3000/";

    public Socket mSocket;
    {
        try {
            mSocket = IO.socket(host);
        }catch (URISyntaxException e){}
    }





    public static String ReadUrl(String theUrl)
    {
        StringBuilder content = new StringBuilder();
        try{
            URL url = new URL(theUrl);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null){
                content.append(line);
            }
            bufferedReader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }



}
