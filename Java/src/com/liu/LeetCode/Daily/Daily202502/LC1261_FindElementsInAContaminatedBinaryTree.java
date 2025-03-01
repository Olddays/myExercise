package com.liu.LeetCode.Daily.Daily202502;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.HashSet;
import java.util.Set;

public class LC1261_FindElementsInAContaminatedBinaryTree {
    // Beats 98.92%
    private static class FindElementsMy1 {
        private Set<Integer> set;

        public FindElementsMy1(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            set.add(root.val);
            recover(root, root.val);
        }

        public boolean find(int target) {
            return set.contains(target);
        }

        private void recover(TreeNode node, int preVal) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                node.left.val = 2 * preVal + 1;
                set.add(node.left.val);
                recover(node.left, node.left.val);
            }
            if (node.right != null) {
                node.right.val = 2 * preVal + 2;
                set.add(node.right.val);
                recover(node.right, node.right.val);
            }
        }
    }

    public static void main(String[] args) {
        int[][] initList = new int[][]{
                {-1, Integer.MIN_VALUE, -1},
                {-1, -1, -1, -1, -1},
                {-1, Integer.MIN_VALUE, -1, -1, Integer.MIN_VALUE, -1},
        };
        int[][] findList = new int[][]{
                {1, 2},
                {1, 3, 5},
                {2, 3, 4, 5},
        };
        long startTime;
        long endTime;

        for (int i = 0; i < initList.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, initList[i]);
            startTime = System.currentTimeMillis();
            FindElementsMy1 findElementsMy1 = new FindElementsMy1(root);
            System.out.print("FindElements My1 result" + i + " ");
            for (int find : findList[i]) {
                boolean result = findElementsMy1.find(find);
                System.out.print("find " + find + " result " + result + ", ");
            }
            endTime = System.currentTimeMillis();
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
