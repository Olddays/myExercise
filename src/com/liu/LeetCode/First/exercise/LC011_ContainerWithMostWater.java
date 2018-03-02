package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/14.
 */
public class LC011_ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     */

    // 题意就是求面积,思路上最差也可以用O(n²)来做,但是由于存在对称性,肯定可以优化为O(nlog(n))
    // 当然,由于是存放水,所以要以最短的边来算,面积等于两点间距乘两点的短边

    // 是正确解发,但是超时了,时间复杂度为O(n!)
    public static int getContainerWithMostWaterMy1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int shortOne = height[i] < height[j] ? height[i] : height[j];
                int square = shortOne * (j - i);
                max = max > square ? max : square;
            }
        }
        return max;
    }

    // 左右夹逼的方式处理,要证明这个方法的正确,需要注意一点:
    // 由于求的是两点的短高乘两点的间距,假设有a1 = 2,a2 = 5,a3 = 2,a4 = 3,a5 = 1
    // 当a1 < a4时,a1与a2和a3的组成的面积分别为 1 * (2-1) = 1 和 1 * (3 - 1) = 2,而a1与a4组成的面积为 1 * (4 - 1) = 3
    // 即一般的:我们需要证明,当ai < aj(i < j)时,ai与ak(i < k < j)所有可能组成的面积均不会大于ai与aj组成的面积
    // 即:ai * (j - i) > ai * (k - i),由于k < j所以此式肯定成立,反之ai > aj时亦然
    // 由于我们是从两侧开始往中间进行,所以i从0开始j从length-1开始取值,故k <= j,而k != j恒成立,故k < j恒成立
    // 此算法时间复杂度为O(n)
    public static int getContainerWithMostWaterAnswer1(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int nowSquare = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, nowSquare);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
