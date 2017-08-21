package com.example.phamtrinh.doana;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.widget.AdapterView;

/**
 * Created by phamtrinh on 7/24/17.
 */

public class ListScreen extends Fragment implements ResAsyncJSON{
    private FragmentListener listener;
    private FragmentData listenerData;
    ArrayList<books> bookss;
    GridView gridViewList;
    ConnServer connServer = new ConnServer();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_screen,container,false);
        return view;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (FragmentListener) activity;
        listenerData = (FragmentData) activity;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // code

        new GetJSON(this).execute(connServer.host+"books");

        gridViewList = (GridView)view.findViewById(R.id.gridViewList);



    }


    @Override
    public void finish(String output) {

        try {
            bookss = new ArrayList<books>();
            JSONArray jsonArr = new JSONArray(output);
            for(int i = 0; i < jsonArr.length(); i++) {
                JSONObject jsonObject = jsonArr.getJSONObject(i);
                bookss.add(new books(
                        jsonObject.getString("tensach"),
                        jsonObject.getString("hinhsach"),
                        jsonObject.getString("noidung")
                ));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }


        final String[] name = new String[bookss.size()];
        String[] image = new String[bookss.size()];
        final String[] noidung = new String[bookss.size()];

        for(int i = 0; i < bookss.size();i++){

            image[i] = bookss.get(i).hinhsach;
            name[i] = bookss.get(i).tensach;
            noidung[i] = bookss.get(i).noidung;

        }

        listenerData.transDataArray(name);

        GridViewAdapter gridViewAdapter = new GridViewAdapter(getActivity(),name,image, noidung);
        gridViewList.setAdapter(gridViewAdapter);
        gridViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listenerData.transDataString(noidung[position]);

            }
        });




    }


}
