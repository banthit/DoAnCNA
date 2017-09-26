package com.example.phamtrinh.doana;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DELL on 9/13/2017.
 */

public class LoginScreen extends Fragment {
    private EditText username, password;
    private CheckBox rememberMe_checkbox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private TextView forgot_password;
    private Button sign_In_btn, sign_Up_btn;
    private  boolean Login_Security_Check = false;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    public LoginScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_screen, container, false);
        username = (EditText)view.findViewById(R.id.login_username);
        password = (EditText)view.findViewById(R.id.login_password);
        rememberMe_checkbox = (CheckBox)view.findViewById(R.id.login_remember_checkbox);
        forgot_password = (TextView)view.findViewById(R.id.login_forget_password);
        sign_In_btn = (Button)view.findViewById(R.id.login_signIn_button);
        sign_Up_btn = (Button)view.findViewById(R.id.login_register_button);


        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //forgot password
                Toast.makeText(getActivity(), "Tìm lại mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });
        sign_In_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                if(Login_Security_Check == true){
                    Fragment fragment = new UserScreen();
                    FragmentManager fragmentManager = getActivity().getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameContent, fragment);
                    fragmentTransaction.addToBackStack("UserScreen");
                    fragmentTransaction.commit();}
                else {
                    Toast.makeText(getContext(), "Xin đăng nhập lại", Toast.LENGTH_LONG).show();
                }

            }
        });

        sign_Up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, new RegisterFragment());
                fragmentTransaction.addToBackStack("register");
                fragmentTransaction.commit();*/
                Fragment fragment = new RegisterScreen();
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.addToBackStack("register");
                fragmentTransaction.commit();
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
