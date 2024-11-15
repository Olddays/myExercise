package com.liu.LeetCode.FifteenPatterns.FastSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class LC287_FindTheDuplicateNumber {

    private static int findDuplicateMy1(int[] nums) { // Accepted 性能没那么好
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    private static int findDuplicateAnswer1(int[] nums) { // 因为题目限制了所以可以这样做，性能会好很多
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[][] nsSet = new int[][]{
                {1, 3, 4, 2, 2},
                {3, 1, 3, 4, 2},
                {3, 3, 3, 3, 3},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findDuplicateMy1(nsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findDuplicate My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findDuplicateMy1(nsSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findDuplicate Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
