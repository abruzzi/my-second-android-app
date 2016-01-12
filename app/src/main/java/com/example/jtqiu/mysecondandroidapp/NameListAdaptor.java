package com.example.jtqiu.mysecondandroidapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NameListAdaptor extends BaseAdapter {
    List<String> nameList = new ArrayList<>();

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.nameText = (TextView)view.findViewById(android.R.id.text1);

            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.nameText.setText((String)getItem(i));

        return view;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    static class ViewHolder {
        TextView nameText;
    }
}
