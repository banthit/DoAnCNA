package com.example.phamtrinh.doana;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;


import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;


import java.util.ArrayList;

import java.util.Collections;


/**
 * Created by phamtrinh on 8/7/17.
 */


public class SearchScreen extends Fragment{
    private FragmentListener listener;
    FragmentManager fragmentManager = getFragmentManager();
    RecyclerView recyclerView;
    recyclerSearchAdapter adapter;
    RecyclerView.LayoutManager searhLayoutManager;
    ArrayList<String> booksSearch;
    MainActivity mainActivity = new MainActivity();

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
        setHasOptionsMenu(true);


        recyclerView = (RecyclerView) view.findViewById(R.id.search_recyclerview);
        searhLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(searhLayoutManager);
        recyclerView.setHasFixedSize(true);

        String[] dataArr = getArguments().getStringArray("dataname");
//        for (int i = 0; i < dataArr.length; i++){
//            Log.i("Sasdas", dataArr[i]);
//        }
        booksSearch = new ArrayList<>();
        Collections.addAll(booksSearch,dataArr);
        Log.i("Sasdas", String.valueOf(booksSearch.size()));
        adapter = new recyclerSearchAdapter(booksSearch);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint("Tìm ");
        searchView.setIconifiedByDefault(false);

//        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                newText = newText.toLowerCase();
                ArrayList<String> newList = new ArrayList<String>();
                for(int i = 0; i < booksSearch.size();i++){
                    String name = booksSearch.get(i).toLowerCase();
                    if(name.contains(newText)){
                        newList.add(booksSearch.get(i));
                    }
                }
                adapter.setFilter(newList);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_cancel){

            getFragmentManager().popBackStack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
