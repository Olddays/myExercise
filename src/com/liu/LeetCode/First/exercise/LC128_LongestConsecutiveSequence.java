package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC128_LongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * <p>
     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * <p>
     * Your algorithm should run in O(n) complexity.
     */

    // 是可以作为解决方案的,但是Arrays.sort的时间复杂度大于O(n)
    // Java源码中说明 Arrays.sort() 方法使用的是快排,会有nlog(n)的时间复杂度
    public static int getLongestConsecutiveSequenceMy1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        Arrays.sort(nums);
        int cacheKey = nums[0];
        cache.put(nums[0], 1);
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                int cacheLength = cache.get(cacheKey) + 1;
                cache.put(cacheKey, cacheLength);
            } else if (nums[i] != nums[i - 1]) {
                // 值相等的时候应该跳过
                cacheKey = nums[i];
                cache.put(cacheKey, 1);
            }
        }
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            maxLength = Math.max(entry.getValue(), maxLength);
        }
        return maxLength;
    }

    //We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
    // Whenever a new element n is inserted into the map, do two things:
    // See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. Store (left + right + 1) as the associated value to key n into the map.
    // Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
    // Everything inside the for loop is O(1) so the total time is O(n). Please comment if you see something wrong. Thanks.
    public static int getLongestConsecutiveSequenceAnswer1(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
