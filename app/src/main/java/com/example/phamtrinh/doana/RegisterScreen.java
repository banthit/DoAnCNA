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


                    new PostToServer(username,password,email).execute(connServer.host+"user");
                //Register
            }
        });
        return view;
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
