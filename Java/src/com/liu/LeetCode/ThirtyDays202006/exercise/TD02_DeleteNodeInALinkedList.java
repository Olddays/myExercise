package com.liu.LeetCode.ThirtyDays202006.exercise;

import com.liu.LeetCode.common.bean.ListNode;

/**
 * Created by Liu on 2020/6/2.
 */
public class TD02_DeleteNodeInALinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
