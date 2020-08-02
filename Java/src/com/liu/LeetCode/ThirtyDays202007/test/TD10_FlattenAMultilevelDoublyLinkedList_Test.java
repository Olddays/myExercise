package com.liu.LeetCode.ThirtyDays202007.test;

import com.liu.LeetCode.ThirtyDays202007.exercise.TD10_FlattenAMultilevelDoublyLinkedList.Node;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD10_FlattenAMultilevelDoublyLinkedList.flatten;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD10_FlattenAMultilevelDoublyLinkedList_Test {
    public static void main(String[] args) {
        Node head;
        Node result;
        long startTime;
        long endTime;

        Node cache;


        head = new Node(1);
        cache = new Node(2);
        head.next = cache;
        cache.prev = head;
        cache = new Node(3);
        head.next.next = cache;
        cache.prev = head.next;
        cache = new Node(4);
        head.next.child = cache;
        startTime = System.currentTimeMillis();
        result = testMy1(head);
        endTime = System.currentTimeMillis();
        System.out.println("TD10_FlattenAMultilevelDoublyLinkedList My 1 result " + result + " during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

    }

    private static Node testMy1(Node head) {
        return flatten(head);
    }
}
