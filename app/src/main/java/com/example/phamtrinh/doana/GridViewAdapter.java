package com.example.phamtrinh.doana;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by phamtrinh on 7/28/17.
 */

public class GridViewAdapter extends BaseAdapter {

    ConnServer connServer = new ConnServer();

    public Context context;
    public String[] tensach;
    public String[] hinhsach;
    public String[] noidung;

    public GridViewAdapter(Context context, String[] tensach, String[] hinhsach, String[] noidung){
        this.context = context;
        this.tensach = tensach;
        this.hinhsach = hinhsach;
        this.noidung = noidung;
    }



    @Override
    public int getCount() {
        return tensach.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.gridviewlist_row,null);
        TextView textView = (TextView)convertView.findViewById(R.id.textviewlist);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageviewlist);
        textView.setText(tensach[position]);
        Picasso.with(context).load(connServer.host+"images/"+hinhsach[position]+".png").into(imageView);
        return convertView;
    }
}
