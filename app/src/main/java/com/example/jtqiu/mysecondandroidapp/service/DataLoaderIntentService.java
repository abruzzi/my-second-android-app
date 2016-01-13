package com.example.jtqiu.mysecondandroidapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.example.jtqiu.mysecondandroidapp.tweet.TweetListActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DataLoaderIntentService extends IntentService {

    public DataLoaderIntentService() {
        super(DataLoaderIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("service", intent.getAction());
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getAssets().open("tweets.json"));
            List<Tweet> tweets = Arrays.asList(gson.fromJson(inputStreamReader, Tweet[].class));

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(TweetListActivity.ResponseReceiver.TWEETS_READY);
            broadcastIntent.putExtra("tweets", (Serializable) tweets);
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            localBroadcastManager.sendBroadcast(broadcastIntent);

            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
