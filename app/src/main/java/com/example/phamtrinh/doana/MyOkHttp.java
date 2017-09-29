package com.example.phamtrinh.doana;

import android.support.annotation.NonNull;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by macos on 9/27/17.
 */

public class MyOkHttp {
    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();
    static String host = "http://10.104.12.242:3000";

    public static Call POST(@NonNull String route, String jsonParams, Callback callback) {
        RequestBody body = RequestBody.create(JSON, String.valueOf(jsonParams));
        Request request = new Request.Builder()
                .url(host + route)
                .post(body)
                .addHeader("Content-Type", " application/x-www-form-urlencoded")
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }
}
