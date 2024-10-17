package com.liu.LeetCode.Second.PrefixSum;

public class LC303_RangeSumQuery_Immutable {

    static class NumArray {

        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                this.nums[i] = this.nums[i - 1] + nums[i];
            }
        }

        private int sumRange(int left, int right) {
            if (left == 0) {
                return this.nums[right];
            }
            return this.nums[right] - this.nums[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        int[] is = new int[]{0, 2, 0};
        int[] js = new int[]{2, 5, 5};
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < is.length; i++) {
            startTime = System.currentTimeMillis();
            result = testMy1(nums, is[i], js[i]);
            endTime = System.currentTimeMillis();
            System.out.println("RangeSumQuery Immutable My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums, int i, int j) {
        NumArray numArray = new NumArray(nums);
        return numArray.sumRange(i, j);
    }

}
