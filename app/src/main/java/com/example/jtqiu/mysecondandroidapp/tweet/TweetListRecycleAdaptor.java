package com.example.jtqiu.mysecondandroidapp.tweet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.UserProfileActivity;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TweetListRecycleAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
        if(isNormalItem(position) && holder.getItemViewType() == NORMAL) {
            Tweet tweet = tweetList.get(position-1);
            ((TweetViewHolder)holder).populate(tweet);
        }

        if (position == 0 && holder.getItemViewType() == HEADER) {
            ((HeaderViewHolder)holder).populate(null);
        }

        if (position == tweetList.size()+1 && holder.getItemViewType() == FOOTER) {
            ((FooterViewHolder)holder).populate(null);
        }
    }

    private boolean isNormalItem(int position) {
        return position != 0 && position != tweetList.size() + 1;
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


    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView heroImage;
        ImageView myAvatar;
        TextView myName;

        Context context;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            heroImage = (ImageView) itemView.findViewById(R.id.hero_image);
            myAvatar = (ImageView) itemView.findViewById(R.id.my_avatar);
            myName = (TextView) itemView.findViewById(R.id.my_name);

            myAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchToUserProfile();
                }
            });
        }

        private void switchToUserProfile() {
            Intent intent = new Intent(context, UserProfileActivity.class);
            context.startActivity(intent);
        }

        public void populate(Object obj) {
            myName.setText("Juntao Qiu");
        }

    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }

        public void populate(Object obj) {

        }
    }

    static class TweetViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView userName;
        TextView userTweet;

        Context context;
        public TweetViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            avatar = (ImageView)itemView.findViewById(R.id.user_avatar);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            userTweet = (TextView)itemView.findViewById(R.id.user_comment);
        }

        public void populate(Object obj) {
            Tweet tweet = (Tweet)obj;

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
}
