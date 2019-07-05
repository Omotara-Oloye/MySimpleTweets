package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{


    private List<Tweet> mTweets;
    Context context;

    //pass in the tweets array into the constructor

    public TweetAdapter (List<Tweet> tweets){
        mTweets = tweets;
    }

    //for each row, inflate the layout ahn dpass them into viewholder class
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

//    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    public String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }
    //bind the values to the element

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        //get data according to position
        Tweet tweet = mTweets.get(position);


        //populate the views according to this data

        viewHolder.tvUsername.setText(tweet.user.name);
        viewHolder.tvTweet.setText(tweet.body);
        viewHolder.tvName.setText("@" + tweet.user.screenName);
        viewHolder.tvTime.setText(" • " + getRelativeTimeAgo(tweet.createdAt));
        Glide.with(context).load(tweet.user.profileImageUrl).apply(RequestOptions.circleCropTransform()).into(viewHolder.ivProfilePic);
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    //create the viewholder class

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfilePic;
        public TextView tvUsername;
        public TextView tvTweet;
        public TextView tvName;
        public TextView tvTime;

        public ViewHolder(View itemView) {
            super(itemView);

            //preform findViewByID lookups

            ivProfilePic = (ImageView) itemView.findViewById(R.id.ivProfilePic);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvTweet = (TextView) itemView.findViewById(R.id.tvTweet);
            tvTime = (TextView) itemView.findViewById(R.id.tvCreated_At);

        }

    }
    // Clean all elements of the recycler
    public void clear() {
        mTweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> list) {
        mTweets.addAll(list);
        notifyDataSetChanged();
    }

}
