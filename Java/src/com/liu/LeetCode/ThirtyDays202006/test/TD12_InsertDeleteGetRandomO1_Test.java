package com.liu.LeetCode.ThirtyDays202006.test;

import com.liu.LeetCode.ThirtyDays202006.exercise.TD12_InsertDeleteGetRandomO1.RandomizedSetMy1;
import com.liu.LeetCode.ThirtyDays202006.exercise.TD12_InsertDeleteGetRandomO1.RandomizedSetMy2;

/**
 * Created by Liu on 2020/6/12.
 */
public class TD12_InsertDeleteGetRandomO1_Test {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        RandomizedSetMy1 randomSetMy1 = new RandomizedSetMy1();
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.insert(1) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.remove(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.insert(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.getRandom() + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.remove(1) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.insert(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy1.getRandom() + " during time " + (endTime - startTime));
        System.out.println();

        RandomizedSetMy2 randomSetMy2 = new RandomizedSetMy2();
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.insert(1) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.remove(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.insert(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.getRandom() + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.remove(1) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.insert(2) + " during time " + (endTime - startTime));
        System.out.println("TD12_InsertDeleteGetRandomO1 My 1 " + randomSetMy2.getRandom() + " during time " + (endTime - startTime));
        System.out.println();
    }
}
