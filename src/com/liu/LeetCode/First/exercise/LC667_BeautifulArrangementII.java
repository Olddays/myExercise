package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC667_BeautifulArrangementII {
    /**
     * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
     * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
     * <p>
     * If there are multiple answers, print any of them.
     * <p>
     * Example 1:
     * <p>
     * Input: n = 3, k = 1
     * Output: [1, 2, 3]
     * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
     * <p>
     * Example 2:
     * <p>
     * Input: n = 3, k = 2
     * Output: [1, 3, 2]
     * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
     * <p>
     * Note:
     * <p>
     * The n and k are in the range 1 <= k < n <= 104.
     */

    public static int[] getBeautifulArrangementIIMy1(int n, int k) {
        int[] result = new int[n];
        Map<Integer, List<List<Integer>>> cache = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n - i; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(j);
                list.add(i + j);
                List<List<Integer>> cacheList;
                if (cache.containsKey(i)) {
                    cacheList = cache.get(i);
                } else {
                    cacheList = new ArrayList<>();
                }
                cacheList.add(list);
                cache.put(i, cacheList);
            }
        }
        List<Integer> resultCache = new ArrayList<>();
        for (int i = k; i >= 1; i--) {
            List<List<Integer>> lists = cache.get(i);
            for (List<Integer> list : lists) {
                if (resultCache.isEmpty()) {
                    resultCache.add(list.get(0));
                    resultCache.add(list.get(1));
                } else {
                    if (!resultCache.contains(list.get(1))
                            && !resultCache.contains(list.get(0))) {
                        resultCache.add(list.get(0));
                        resultCache.add(list.get(1));
                    } else if(!resultCache.contains(list.get(0))) {
                        resultCache.add(list.get(0));
                    } else if(!resultCache.contains(list.get(1))) {
                        resultCache.add(list.get(1));
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            result[i] = resultCache.get(i);
        }
        return result;
    }

    /**
     * if you have n number, the maximum k can be n - 1;
     * if n is 9, max k is 8.
     * This can be done by picking numbers interleavingly from head and tail,
     * <p>
     * // start from i = 1, j = n;
     * // i++, j--, i++, j--, i++, j--
     * <p>
     * 1   2   3   4   5
     * 9   8   7   6
     * out: 1 9 2 8 3 7 6 4 5
     * dif:  8 7 6 5 4 3 2 1
     * <p>
     * Above is a case where k is exactly n - 1
     * When k is less than that, simply lay out the rest (i, j) in incremental
     * order(all diff is 1). Say if k is 5:
     * <p>
     * i++ j-- i++ j--  i++ i++ i++ ...
     * out: 1   9   2   8    3   4   5   6   7
     * dif:   8   7   6   5    1   1   1   1
     */
    public static int[] getBeautifulArrangementIIAnswer1(int n, int k) {
        int[] result = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++) {
            result[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        }
        return result;
    }
}
