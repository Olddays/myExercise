package com.liu.LeetCode.ThirtyDays202007.exercise;

import com.liu.LeetCode.common.bean.ListNode;

/**
 * Created by Liu on 2020/7/20.
 */
public class TD20_RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode pre = result;
        while (head != null) {
            if (val == head.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return result.next;
    }
}
