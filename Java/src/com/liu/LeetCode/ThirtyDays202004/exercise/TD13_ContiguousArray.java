package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.HashMap;
import java.util.Map;

public class TD13_ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length < 2) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int zero = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                zero--;
            }
            if (zero == 0) {
                result = i + 1;
            }
            if (!map.containsKey(zero)) {
                map.put(zero, i);
                // 用于记录每个可能的合的起始位置,比如前一个值能得到1,则有(1,1),前两个值能得到2,则有(2,2)
            } else {
                result = Math.max(result, i - map.get(zero));
                // 比如 前三个值得到了1,然后前五个值又得到了1,那么此时就可以认为有5-3=2,这两个值的合一定为0
            }
        }
        return result;
    }
}
