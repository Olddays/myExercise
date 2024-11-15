package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC2560_HouseRobberIV.*;

public class LC2560_HouseRobberIVTest {
    /**
     * There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
     *
     * The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
     *
     * You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
     *
     * You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
     *
     * Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,5,9], k = 2
     * Output: 5
     * Explanation:
     * There are three ways to rob at least 2 houses:
     * - Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
     * - Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
     * - Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
     * Therefore, we return min(5, 9, 9) = 5.
     * Example 2:
     *
     * Input: nums = [2,7,9,3,1], k = 2
     * Output: 2
     * Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * 1 <= k <= (nums.length + 1)/2
     *
     */

    public static void main(String[] args) {
        int[][] numsList = {
                {2,3,5,9},
                {2,7,9,3,1},
                {5038,3053,2825,3638,4648,3259,4948,4248,4940,2834,109,5224,5097,4708,2162,3438,4152,4134,551,3961,2294,3961,1327,2395,1002,763,4296,3147,5069,2156,572,1261,4272,4158,5186,2543,5055,4735,2325,1206,1019,1257,5048,1563,3507,4269,5328,173,5007,2392,967,2768,86,3401,3667,4406,4487,876,1530,819,1320,883,1101,5317,2305,89,788,1603,3456,5221,1910,3343,4597},
        };
        int[] kList = {
                2,
                2,
                28,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = testMy1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("HouseRobberIV My 1 times " + i + " result " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < 2; i++) {
            startTime = System.currentTimeMillis();
            result = testMy2(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("HouseRobberIV My 2 times " + i + " result " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < 2; i++) {
            startTime = System.currentTimeMillis();
            result = testMy3(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("HouseRobberIV My 3 times " + i + " result " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = testAnswer1(numsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("HouseRobberIV Answer 1 times " + i + " result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int[] nums, int k) {
        return minCapabilityMy1(nums, k);
    }

    private static int testMy2(int[] nums, int k) {
        return minCapabilityMy2(nums, k);
    }

    private static int testMy3(int[] nums, int k) {
        return minCapabilityMy3(nums, k);
    }

    private static int testAnswer1(int[] nums, int k) {
        return minCapabilityAnswer1(nums, k);
    }
}
