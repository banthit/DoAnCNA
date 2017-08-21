package com.example.phamtrinh.doana;

import android.os.AsyncTask;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by phamtrinh on 7/31/17.
 */

public class GetPDF extends AsyncTask<String,Void,InputStream> {

    public ResAsyncPDF RAPDF = null;
    public GetPDF(ResAsyncPDF RAPDF){
        this.RAPDF = RAPDF;
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        InputStream inputStream = null;
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            if(urlConnection.getResponseCode() == 200){
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
            }

        }catch (IOException e){
            return null;
        }
        return inputStream;
    }

    @Override
    protected void onPostExecute(InputStream inputStream) {
        RAPDF.finish(inputStream);
    }
}
