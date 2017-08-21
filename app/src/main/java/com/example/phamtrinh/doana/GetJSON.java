package com.example.phamtrinh.doana;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

/**
 * Created by phamtrinh on 7/28/17.
 */

public class GetJSON extends AsyncTask<String, Integer, String> {

    public ResAsyncJSON RAJSON = null;
    public GetJSON(ResAsyncJSON RAJSON){
        this.RAJSON = RAJSON;
    }
    @Override
    protected String doInBackground(String... params) {
        return ConnServer.ReadUrl(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        RAJSON.finish(s);
    }
}

