package com.liu.LeetCode.ThirtyDays202007.exercise;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD10_FlattenAMultilevelDoublyLinkedList {
    public static class Node {
        public Node(int val) {
            this.val = val;
        }

        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public static Node flatten(Node head) {
        Node result = head;
        while (head != null) {
            if (head.child != null) {
                Node child = head.child;
                while (child.next != null) {
                    child = child.next;
                }
                Node cache = head.next;
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                child.next = cache;
                if (cache != null) {
                    cache.prev = child;
                }
            }
            head = head.next;
        }
        return result;
    }
}
