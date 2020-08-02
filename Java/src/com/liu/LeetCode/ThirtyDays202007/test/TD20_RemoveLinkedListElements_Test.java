package com.liu.LeetCode.ThirtyDays202007.test;


import com.liu.LeetCode.common.ListNode;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD20_RemoveLinkedListElements.removeElements;

/**
 * Created by Liu on 2020/7/20.
 */
public class TD20_RemoveLinkedListElements_Test {
    public static void main(String[] args) {
        ListNode head;
        int val;
        ListNode result;
        long startTime;
        long endTime;


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        val = 3;
        startTime = System.currentTimeMillis();
        result = testMy1(head, val);
        endTime = System.currentTimeMillis();
        System.out.println("TD20_RemoveLinkedListElements My 1, during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        val = 1;
        startTime = System.currentTimeMillis();
        result = testMy1(head, val);
        endTime = System.currentTimeMillis();
        System.out.println("TD20_RemoveLinkedListElements My 1, during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode testMy1(ListNode head, int val) {
        return removeElements(head, val);
    }

}
