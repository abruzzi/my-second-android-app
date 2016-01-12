package com.example.jtqiu.mysecondandroidapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NameListRecycleAdaptor extends RecyclerView.Adapter<NameListRecycleAdaptor.ViewHolder> {
    List<String> nameList = new ArrayList<>();

    @Override
    public NameListRecycleAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NameListRecycleAdaptor.ViewHolder holder, int position) {
        holder.populate(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(android.R.id.text1);
        }

        public void populate(String s) {
            textView.setText(s);
        }
    }
}
