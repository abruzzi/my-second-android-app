package com.example.jtqiu.mysecondandroidapp.tweet.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.squareup.picasso.Picasso;


public class TweetViewHolder extends RecyclerView.ViewHolder {
    ImageView avatar;
    TextView userName;
    TextView userTweet;

    Context context;

    public TweetViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        avatar = (ImageView) itemView.findViewById(R.id.user_avatar);
        userName = (TextView) itemView.findViewById(R.id.user_name);
        userTweet = (TextView) itemView.findViewById(R.id.user_comment);
    }

    public void populate(Object obj) {
        Tweet tweet = (Tweet) obj;

        String avatarUrl = tweet.getSender().getAvatar();
        Picasso.with(context).load(avatarUrl)
                .resize(50, 50)
                .centerCrop()
                .placeholder(R.drawable.avatar_placeholder)
                .error(R.drawable.avatar_placeholder)
                .into(this.avatar);

        userName.setText(tweet.getSender().getUsername());
        userTweet.setText(tweet.getContent());
    }
}
