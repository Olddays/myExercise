package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD25_FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}
