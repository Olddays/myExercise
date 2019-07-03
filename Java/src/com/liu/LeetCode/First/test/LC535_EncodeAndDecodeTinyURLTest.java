package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC535_EncodeAndDecodeTinyURL.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC535_EncodeAndDecodeTinyURLTest {

    public static void main(String[] args) {
        String[] urls = new String[]{
                "https://leetcode.com/problems/design-tinyurl"
        };
        long startTime;
        String result;
        long endTime;

        for (String url : urls) {
            startTime = System.currentTimeMillis();
            result = testEncodeMy1(url);
            endTime = System.currentTimeMillis();
            System.out.println("EncodeAndDecodeTinyURL encode My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testDecodeMy1(result);
            endTime = System.currentTimeMillis();
            System.out.println("EncodeAndDecodeTinyURL decode My 2 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testEncodeAnswer1(url);
            endTime = System.currentTimeMillis();
            System.out.println("EncodeAndDecodeTinyURL encode My 3 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testDecodeAnswer1(result);
            endTime = System.currentTimeMillis();
            System.out.println("EncodeAndDecodeTinyURL decode Answer 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static String testEncodeMy1(String url) {
        return encodeMy1(url);
    }

    private static String testDecodeMy1(String tinyUrl) {
        return decodeMy1(tinyUrl);
    }

    private static String testEncodeAnswer1(String url) {
        return encodeAnswer1(url);
    }

    private static String testDecodeAnswer1(String tinyUrl) {
        return decodeAnswer1(tinyUrl);
    }
}
