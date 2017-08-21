package com.example.phamtrinh.doana;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by phamtrinh on 8/11/17.
 */

public class recyclerSearchAdapter extends RecyclerView.Adapter<recyclerSearchAdapter.SearchViewHolder> {
    ArrayList<String> arrayList = new ArrayList<>();
    recyclerSearchAdapter(ArrayList<String> arrayList)
    {
        this.arrayList = arrayList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_search,parent,false);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.c_name_books.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder{

        TextView c_name_books;
        public SearchViewHolder(View itemView) {
            super(itemView);
            c_name_books=(TextView) itemView.findViewById(R.id.name_book);
        }
    }
    public void setFilter(ArrayList<String> newList){
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);
        notifyDataSetChanged();
    }
}
