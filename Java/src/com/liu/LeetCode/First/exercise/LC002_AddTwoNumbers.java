package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.ListNode;

/**
 * Created by liu on 2017/9/6.
 */
public class LC002_AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * <p>
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    // 缺少对于类似 [5] [5] 的输入的处理,即未处理当upCache最终非0时的进位
    public static ListNode addTwoNumbersMy1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0); // header cache
        int upCache = 0;
        ListNode cache = result;
        while (null != l1 && null != l2) {
            int left = l1.val;
            int right = l2.val;
            int count = left + right + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1) {
            int count = l1.val + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l1 = l1.next;
        }
        while (null != l2) {
            int count = l2.val + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l2 = l2.next;
        }
        if (null != result.next) {
            return result.next;
        } else {
            return null;
        }
    }

    public static ListNode addTwoNumbersMy2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0); // header cache
        int upCache = 0;
        ListNode cache = result;
        while (null != l1 && null != l2) {
            int left = l1.val;
            int right = l2.val;
            int count = left + right + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1) {
            int count = l1.val + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l1 = l1.next;
        }
        while (null != l2) {
            int count = l2.val + upCache;
            int node = count % 10;
            upCache = count / 10;
            cache.next = new ListNode(node);
            cache = cache.next;
            l2 = l2.next;
        }
        if (upCache > 0) {
            cache.next = new ListNode(upCache);
        }
        if (null != result.next) {
            return result.next;
        } else {
            return null;
        }
    }
}
