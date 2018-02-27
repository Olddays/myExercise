package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC381_InsertDeleteGetRandomOOneDuplicatesAllowed.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC381_InsertDeleteGetRandomOOneDuplicatesAllowedTest {

    public static void main(String[] args) {
        int input = 0;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testAnswer1(input);
        endTime = System.currentTimeMillis();
        System.out.println("InsertDeleteGetRandomOOneDuplicatesAllowed Answer 1 during time " + (endTime - startTime));
    }

    private static void testAnswer1(int board) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        boolean isInsert = randomizedCollection.insert(board);
        int insertRandom = randomizedCollection.getRandom();
        boolean isRemove = randomizedCollection.remove(board);
        System.out.print("isInsert " + isInsert + ", insertRandom " + insertRandom + ", isRemove " + isRemove);
        System.out.print("isInsert " + isInsert + ", insertRandom " + insertRandom + ", isRemove " + isRemove);
    }
}
