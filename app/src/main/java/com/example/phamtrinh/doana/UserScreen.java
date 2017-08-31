package com.example.phamtrinh.doana;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import com.example.phamtrinh.doana.User_Data;
import com.example.phamtrinh.doana.User_Adapter;
/**
 * Created by phamtrinh on 7/24/17.
 */

public class UserScreen extends Fragment {
     FragmentListener listener;
    User_Adapter adapter;
     RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_screen,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        //adapter = new User_Adapter(getActivity().getData());
        //recyclerView.setAdapter(adapter);

        setUpRecycleViewList();
        return view;
    }

//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        listener = (FragmentListener) activity;
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // code
    }
//    public ArrayList<User_Data> getData(){
//        ArrayList<User_Data> datas = new ArrayList<>();
//        int[] icons = {R.drawable.ic_account_box_black_24dp,R.drawable.ic_mail_outline_black_24dp,R.drawable.ic_phone_black_24dp};
//        String[] text = {"Carol Pierce", "carol_pierce@gmail.com", "0906770640"};
//        for(int i = 0; i<text.length && i<icons.length; i++){
//              User_Data user_data = new User_Data(datas,getContext());
//            user_data.Icon = icons[i];
//            user_data.Text = text[i];
//            datas.add(user_data);khoan
//        }
//        return datas;
//    }
    private void setUpRecycleViewList(){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<User_Data> user_datas= new ArrayList<>();
        user_datas.add(new User_Data(getResources().getDrawable(R.drawable.ic_account_box_black_24dp),"Carol Pierce"));
        user_datas.add(new User_Data(getResources().getDrawable(R.drawable.ic_mail_outline_black_24dp),"Carol_Pierce@gmail.com"));
        User_Adapter adapter = new User_Adapter(user_datas,getContext());
        recyclerView.setAdapter(adapter);
    }
}
