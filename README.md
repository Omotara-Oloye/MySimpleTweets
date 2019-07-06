# Project 3 - My Simple Tweets

**Name of your app** is an android app that is a simplified version of the Twitter Application. User are able to tweet, view tweets, and participate in social media environment.

Submitted by: Omotara Oloye

Time spent: 20 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can sign in to Twitter using OAuth login (2 points)
* [x] User can view the tweets from their home timeline (4 points)
    * [x] User should be displayed the username, name, and body for each tweet
    * [x] User should be displayed the relative timestamp for each tweet "8m", "7h"
* [ ] User can compose a new tweet (4 points)
    * [x] User can click a "Compose" icon in the App Bar on the top right
    * [x] User can then enter a new tweet and post this to Twitter
    * [x] User is taken back to home timeline with new tweet visible in timeline
    * [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh


The following **stretch** features are implemented:

* [x] While composing a tweet, user can see a character counter with characters remaining for tweet out of 280 (1 point)
* [x] User can refresh timeline of tweets by pulling down to refresh (i.e pull-to-refresh) (1 point)
* [x] Improve the user interface and theme the app to feel "twitter branded" with colors and styles (1 to 5 points)
* [x] When any background or network task is happening, user sees an indeterminate progress indicator (1 point)
* [ ] User can "reply" to any tweet from their home timeline (1 point)
    * [ ] The user that wrote the original tweet is automatically "@" replied in compose
* [ ] User can click on a tweet to be taken to a "detail view" of that tweet (2 points)
    * [ ] User can take favorite (and unfavorite) or reweet actions on a tweet
* [x] User can see embedded image media within a tweet on list or detail view. (1 point)
* [ ] User can view more tweets as they scroll with Endless Scrolling. Number of tweets is unlimited. Refer to the endless scrolling conceptual guide for more details. (2 points)
* [ ] Compose activity is replaced with a modal overlay (2 points)
* [x] Links in tweets are clickable and will launch the web browser (see autolink) (1 point)
* [x] Use Parcelable instead of Serializable leveraging the popular Parceler library. (1 point)
* [x] Replace all icon drawables and other static image assets with vector drawables where appropriate. (1 point)
* [ ] User can view following / followers list through any profile they view. (2 points)
* [ ] Apply the popular ButterKnife annotation library to reduce view boilerplate. (1 point)
* [ ] Experiment with fancy scrolling effects on the Twitter profile view. (2 points)
* [ ] User can open the twitter app offline and see last loaded tweets persisted into SQLite (2 points)


The following **additional** features are implemented:

* [x] Added User Client to create profile page for logged-in user
* [x] Added User Client to customize the compose tweet page
* [x] Added a floating action button for the compose tweet feature

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/Omotara-Oloye/MySimpleTweets/blob/master/MySimpleTweet.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

There were a lot of problems in terms of API access because all 180 students were using the same API key for one week. This caused the applications to crash and we had to create new API keys that continued to crash again.

## License

    Copyright [2019] [Omotara Oloye]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
