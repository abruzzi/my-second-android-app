package com.example.jtqiu.mysecondandroidapp.tweet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends BaseAdapter{
    private Context context;
    private final List<Image> urls;

    public ImageAdapter(Context context, List<Image> urls) {
        this.context = context;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
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
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.thumbnails_layout, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

            String url = urls.get(position).getUrl();
            Picasso.with(context).load(url)
                    .placeholder(R.drawable.avatar_placeholder)
                    .error(R.drawable.avatar_placeholder)
                    .into(imageView);
        } else {
            gridView = convertView;
        }

        return gridView;
    }
}
