package com.liu.LeetCode.First.test;

import java.util.List;

import static com.liu.LeetCode.First.exercise.LC355_DesignTwitter.TwitterMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC355_DesignTwitterTest {

    public static void main(String[] args) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("DesignTwitter My 1 during time " + (endTime - startTime));
    }

    private static void testMy1() {
        TwitterMy1 twitter = new TwitterMy1();
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        List<Integer> list = twitter.getNewsFeed(1);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        list = twitter.getNewsFeed(1);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        list = twitter.getNewsFeed(1);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
