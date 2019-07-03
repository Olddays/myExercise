package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC605_CanPlaceFlowers {
    /**
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     * <p>
     * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     * <p>
     * Example 1:
     * <p>
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: True
     * <p>
     * Example 2:
     * <p>
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: False
     * <p>
     * Note:
     * <p>
     * The input array won't violate no-adjacent-flowers rule.
     * The input array size is in the range of [1, 20000].
     * n is a non-negative integer which won't exceed the input array size.
     */

    public static boolean getCanPlaceFlowersMy1(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 0) {
            return false;
        }
        // 这个写法很不优雅....
        int[] bedCache = new int[length + 5];
        bedCache[0] = 0;
        bedCache[1] = 0;
        bedCache[length + 1] = 0;
        bedCache[length + 2] = 0;
        bedCache[length + 3] = 1;
        System.arraycopy(flowerbed, 0, bedCache, 2, length);
        int cache = 0;
        int totalSize = 0;
        for (int i = 0; i < bedCache.length; i++) {
            if (bedCache[i] == 1) {
                int possibleSize = (i - cache - 2) / 2;
                totalSize += possibleSize > 0 ? possibleSize : 0;
                cache = i;
            }
        }
        return totalSize >= n;
    }

    // Greedily place a flower at every vacant spot encountered from left to right!
    public static boolean getCanPlaceFlowersAnswer1(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if (length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                // get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count == n;
    }
}
