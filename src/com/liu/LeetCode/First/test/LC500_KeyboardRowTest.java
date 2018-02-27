package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC500_KeyboardRow.getKeyboardRowMy1;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC500_KeyboardRowTest {

    public static void main(String[] args) {
        String[][] wordsSet = {
                {"Hello", "Alaska", "Dad", "Peace"}
        };
        long startTime;
        String[] result;
        long endTime;

        for (String[] words : wordsSet) {
            startTime = System.currentTimeMillis();
            result = testMy1(words);
            endTime = System.currentTimeMillis();
            System.out.println("KeyboardRow My 1 result.length " + result.length + " during time " + (endTime - startTime));
            for (String word : result) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    private static String[] testMy1(String[] words) {
        return getKeyboardRowMy1(words);
    }
}
