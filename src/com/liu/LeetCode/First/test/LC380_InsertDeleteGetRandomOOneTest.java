package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC380_InsertDeleteGetRandomOOne.RandomizedSet;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC380_InsertDeleteGetRandomOOneTest {

    public static void main(String[] args) {
        int input = 0;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testAnswer1(input);
        endTime = System.currentTimeMillis();
        System.out.println("InsertDeleteGetRandomOOne Answer 1 during time " + (endTime - startTime));
    }

    private static void testAnswer1(int board) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean isInsert = randomizedSet.insert(board);
        int insertRandom = randomizedSet.getRandom();
        boolean isRemove = randomizedSet.remove(board);
        System.out.print("isInsert " + isInsert + ", insertRandom " + insertRandom + ", isRemove " + isRemove);
        System.out.print("isInsert " + isInsert + ", insertRandom " + insertRandom + ", isRemove " + isRemove);
    }
}
