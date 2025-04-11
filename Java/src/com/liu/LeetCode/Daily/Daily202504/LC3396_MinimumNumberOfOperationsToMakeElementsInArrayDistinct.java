package com.liu.LeetCode.Daily.Daily202504;

public class LC3396_MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    // Beats 98.39%
    private static int minimumOperationsMy1(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        int count = 0;
        // num[i]最大值是100，就不需要用Set或Map了，直接用数组即可
        int[] cache = new int[101];
        for (int i = length - 1; i >= 0; i--) {
            if (cache[nums[i]] > 0) {
                break;
            }
            cache[nums[i]]++;
            count++;
        }
        if ((length - count) % 3 == 0) {
            return (length - count) / 3;
        }
        return (length - count) / 3 + 1;
    }
    // 更简洁且效率更高
    // Beats 100%
    private static int minimumOperationsAnswer1(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(seen[nums[i]])
                return i / 3 + 1;
            else seen[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {5, 5},
                {1, 2, 3, 4, 2, 3, 3, 5, 7},
                {4, 5, 6, 4, 4},
                {6, 7, 8, 9},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minimumOperationsMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minimumOperations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minimumOperationsAnswer1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minimumOperations Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
