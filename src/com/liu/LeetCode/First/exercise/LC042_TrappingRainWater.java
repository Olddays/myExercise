package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC042_TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     * <p>
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     * <p>
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     */

    // height[i] > height[j]缺少考虑,此处的前提是height[i]要大于后面所有的值,所以不应该如此比较
    public static int getTrappingRainWaterMy1(int[] height) {
        int length = height.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] <= 0) {
                continue;
            }
            boolean hasHigher = false;
            int cache = i;
            for (int j = i + 1; j < length; j++) {
                if (height[j] >= height[i]) {
                    cache = j;
                    break;
                }
            }
            if (cache > i) {
                result += height[i] * (cache - 1 - i);
                for (int k = i + 1; k < cache; k++) {
                    result -= height[k]; // 减去被占用的区域
                }
                hasHigher = true;
                i = cache - 1;
            }
            if (!hasHigher) {
                cache = i;
                for (int j = i + 1; j < length; j++) {
                    cache = height[i] > height[j] ? i : j;
                }
                if (cache > i) {
                    result += height[cache] * (cache - 1 - i);
                    for (int k = i + 1; k < cache; k++) {
                        result -= height[k]; // 减去被占用的区域
                    }
                    i = cache - 1;
                }
            }
        }
        return result;
    }

    // 要注意,height的最后一个值不需要进行处理,所以最外侧的for循环的判断条件是i<length-1
    public static int getTrappingRainWaterMy2(int[] height) {
        int length = height.length;
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            if (height[i] <= 0) {
                continue;
            }
            boolean hasHigher = false;
            int cache = i;
            for (int j = i + 1; j < length; j++) {
                if (height[j] >= height[i]) {
                    cache = j;
                    break;
                }
            }
            if (cache > i) {
                result += height[i] * (cache - 1 - i);
                for (int k = i + 1; k < cache; k++) {
                    result -= height[k]; // 减去被占用的区域
                }
                hasHigher = true;
                i = cache - 1;
            }
            if (!hasHigher) {
                cache = i + 1;
                for (int j = i + 1; j < length; j++) {
                    cache = height[cache] > height[j] ? cache : j;
                }
                if (cache > i) {
                    result += height[cache] * (cache - 1 - i);
                    for (int k = i + 1; k < cache; k++) {
                        result -= height[k]; // 减去被占用的区域
                    }
                    i = cache - 1;
                }
            }
        }
        return result;
    }
}
