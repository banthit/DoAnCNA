package com.example.phamtrinh.doana;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DELL on 9/13/2017.
 */

public class PostToServer extends AsyncTask<String,Void,String> {
    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
    String username,password,email;

    public PostToServer(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    protected String doInBackground(String... strings) {
        RequestBody requestBody = new MultipartBody.Builder()
                .addFormDataPart("username",username)
                .addFormDataPart("password",password)
                .addFormDataPart("email",email)
                .setType(MultipartBody.FORM)
                .build();

        Request request = new Request.Builder()
                .url(strings[0])
                .post(requestBody)
                .build();

        try{
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.e("key",s);
        super.onPostExecute(s);
    }
}
