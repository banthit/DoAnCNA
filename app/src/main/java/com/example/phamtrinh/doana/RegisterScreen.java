package com.example.phamtrinh.doana;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by DELL on 9/13/2017.
 */

public class RegisterScreen extends Fragment {
    private EditText enterUsername, enterPassword, reEnterPassword, enterEmail;
    private Button Register_Submit;
    ConnServer connServer = new ConnServer();

    public RegisterScreen() {
        // Required empty public constructor
    }
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_screen, container, false);
        enterUsername = (EditText)view.findViewById(R.id.register_username);
        enterPassword = (EditText)view.findViewById(R.id.register_password);
        reEnterPassword = (EditText)view.findViewById(R.id.register_reEnter_password);
        enterEmail = (EditText)view.findViewById(R.id.register_email);
        Register_Submit = (Button)view.findViewById(R.id.register_button_submit);


        Register_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String username = enterUsername.getText().toString().trim();
                    String password = enterPassword.getText().toString().trim();
                    String reEnter_Password = reEnterPassword.getText().toString().trim();
                    String email = enterEmail.getText().toString().trim();

                Log.i("TEST", username + "|" + password + "|" + email);


//                    new PostToServer(username,password,email).execute(connServer.host+"user");
                //Register
                OkHttpClient client = new OkHttpClient();
                JSONObject object = new JSONObject();
                try {
                    object.put("email", email);
                    object.put("username", username);
                    object.put("password", password);

                    MyOkHttp.POST("/user", String.valueOf(object), new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.i("RES", response.body().string().toString());
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        return view;
    }

    Call post(OkHttpClient client, String url, JSONObject json, Callback callback) {
        RequestBody body = RequestBody.create(JSON, String.valueOf(json));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", " application/x-www-form-urlencoded")
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().hide();
        ((MainActivity) getActivity()).findViewById(R.id.bottom_nav).setVisibility(View.INVISIBLE);

    }
    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).getSupportActionBar().show();
        ((MainActivity) getActivity()).findViewById(R.id.bottom_nav).setVisibility(View.VISIBLE);
    }
}
