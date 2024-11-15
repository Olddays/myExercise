package com.liu.LeetCode.FifteenPatterns.FastSlowPointers;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils.NODE_TYPE;

/**
 * The Fast & Slow Pointers (Tortoise and Hare) pattern is used to detect cycles in linked lists and other similar structures.
 * Sample Problem:
 * Detect if a linked list has a cycle.
 * Explanation:
 * Initialize two pointers, one moving one step at a time (slow) and the other moving two steps at a time (fast).
 * If there is a cycle, the fast pointer will eventually meet the slow pointer.
 * If the fast pointer reaches the end of the list, there is no cycle.
 */

public class LC141_LinkedListCycle {

    private static boolean hasCycleMy1(ListNode head) {
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 2, 0, -4},
                {1, 2},
                {1},
        };
        int[] positions = new int[]{
                1,
                0,
                -1,
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            startTime = System.currentTimeMillis();
            ListNode node = (ListNode) NodeCreator.createNode(NODE_TYPE.NODE_TYPE_CYCLE_LIST, valuesSet[i], positions[i]);
            result = hasCycleMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("hasCycle My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
