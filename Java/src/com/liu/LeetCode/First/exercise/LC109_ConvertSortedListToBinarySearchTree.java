package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.ListNode;
import com.liu.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/5.
 */
public class LC109_ConvertSortedListToBinarySearchTree {

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
