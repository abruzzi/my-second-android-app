package com.example.jtqiu.mysecondandroidapp.tweet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.model.Tweet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TweetListActivity extends AppCompatActivity {
    @Bind(value = R.id.tweet_recycler_list) RecyclerView recyclerView;

    private TweetListRecyclerAdaptor tweetListRecycleAdaptor = new TweetListRecyclerAdaptor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        ButterKnife.bind(this);

        recyclerView.setAdapter(tweetListRecycleAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TweetFetcher fetcher = new TweetFetcher();
        fetcher.execute();
    }

    private void bindData(List<Tweet> tweets) {
        tweetListRecycleAdaptor.setTweetList(tweets);
        tweetListRecycleAdaptor.notifyDataSetChanged();
    }

    private class TweetFetcher extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(getAssets().open("tweets.json"));
                List<Tweet> tweets = Arrays.asList(gson.fromJson(inputStreamReader, Tweet[].class));
                bindData(tweets);
                Log.e("TweetList", tweets.toString());
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
