package com.liu.LeetCode.ThirtyDays202005.test;

import com.liu.LeetCode.common.bean.ListNode;

import static com.liu.LeetCode.ThirtyDays202005.exercise.TD16_OddEvenLinkedList.oddEvenList;

/**
 * Created by Liu on 2020/5/17.
 */
public class TD16_OddEvenLinkedList_Test {
    public static void main(String[] args) {
        ListNode head;
        ListNode result;
        long startTime;
        long endTime;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        startTime = System.currentTimeMillis();
        result = testMy1(head);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_OddEvenLinkedList My 1 during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        startTime = System.currentTimeMillis();
        result = testMy1(head);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_OddEvenLinkedList My 1 during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

    private static ListNode testMy1(ListNode head) {
        return oddEvenList(head);
    }

}
