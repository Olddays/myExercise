package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC508_MostFrequentSubtreeSum {
    /**
     * Given the root of a tree, you are asked to find the most frequent subtree sum.
     * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
     * (including the node itself). So what is the most frequent subtree sum value?
     * If there is a tie, return all the values with the highest frequency in any order.
     * <p>
     * Examples 1
     * Input:
     * <p>
     * 5
     * /  \
     * 2   -3
     * return [2, -3, 4], since all the values happen only once, return all of them in any order.
     * Examples 2
     * Input:
     * <p>
     * 5
     * /  \
     * 2   -5
     * return [2], since 2 happens twice, however -5 only occur once.
     * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
     */

    private static int maxCount;

    public static int[] getMostFrequentSubtreeSumAnswer1(TreeNode root) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        maxCount = 0;

        postOrder(sumToCount, root);

        List<Integer> res = new ArrayList<>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private static int postOrder(Map<Integer, Integer> sumToCount, TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(sumToCount, root.left);
        int right = postOrder(sumToCount, root.right);

        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);

        maxCount = Math.max(maxCount, count);

        return sum;
    }
}
