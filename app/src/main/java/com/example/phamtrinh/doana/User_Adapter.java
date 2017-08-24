package com.example.phamtrinh.doana;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 8/22/2017.
 */

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.ViewHolder>{
    ArrayList<User_Data> user_datas;
    Context context;

    public User_Adapter(ArrayList<User_Data> user_datas, Context context) {

        this.user_datas = user_datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(user_datas.get(position).getText());
        holder.imageView.setImageDrawable(user_datas.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return user_datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView  textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.txt_username);
            imageView = (ImageView)itemView.findViewById(R.id.img_user);
        }
    }
}
