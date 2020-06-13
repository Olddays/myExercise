package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/5.
 */
public class LC109_ConvertSortedListToBinarySearchTree {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int length = array.size();
        if (length == 0) {
            return null;
        }
        int middle = length / 2;
        TreeNode result = new TreeNode(array.get(middle));
        result.left = insertNode(array, 0, middle);
        result.right = insertNode(array, middle + 1, length);
        return result;
    }

    private static TreeNode insertNode(List<Integer> array, int start, int end) {
        if (start == end) {
            return null;
        }
        int middle = (end - start) / 2 + start;
        TreeNode node = new TreeNode(array.get(middle));
        node.left = insertNode(array, start, middle);
        node.right = insertNode(array, middle + 1, end);
        return node;
    }
}
