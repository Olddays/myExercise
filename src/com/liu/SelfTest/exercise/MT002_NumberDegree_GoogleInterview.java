package com.liu.SelfTest.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baidu on 09/01/2018.
 */
public class MT002_NumberDegree_GoogleInterview {

    // 给定元素全为非负整数的非空数组nums,数组的度(degree)等于出现最多元素的次数.
    // 找到具有和nums相同度的连续子串的最小长度.
    // example:
    // input: [1,2,2,3,1]
    // output: 2
    //
    // input: [1,2,2,3,1,4,2]
    // output: 6

    public static int getNumberDegreeMy1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Map<Integer, Integer> sizeCache = new HashMap<>();
        Map<Integer, Integer> startCache = new HashMap<>();
        Map<Integer, Integer> endCache = new HashMap<>();
        int maxSize = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int size = sizeCache.getOrDefault(num, 0) + 1;
            sizeCache.put(num, size);
            if (maxSize < size) {
                maxSize = size;
            }
            if (startCache.get(num) == null) {
                startCache.put(num, i);
            }
            endCache.put(num, i);
        }
        List<Integer> maxCache = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sizeCache.entrySet()) {
            if (entry.getValue() == maxSize) {
                maxCache.add(entry.getKey());
            }
        }
        result = Integer.MAX_VALUE;
        for (int num : maxCache) {
            result = Math.min(endCache.get(num) - startCache.get(num) + 1, result);
        }
        return result;
    }

    // 相比自己的方案少了一个用于标识End位置的Map,使用的方案是,利用frequency和i来做,当前的位置是i,距离就是i-startMap.get(num)+1,
    // 而frequency标识目前最大的值出现的次数,通过当count.get(num)>frequency的时候来进行数据更新即可
    public static int getNumberDegreeAnswer1(int[] nums) {
        int length = nums.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        result = Integer.MAX_VALUE;
        int frequency = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (!startIndex.containsKey(num)) {
                startIndex.put(num, i);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) == frequency) {
                result = Math.min(i - startIndex.get(num) + 1, result);
            } else if (count.get(num) > frequency) {
                result = i - startIndex.get(num) + 1;
                frequency = count.get(nums[i]);
            }
        }
        return result;
    }
}
