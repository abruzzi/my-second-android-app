package com.example.jtqiu.mysecondandroidapp.tweet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.example.jtqiu.mysecondandroidapp.service.DataLoaderIntentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TweetListActivity extends AppCompatActivity {
    @Bind(value = R.id.tweet_recycler_list) RecyclerView recyclerView;

    private TweetListRecyclerAdaptor tweetListRecycleAdaptor = new TweetListRecyclerAdaptor();
    private BroadcastReceiver receiver = new ResponseReceiver();

    public class ResponseReceiver extends BroadcastReceiver {
        public static final String TWEETS_READY = "com.example.jtqiu.mysecondandroidapp.tweet.TweetListActivity.TWEETS_READY";

        @Override
        public void onReceive(Context context, Intent intent) {
            Serializable tweets = intent.getSerializableExtra("tweets");
            tweetListRecycleAdaptor.setTweetList((List<Tweet>) tweets);
            tweetListRecycleAdaptor.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        ButterKnife.bind(this);

        recyclerView.setAdapter(tweetListRecycleAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = new Intent(ResponseReceiver.TWEETS_READY);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(ResponseReceiver.TWEETS_READY);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(receiver);
    }
}
