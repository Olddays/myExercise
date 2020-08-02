package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.TreeNode;

import java.util.*;

/**
 * Created by Liu on 2020/4/14.
 */
public class LC101_SymmetricTree {

    public static boolean isSymmetricAnswer(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static boolean isSymmetricMy1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<Integer, List<String>> set = new HashMap<>();
        inOrder(root, set, 0);
        for (Map.Entry<Integer, List<String>> entry : set.entrySet()) {
            List<String> list = entry.getValue();
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                if (!Objects.equals(list.get(left), list.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode node, Map<Integer, List<String>> set, int depth) {
        if (node != null) {

            List<String> list;
            if (set.containsKey(depth)) {
                list = set.get(depth);
            } else {
                list = new ArrayList<>();
            }
            if (node.left != null) {
                list.add(String.valueOf(node.left.val));
            } else {
                list.add("-");
            }

            if (node.right != null) {
                list.add(String.valueOf(node.right.val));
            } else {
                list.add("-");
            }
            set.put(depth, list);

            inOrder(node.left, set, depth + 1);
            inOrder(node.right, set, depth + 1);
        }
    }
}
