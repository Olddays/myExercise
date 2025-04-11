package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2780_MinimumIndexOfAValidSplit {

    // 主导的意思是占比大于一半
    // Beats 55.13%
    private static int minimumIndexMy1(List<Integer> nums) {
        int length = nums.size();
        Map<Integer, Integer> rightmap = new HashMap<>();
        int rightDominantCount = 0;
        int dominant = 0;
        for (Integer num : nums) {
            rightmap.put(num, rightmap.getOrDefault(num, 0) + 1);
            if (rightmap.get(num) > rightDominantCount) {
                rightDominantCount = rightmap.get(num);
                dominant = num;
            }
        }
        int leftDominantCount = 0;
        for (int i = 0; i < length; i++) {
            int num = nums.get(i);
            if (num == dominant) {
                leftDominantCount++;
                rightDominantCount--;
                // 此时rightDominant不可能会被替换，因为题目说了只有一个dominant且切分后也是这个
                if (leftDominantCount * 2 > i + 1 && rightDominantCount * 2 > length - 1 - i) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Beats 80.13%
    private static int minimumIndexAnswer1(List<Integer> nums) {
        int dominant = 0;
        int count = 0;

        for (int num : nums) { // 找出dominant
            if (count == 0) {
                dominant = num;
            }
            count += (num == dominant) ? 1 : -1;
        }

        count = 0;
        for (int num : nums) {
            if (num == dominant) {
                count++;
            }
        }
        int left = 0;
        int right = count;
        int length = nums.size();
        for (int i = 0; i < length - 1; i++) {
            int num = nums.get(i);
            if (num == dominant) {
                left++;
                right--;
            }
            if ((((i + 1) / 2) + 1 <= left) && (((length - i + 1) / 2) <= right)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {1, 2, 2},
                {1, 2, 2, 2},
                {2, 1, 3, 1, 1, 1, 7, 1, 2, 1},
                {3, 3, 3, 3, 7, 2, 2},
                {1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = minimumIndexMy1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("minimumIndex My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int num : numsList[i]) {
                nums.add(num);
            }
            startTime = System.currentTimeMillis();
            result = minimumIndexAnswer1(nums);
            endTime = System.currentTimeMillis();
            System.out.println("minimumIndex Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
