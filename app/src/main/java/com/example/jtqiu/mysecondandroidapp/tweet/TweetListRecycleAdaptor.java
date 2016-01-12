package com.example.jtqiu.mysecondandroidapp.tweet;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetListRecycleAdaptor extends RecyclerView.Adapter<TweetListRecycleAdaptor.ViewHolder> {
    List<Tweet> tweetList = new ArrayList<>();

    @Override
    public TweetListRecycleAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweet_item_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TweetListRecycleAdaptor.ViewHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.populate(tweet);
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView avatar;
        TextView userName;
        TextView userTweet;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            avatar = (ImageView)itemView.findViewById(R.id.user_avatar);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            userTweet = (TextView)itemView.findViewById(R.id.user_comment);
        }

        public void populate(Tweet s) {
            avatar.setImageURI(null);
            userName.setText(s.getSender().getUsername());
            userTweet.setText(s.getContent());
        }
    }
}
