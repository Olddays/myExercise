package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC670_MaximumSwap {
    /**
     * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
     * <p>
     * Example 1:
     * <p>
     * Input: 2736
     * Output: 7236
     * Explanation: Swap the number 2 and the number 7.
     * <p>
     * Example 2:
     * <p>
     * Input: 9973
     * Output: 9973
     * Explanation: No swap.
     * <p>
     * Note:
     * <p>
     * The given number is in the range [0, 108]
     */

    // 整体思路还行,但是错了,而且写法超级傻
    public static int getMaximumSwapMy1(int num) {
        String value = String.valueOf(num);
        int length = value.length();
        int[] cache = new int[value.length()];
        int max = 0;
        int maxNum = length - 1;
        // 构造cache数组和max,min数据
        for (int i = 0; i < length; i++) {
            int pow = (int) (Math.pow(10, length - 1 - i));
            cache[i] = num / pow;
            num = num % pow;
            if (cache[i] > max) {
                maxNum = i;
                max = cache[i];
            }
        }
        // 重新定位max状态
        if (maxNum == 0) {
            max = 0;
            for (int i = 1; i < length; i++) {
                if (cache[i] > max) {
                    maxNum = i;
                    max = cache[i];
                }
            }
            cache[maxNum] = cache[1];
            cache[1] = max;
        } else {
            if (max > 0) {
                cache[maxNum] = cache[0];
                cache[0] = max;
            }
        }
        int result = cache[length - 1];
        for (int i = 0; i < length - 1; i++) {
            result += cache[i] * Math.pow(10, length - 1 - i);
        }
        return result;
    }

    // 无法处理1993这种数据,目前方案2的思路是更换第一个最大值和最前面的值,应该是换最后一个最大值
    public static int getMaximumSwapMy2(int num) {
        char[] value = String.valueOf(num).toCharArray();
        int length = value.length;
        int[] cache = new int[length];
        // 构造cache数组和max,min数据
        for (int i = 0; i < length; i++) {
            cache[i] = value[i] - '0';
        }
        // 定位max位置,排除第一位
        int max = 0;
        int maxNum = length - 1;
        int changeNum = -1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (cache[j] > max) {
                    maxNum = j;
                    max = cache[j];
                }
            }
            if (maxNum > i) {
                changeNum = i;
                break;
            } else {
                max = 0;
            }
        }
        if (changeNum > -1) {
            cache[maxNum] = cache[changeNum];
            cache[changeNum] = max;
        }
        int result = cache[length - 1];
        for (int i = 0; i < length - 1; i++) {
            result += cache[i] * Math.pow(10, length - 1 - i);
        }
        return result;
    }

    public static int getMaximumSwapMy3(int num) {
        char[] value = String.valueOf(num).toCharArray();
        int length = value.length;
        int[] cache = new int[length];
        // 构造cache数组和max,min数据
        for (int i = 0; i < length; i++) {
            cache[i] = value[i] - '0';
        }
        // 定位max位置,排除第一位
        int max = 0;
        int maxNum = length - 1;
        int changeNum = -1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (cache[j] >= max) {
                    maxNum = j;
                    max = cache[j];
                }
            }
            // 排除9838这种状态
            if (maxNum > i && max > cache[i]) {
                changeNum = i;
                break;
            } else {
                max = 0;
            }
        }
        if (changeNum > -1) {
            cache[maxNum] = cache[changeNum];
            cache[changeNum] = max;
        }
        int result = cache[length - 1];
        for (int i = 0; i < length - 1; i++) {
            result += cache[i] * Math.pow(10, length - 1 - i);
        }
        return result;
    }

    /**
     * Use buckets to record the last position of digit 0 ~ 9 in this num.
     * <p>
     * Loop through the num array from left to right. For each position,
     * we check whether there exists a larger digit in this num (start from 9 to current digit).
     * We also need to make sure the position of this larger digit is behind the current one.
     * If we find it, simply swap these two digits and return the result.
     */
    public static int getMaximumSwapAnswer1(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) { // 从最大值9开始依次遍历比digits[i]大的值
                if (buckets[k] > i) { // 判断在bucket中的保存的值的位置是否大于当前的位置i
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
