package com.liu.LeetCode.ThirtyDays202007.exercise;

import com.liu.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/7/22.
 */
public class TD22_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            List<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            widthSearch(result, nodeList, false);
        }
        return result;
    }

    private static void widthSearch(List<List<Integer>> result, List<TreeNode> nodeList, boolean needReverse) {
        if (nodeList.size() > 0) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> cache = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (needReverse) {
                    cache.add(0, node.val);
                } else {
                    cache.add(node.val);
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            result.add(cache);
            widthSearch(result, list, !needReverse);
        }
    }

}
