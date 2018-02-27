package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC055_JumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Determine if you are able to reach the last index.
     * <p>
     * For example:
     * A = [2,3,1,1,4], return true.
     * <p>
     * A = [3,2,1,0,4], return false.
     */

    // 没有考虑输入为空或只有一个值
    public static boolean getJumpGameMy1(int[] nums) {
        int nowLength = 0; // 现在的位置
        int max = 0; // 目前最多能到的位置
        int cache = max;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, max + nums[i]);
            if (i == nowLength) {
                nowLength = max;
            }
            if (cache < max) {
                cache = max;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean getJumpGameMy2(int[] nums) {
        if (nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }
        int nowLength = 0; // 现在的位置
        int max = 0; // 目前最多能到的位置
        int cache = max;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, max + nums[i]);
            if (i == nowLength) {
                nowLength = max;
            }
            if (cache < max) {
                cache = max;
            } else {
                return false;
            }
        }
        return true;
    }

    // 可以看做一个DP问题进行处理,子问题即当前能到达的最大长度
    // 没有考虑[0,1]作为输入
    public static boolean getJumpGameMy3(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length]; // dp[i]表示nums[0:i]的最大和子串之和
        dp[0] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            // 对于nums[0]已经处理过了,所以跳过nums[0],i从1开始遍历,且对于是否能到达终点这一问题,最后一位无用
            dp[i] = nums[i] + i; // 前一个最大子串和大于0则增加,否则即可以认为此值对于增加max无用
            if (nums[i] == 0) {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] > dp[i]) {
                        break;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 可以看做一个DP问题进行处理,子问题即当前能到达的最大长度
    // 没有考虑[2, 0, 0]这种直接到达结尾的情况
    // 且倒序的for循环并没有起到作用
    public static boolean getJumpGameMy4(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[length]; // dp[i]表示nums[0:i]的最大和子串之和
        dp[0] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            // 对于nums[0]已经处理过了,所以跳过nums[0],i从1开始遍历,且对于是否能到达终点这一问题,最后一位无用
            dp[i] = nums[i] + i; // 前一个最大子串和大于0则增加,否则即可以认为此值对于增加max无用
            if (nums[i] == 0) {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] > dp[i]) {
                        break;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // 可以看做一个DP问题进行处理,子问题即当前能到达的最大长度
    public static boolean getJumpGameMy5(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int[] dp = new int[length]; // dp[i]表示nums[0:i]的最大和子串之和
        dp[0] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            // 对于nums[0]已经处理过了,所以跳过nums[0],i从1开始遍历,且对于是否能到达终点这一问题,最后一位无用
            dp[i] = nums[i] + i; // 前一个最大子串和大于0则增加,否则即可以认为此值对于增加max无用
            if (nums[i] == 0) {
                boolean allAbove = true;
                for (int j = i; j >= 0; j--) {
                    if (dp[j] > dp[i] || dp[j] >= length - 1) {
                        allAbove = false;
                        break;
                    }
                }
                if (allAbove) {
                    return false;
                }
            }
        }
        return true;
    }

    // 设定一个标记作为可以到达的最大位置,如果循环中发现循环到了某个大于最大可到达位置的位置时,就返回false
    public static boolean getJumpGameAnswer1(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + i);
        }
        return true;
    }
}
