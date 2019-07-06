package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class ComposeActivity extends AppCompatActivity {

    Button sendTweet;
    Button cancel;
    TwiiterClient client;
    EditText draftTweet;
    TextView tvUsername;
    TextView tvName;
    ImageView ivProfilePic;
    public String username;
    public String name;
    public String profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        sendTweet = findViewById(R.id.sendTweet);
        cancel = findViewById(R.id.cancel);
        client = TwitterApp.getRestClient(this);
        draftTweet = findViewById(R.id.draftTweet);

        // connect views to variables
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvName = (TextView) findViewById(R.id.tvName);
        ivProfilePic = (ImageView) findViewById(R.id.ivProfilePic);

        username = getIntent().getStringExtra("tvUsername");
        name = getIntent().getStringExtra("tvName");
        profilePic = getIntent().getStringExtra("ivProfilepic");


        tvUsername.setText("@" + username);
        tvName.setText(name);
        Glide.with(ComposeActivity.this).load(profilePic)
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfilePic);



        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.twitter_blue)));


        sendTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit(v);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // closes the activity and returns to first screen
                finish();
            }
        });
    }

    public void onSubmit(View v) {
            String tweetText = draftTweet.getText().toString();
            if(tweetText.length() > 280){
                Toast.makeText(ComposeActivity.this, "The tweet is too long", Toast.LENGTH_LONG).show();
            }
            else {
                client.sendTweet(draftTweet.getText().toString(), new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        Log.d("TwitterClient", response.toString());
                        try {
                            Tweet tweet = Tweet.fromJson(response);
                            Intent i = new Intent();
                            i.putExtra("tweet", Parcels.wrap(tweet));
                            setResult(RESULT_OK, i);
                            // closes the activity and returns to first screen
                            finish();
                        } catch (JSONException error) {
                            error.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        Log.d("TwitterClient", errorResponse.toString());
                        throwable.printStackTrace();
                    }
                });
            }
    }




}
