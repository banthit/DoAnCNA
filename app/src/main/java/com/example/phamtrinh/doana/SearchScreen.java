package com.example.phamtrinh.doana;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;



/**
 * Created by phamtrinh on 8/7/17.
 */


public class SearchScreen extends Fragment{
    private FragmentListener listener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_screen,container,false);

        return view;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (FragmentListener) activity;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }


}
