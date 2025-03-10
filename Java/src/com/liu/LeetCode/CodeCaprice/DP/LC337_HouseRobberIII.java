package com.liu.LeetCode.CodeCaprice.DP;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

// 树形DP入门题目
// 树形DP的核心是找到状态转移方程
// 核心是，dp来记录特定状态下的数据，也就是dp的定义是核心
public class LC337_HouseRobberIII {
    // 对于每个节点，有两种状态，偷和不偷
    // 如果偷，那么左右孩子就不能偷
    // 如果不偷，那么左右孩子就可以偷也可以不偷
    // 所以对于每个节点，有两个值，偷和不偷
    // 偷 = 左孩子不偷 + 右孩子不偷 + 自己
    // 不偷 = max(左孩子偷，左孩子不偷) + max(右孩子偷，右孩子不偷)

    private static int robMy1(TreeNode root) {
        int[] dp = robMy1Helper(root);
        return Math.max(dp[0], dp[1]);
    }

    // 要用后序遍历，因为需要先找到最下面的叶子节点再往上逐层回滚
    private static int[] robMy1Helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] dpLeft = robMy1Helper(node.left);
        int[] dpRight = robMy1Helper(node.right);
        // 每个数组只有两个状态，偷或不偷
        // 0 不偷 1 偷
        // dp[0]是不偷当前节点的最大金钱，dp[1]是偷当前节点的最大金钱
        int[] dp = new int[2];
        // 如果不偷当前节点，那就是左右孩子偷或不偷的最大值
        dp[0] = Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]);
        // 如果偷当前节点，那就是当前节点+left不偷+right不偷
        dp[1] = node.val + dpLeft[0] + dpRight[0];
        return dp;
    }

    public static void main(String[] args) {
        int[][] numsSet = new int[][]{
                {3, 2, 3, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 1},
                {3, 4, 5, 1, 3, Integer.MIN_VALUE, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, numsSet[i]);
            startTime = System.currentTimeMillis();
            result = robMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("rob My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
