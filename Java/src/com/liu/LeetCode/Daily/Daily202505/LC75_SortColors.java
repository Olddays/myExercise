package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC75_SortColors {

    // Beats 21.22%
    private static void sortColorsMy1(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            int cache = 0;
            while (cache < map.getOrDefault(i, 0)) {
                nums[count++] = i;
                cache++;
            }
        }
    }
    private static void sortColorsMy2(int[] nums) {
        int read = 0;
        int zeroes = 0;
        int twos = nums.length - 1;
        while (read <= twos) {
            if (nums[read] == 0) {
                int temp = nums[read];
                nums[read] = nums[zeroes];
                nums[zeroes] = temp;
                read++;
                zeroes++;
            } else if (nums[read] == 2) {
                int temp = nums[read];
                nums[read] = nums[twos];
                nums[twos] = temp;
                twos--;
            } else {
                read++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {0},
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
        };
        int[][] resultList = new int[][]{
                {0},
                {0, 0, 1, 1, 2, 2},
                {0, 1, 2},
        };
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            sortColorsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("sortColors My1 result" + i + " " + Arrays.toString(numsList[i]) + " result " + Utils.compareResult(numsList[i], resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            sortColorsMy2(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("sortColors My2 result" + i + " " + Arrays.toString(numsList[i]) + " result " + Utils.compareResult(numsList[i], resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
