package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC414_ThirdMaximumNumber {
    /**
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     * <p>
     * Example 1:
     * <p>
     * Input: [3, 2, 1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: The third maximum is 1.
     * <p>
     * Example 2:
     * <p>
     * Input: [1, 2]
     * <p>
     * Output: 2
     * <p>
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * <p>
     * Example 3:
     * <p>
     * Input: [2, 2, 3, 1]
     * <p>
     * Output: 1
     * <p>
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */

    public static int getThirdMaximumNumberAnswer1(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) {
                continue;
            }
            if (max1 == null || n > max1) { // 找最大的,如果最大的大于max1,则赋值给max1,且依次推给接下来的max2和max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        if (max3 == null) {
            return max1;
        } else {
            return max3;
        }
    }
}
