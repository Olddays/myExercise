package com.liu.LeetCode.ThirtyDays202004.exercise;

import com.liu.LeetCode.common.bean.ListNode;

public class TD08_MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode cache = head;
        while (cache.next != null) {
            cache = cache.next;
            count++;
        }
        int middle = (count + 1) / 2;
        for (int i = 0; i < middle; i++) {
            head = head.next;
        }
        return head;
    }
}
