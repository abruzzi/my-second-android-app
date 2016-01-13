package com.example.jtqiu.mysecondandroidapp.tweet.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jtqiu.mysecondandroidapp.R;
import com.example.jtqiu.mysecondandroidapp.tweet.UserProfileActivity;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
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
