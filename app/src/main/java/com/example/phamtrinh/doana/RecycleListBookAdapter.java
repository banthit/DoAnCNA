package com.example.phamtrinh.doana;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by phamtrinh on 8/23/17.
 */

public class RecycleListBookAdapter extends RecyclerView.Adapter<RecycleListBookAdapter.MyListBookHolder> {

    RecyclerViewListBookClickListener mItemClickListener;
    ConnServer connServer = new ConnServer();
    public Context context;
    public String[] tensach;
    public String[] hinhsach;
    public String[] noidung;
    public String[] tacgia;
    RecycleListBookAdapter(Context context, String[] tensach, String[] hinhsach, String[] noidung, String[] tacgia)
    {

        this.context = context;
        this.tensach = tensach;
        this.hinhsach = hinhsach;
        this.noidung = noidung;
        this.tacgia = tacgia;
    }

    @Override
    public MyListBookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listbook,parent,false);
        return new MyListBookHolder(view,mItemClickListener);
    }

    @Override
    public void onBindViewHolder(MyListBookHolder holder, int position) {

        Picasso.with(context).load(connServer.host+"images/"+hinhsach[position]+".png").into(holder.img_book);
        holder.name_book.setText(tensach[position]);
        holder.author_book.setText(tacgia[position]);
    }
    public void setmItemClickListener(RecyclerViewListBookClickListener mItemClickListener){
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemCount() {
        return tensach.length;
    }

//    public void setClickListener(RecyclerViewListBookClickListener mListener){
//        this.mListener = mListener;
//    }
    public static class MyListBookHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private RecyclerViewListBookClickListener mItemClickListener;
        CircleImageView img_book;
        TextView name_book;
        TextView author_book;
        public MyListBookHolder(View itemView, RecyclerViewListBookClickListener mItemClickListener){
            super(itemView);
            img_book = (CircleImageView) itemView.findViewById(R.id.image_book);
            name_book = (TextView) itemView.findViewById(R.id.name_book);
            author_book = (TextView) itemView.findViewById(R.id.author_book);
            this.mItemClickListener = mItemClickListener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(mItemClickListener != null){
                mItemClickListener.onItemClick(v,getAdapterPosition());

            }
        }
    }
}
