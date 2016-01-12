package com.example.jtqiu.mysecondandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.Arrays;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String[] names = new String[]{"Juntao", "Shuai", "Jinhao", "Zengheng", "Juntao", "Shuai", "Jinhao", "Zengheng", "Juntao", "Shuai", "Jinhao", "Zengheng", "Juntao", "Shuai", "Jinhao", "Zengheng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        bindDataWithRecyclerView();
    }

    private void bindDataWithRecyclerView() {
        recyclerView = (RecyclerView)findViewById(R.id.name_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NameListRecycleAdaptor nameListRecycleAdaptor = new NameListRecycleAdaptor();
        recyclerView.setAdapter(nameListRecycleAdaptor);

        nameListRecycleAdaptor.setNameList(Arrays.asList(names));
        nameListRecycleAdaptor.notifyDataSetChanged();
    }
}
