package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC355_DesignTwitter {
    /**
     * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
     * <p>
     * postTweet(userId, tweetId): Compose a new tweet.
     * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * follow(followerId, followeeId): Follower follows a followee.
     * unfollow(followerId, followeeId): Follower unfollows a followee.
     * Example:
     * <p>
     * Twitter twitter = new Twitter();
     * <p>
     * // User 1 posts a new tweet (id = 5).
     * twitter.postTweet(1, 5);
     * <p>
     * // User 1's news feed should return a list with 1 tweet id -> [5].
     * twitter.getNewsFeed(1);
     * <p>
     * // User 1 follows user 2.
     * twitter.follow(1, 2);
     * <p>
     * // User 2 posts a new tweet (id = 6).
     * twitter.postTweet(2, 6);
     * <p>
     * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
     * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
     * twitter.getNewsFeed(1);
     * <p>
     * // User 1 unfollows user 2.
     * twitter.unfollow(1, 2);
     * <p>
     * // User 1's news feed should return a list with 1 tweet id -> [5],
     * // since user 1 is no longer following user 2.
     * twitter.getNewsFeed(1);
     */

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    public static class TwitterMy1 {

        private Map<Integer, Set<Integer>> mUser; // key: userId, value: userFollow
        private Map<Integer, Integer> mUserTweets; // key: tweetIdList, value: userId
        private List<Integer> mTweets; // key: tweetId

        public TwitterMy1() {
            mUser = new HashMap<>();
            mUserTweets = new HashMap<>();
            mTweets = new ArrayList<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            mUserTweets.put(tweetId, userId);
            mTweets.add(tweetId);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new ArrayList<>();
            Set<Integer> followList = mUser.get(userId);
            int resultSize = 0;
            for (int i = mTweets.size() - 1; i >= 0; i--) {
                if (resultSize >= 10) {
                    break;
                }
                int tweetId = mTweets.get(i);
                int tweetUserId = mUserTweets.get(tweetId);
                if (null != followList && followList.contains(tweetUserId) || tweetUserId == userId) {
                    result.add(tweetId);
                    resultSize++;
                }
            }
            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followerSet;
            if (mUser.containsKey(followerId)) {
                followerSet = mUser.get(followerId);
            } else {
                followerSet = new HashSet<>();
            }
            followerSet.add(followeeId);
            mUser.put(followerId, followerSet);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (mUser.containsKey(followerId)) {
                Set<Integer> followerSet = mUser.get(followerId);
                followerSet.remove(followeeId);
                mUser.put(followerId, followerSet);
            }
        }
    }
}
