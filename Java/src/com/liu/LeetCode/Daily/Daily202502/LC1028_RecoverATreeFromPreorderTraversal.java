package com.liu.LeetCode.Daily.Daily202502;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC1028_RecoverATreeFromPreorderTraversal {
    // Beats 70.70%
    private static TreeNode recoverFromPreorderMy1(String traversal) {
        if (traversal.isEmpty()) {
            return null;
        }
        return recoverFromPreorderMy1Helper(traversal, new HashMap<Integer, Integer>(), 0, 0);
    }

    private static TreeNode recoverFromPreorderMy1Helper(String traversal, Map<Integer, Integer> cache, int numStart, int depth) {
        if (numStart >= traversal.length()) {
            return null;
        }
        int startCache = numStart;
        // 寻找当前node的深度
        int depthCount = 0;
        while (numStart < traversal.length() && traversal.charAt(numStart) == '-') {
            numStart++;
            depthCount++;
        }
        // 寻找当前node的数值
        int numEnd = numStart;
        while (numEnd < traversal.length() && traversal.charAt(numEnd) >= '0' && traversal.charAt(numEnd) <= '9') {
            numEnd++;
        }
        TreeNode node = new TreeNode(Integer.valueOf(traversal.substring(numStart, numEnd))); // 确保每次进入循环的时候，都是由-开头
        numStart = numEnd;
        // 如果depthCount>depth，说明当前node的左子树开始了
        if (depthCount == depth) {
            node.left = recoverFromPreorderMy1Helper(traversal, cache, numStart, depth + 1);
        }
        // 如果depthCount<=depth，说明当前node的右子树开始了，此时要返回到对应的层级
        if (!cache.isEmpty()) {
            if (cache.containsKey(depth + 1)) {
                numStart = cache.get(depth + 1);
                cache.remove(depth + 1);
                node.right = recoverFromPreorderMy1Helper(traversal, cache, numStart, depth + 1);
            }
        }
        if (depthCount != depth) {
            cache.put(depthCount, startCache);
            return null;
        }
        return node;
    }

    public static void main(String[] args) {
        String[] traversalList = new String[]{
                "1-2--3---4-5--6---7",
                "1-2--3--4-5--6--7",
                "1-401--349---90--88"
        };
        long startTime;
        TreeNode result;
        long endTime;

        for (int i = 0; i < traversalList.length; i++) {
            startTime = System.currentTimeMillis();
            result = recoverFromPreorderMy1(traversalList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("recoverFromPreorder My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
