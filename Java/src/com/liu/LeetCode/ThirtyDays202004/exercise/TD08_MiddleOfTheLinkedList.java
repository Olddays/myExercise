package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD08_MiddleOfTheLinkedList {
    public static class ListNode {
        public int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

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
