package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC026_RemoveDuplicatesFromSortedArray.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC026_RemoveDuplicatesFromSortedArrayTest {


    // 解题思路:要注意一个地方,不止要输出去重后长度为n,还要更改输入的数据序列内容,让输入数据的前n个位置为顺序去重后的数据

    public static void main(String[] args) {
//        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
//        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{1, 1};
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveDuplicatesFromSortedArray My 1 result " + result + " during time " + (endTime - startTime));

        nums = new int[]{1, 1};  // 注意 每次计算结束 nums的数据会被更改
        startTime = System.currentTimeMillis();
        result = testAnswer1(nums);
        endTime = System.currentTimeMillis();
        System.out.println("RemoveDuplicatesFromSortedArray Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1(int[] nums) {
        return getRemoveDuplicatesFromSortedArrayMy1(nums);
    }

    private static int testAnswer1(int[] nums) {
        return getRemoveDuplicatesFromSortedArrayAnswer1(nums);
    }

}
