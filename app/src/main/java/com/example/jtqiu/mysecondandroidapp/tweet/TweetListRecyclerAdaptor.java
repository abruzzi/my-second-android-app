package com.example.jtqiu.mysecondandroidapp.tweet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.example.jtqiu.mysecondandroidapp.tweet.viewholders.FooterViewHolder;
import com.example.jtqiu.mysecondandroidapp.tweet.viewholders.HeaderViewHolder;
import com.example.jtqiu.mysecondandroidapp.tweet.viewholders.TweetViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TweetListRecyclerAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Tweet> tweetList = new ArrayList<>();

    private static final int NORMAL = 0;
    private static final int HEADER = 1;
    private static final int FOOTER = 2;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        RecyclerView.ViewHolder viewHolder = null;
        switch(viewType) {
            case HEADER:
                viewHolder = new HeaderViewHolder(inflater.inflate(R.layout.list_header, parent, false));
                break;
            case NORMAL:
                viewHolder = new TweetViewHolder(inflater.inflate(R.layout.tweet_item_layout, parent, false));
                break;
            case FOOTER:
                viewHolder = new FooterViewHolder(inflater.inflate(R.layout.list_footer, parent, false));
                break;
        }

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == NORMAL) {
            Tweet tweet = tweetList.get(position-1);
            ((TweetViewHolder)holder).populate(tweet);
        }

        if (holder.getItemViewType() == HEADER) {
            ((HeaderViewHolder)holder).populate(null);
        }

        if (holder.getItemViewType() == FOOTER) {
            ((FooterViewHolder)holder).populate(null);
        }
    }

    @Override
    public int getItemCount() {
        return tweetList.size()+2; //plus header and footer
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return HEADER;
        } else if(position == tweetList.size()+1) {
            return FOOTER;
        } else {
            return NORMAL;
        }
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

}
