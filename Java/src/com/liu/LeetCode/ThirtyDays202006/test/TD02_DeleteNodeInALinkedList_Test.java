package com.liu.LeetCode.ThirtyDays202006.test;

import com.liu.LeetCode.ThirtyDays202006.exercise.TD02_DeleteNodeInALinkedList.ListNode;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD02_DeleteNodeInALinkedList.deleteNode;

/**
 * Created by Liu on 2020/6/2.
 */
public class TD02_DeleteNodeInALinkedList_Test {
    public static void main(String[] args) {
        ListNode root;
        long startTime;
        long endTime;

        root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);
        startTime = System.currentTimeMillis();
        testMy1(root.next);
        endTime = System.currentTimeMillis();
        System.out.println("TD02_DeleteNodeInALinkedList My 1  during time " + (endTime - startTime));
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();

    }

    private static void testMy1(ListNode input) {
        deleteNode(input);
    }

}
