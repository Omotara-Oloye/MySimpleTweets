package com.codepath.apps.restclienttemplate;

import com.codepath.apps.restclienttemplate.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Tweet {

    //list out all the attributes

    public String body;
    public long uid; //database for the tweets
    public User user;
    public String createdAt;
    public String mediaURL;




    //deseralize the data

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        JSONObject entities = jsonObject.getJSONObject("entities");


        //extract all the values from JSON
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));

                if (entities.has("media")) {
                   JSONArray mediaItems = entities.getJSONArray("media");
                   tweet.mediaURL = mediaItems.getJSONObject(0).getString("media_url_https");
               }
              else{
                  tweet.mediaURL = null;
                }

        return tweet;
    }
}
