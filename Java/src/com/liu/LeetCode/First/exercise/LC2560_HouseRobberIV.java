package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

public class LC2560_HouseRobberIV {

    // 有问题，仅能处理各一个拿一个的情况
    public static int minCapabilityMy1(int[] nums, int k) {
        int length = nums.length;
        if (length <= 0 || k > length) {
            return 0;
        }
        int result = nums[0];
        for (int i = 0; i < Math.min(2 * k + 1, length  + 2 - 2 * k); i += 2) {
            int cache = 0;
            int singularCache = Integer.MAX_VALUE;
            int traversalCount = 0;
            for (int j = i; j < length; j += 2) {
                cache = Math.max(nums[j], cache);
                traversalCount++;
                if (traversalCount % k == 0) {
                    singularCache = Math.min(cache, singularCache);
                    cache = nums[j];
                    if (length - j < 2 * k - 1) {
                        break;
                    }
                }
            }
            cache = 0;
            int dualCache = Integer.MAX_VALUE;
            traversalCount = 0;
            for (int j = i + 1; j < length; j += 2) {
                cache = Math.max(nums[j], cache);
                traversalCount++;
                if (traversalCount % k == 0) {
                    dualCache = Math.min(cache, dualCache);
                    cache = nums[j];
                    if (length - j < 2 * k - 1) {
                        break;
                    }
                }
            }
            result = Math.min(singularCache, traversalCount);
        }
        return result;
    }

    // 可以把问题转化成，从nums中取k个数字的组合，组合内取最大值，组合间取最小值，做一个缓存cache(int[][k])用于存位置
    // 即，本质是一个有条件（数字之间不相邻）的排列组合
    // Memory Limit Exceeded 存的数据太多了 内存溢出了 更换思路 select过程是不会重复的 所以可以在select的时候实现判断和赋值
    public static int minCapabilityMy2(int[] nums, int k) {
        int length = nums.length;
        if (length <= 0 || k > length) {
            return 0;
        }
        int[] input = new int[length];
        for (int i = 0; i < length; i++) {
            input[i] = i;
        }
        List<List<Integer>> locationList = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        selectMy1(input, locationList, inner, 0, k);
        int result = Integer.MAX_VALUE;
        for (List<Integer> cacheList: locationList) {
            int cache = Integer.MIN_VALUE;
            for (int i : cacheList) {
                cache = Math.max(cache, nums[i]);
            }
            result = Math.min(cache, result);
        }
        return result;
    }

    public static void selectMy1(int[] nums, List<List<Integer>> locationList, List<Integer> inner, int start, int k) {
        for(int i = start; i < nums.length; i++) {
            inner.add(nums[i]);
            if (inner.size() == k) {
                locationList.add(new ArrayList<>(inner));
                inner.remove(inner.size() - 1);
                continue;
            }
            selectMy1(nums, locationList, inner, i + 2, k);
            inner.remove(inner.size() - 1);
        }
    }

    // 优化内存 但递归还是会超时
    public static int minCapabilityMy3(int[] nums, int k) {
        int length = nums.length;
        if (length <= 0 || k > length) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        result.add(Integer.MAX_VALUE);
        List<Integer> inner = new ArrayList<>();
        selectMy2(nums, result, inner, 0, k);
        return result.get(0);
    }

    public static void selectMy2(int[] nums, List<Integer> result, List<Integer> inner, int start, int k) {
        for(int i = start; i < nums.length; i++) {
            inner.add(nums[i]);
            if (inner.size() == k) {
                int cache = Integer.MIN_VALUE;
                for (int num : inner) {
                    cache = Math.max(cache, num );
                }
                cache = Math.min(cache, result.get(0));
                result.remove(0);
                result.add(cache);
                inner.remove(inner.size() - 1);
                continue;
            }
            selectMy2(nums, result, inner, i + 2, k);
            inner.remove(inner.size() - 1);
        }
    }

    // 二分 + 动规
    public static int minCapabilityAnswer1(int[] nums, int k) {
        int length = nums.length;
        if (length <= 0 || k > length) {
            return 0;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int f0 = 0;
            int f1 = 0;
            for (int x : nums) {
                if (x > mid) {
                    f0 = f1;
                }
                else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            }
            if (f1 >= k) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return right;
    }
}
