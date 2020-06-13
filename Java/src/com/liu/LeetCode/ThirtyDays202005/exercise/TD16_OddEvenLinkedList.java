package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.List;

/**
 * Created by Liu on 2020/5/17.
 */
public class TD16_OddEvenLinkedList {
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

    public static ListNode oddEvenList(ListNode head) {
        ListNode result = head;
        int count = 0;
        ListNode last = head;
        ListNode before = head;
        while (head != null) {
            ListNode node = head;
            if (count != 0 && count % 2 == 0) {
                ListNode cache = last.next;
                before.next = node.next;
                last.next = node;
                node.next = cache;
                last = node;
                head = before.next;
            } else {
                before = head;
                head = head.next;
            }
            count++;
        }
        return result;
    }
}
