package com.example.jtqiu.mysecondandroidapp.tweet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Image;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;

import org.w3c.dom.Text;

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
        if(position != 0 && position != tweetList.size()+1 && holder.getItemViewType() == NORMAL) {
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

        public HeaderViewHolder(View itemView) {
            super(itemView);
            heroImage = (ImageView) itemView.findViewById(R.id.hero_image);
            myAvatar = (ImageView) itemView.findViewById(R.id.my_avatar);
            myName = (TextView) itemView.findViewById(R.id.my_name);
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

        public TweetViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.user_avatar);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            userTweet = (TextView)itemView.findViewById(R.id.user_comment);
        }

        public void populate(Object obj) {
            Tweet tweet = (Tweet)obj;
            avatar.setImageURI(null);
            userName.setText(tweet.getSender().getUsername());
            userTweet.setText(tweet.getContent());
        }
    }
}
