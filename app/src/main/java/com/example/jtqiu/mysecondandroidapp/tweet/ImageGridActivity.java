package com.example.jtqiu.mysecondandroidapp.tweet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.jtqiu.mysecondandroidapp.R;

public class ImageGridActivity extends AppCompatActivity {
    private String[] urls = {
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7",
            "http://i.ytimg.com/vi/rGWI7mjmnNk/hqdefault.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        GridView gridView = (GridView)findViewById(R.id.image_grid);

        gridView.setAdapter(new ImageAdapter(this, null));

    }
}
