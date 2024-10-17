package com.liu.LeetCode.ThirtyDays202007.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Liu on 2020/7/2.
 */
public class TD02_BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            widthFirstSearchByLayer(result, nodeList);
        }
        return result;
    }

    private static void widthFirstSearchByLayer(List<List<Integer>> result, ArrayList<TreeNode> nodeList) {
        List<Integer> cache = new ArrayList<>();
        ArrayList<TreeNode> nextNodeList = new ArrayList<>();
        if (nodeList != null && nodeList.size() > 0) {
            for (TreeNode node : nodeList) {
                cache.add(node.val);
                if (node.left != null) {
                    nextNodeList.add(node.left);
                }
                if (node.right != null) {
                    nextNodeList.add(node.right);
                }
            }
        }
        if (cache.size() > 0) {
            result.add(0, cache);
        }
        if (nextNodeList.size() > 0) {
            widthFirstSearchByLayer(result, nextNodeList);
        }
    }

    private static void widthFirstSearch(List<List<Integer>> result, TreeNode root, ArrayList<Integer> cache) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedBlockingQueue<>();
            queue.add(root);
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                cache.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, new ArrayList<>(cache));
            cache.clear();
        }
    }
}
