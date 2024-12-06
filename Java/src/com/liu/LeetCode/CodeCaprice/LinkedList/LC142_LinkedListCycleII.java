package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.HashSet;

public class LC142_LinkedListCycleII {

    // 性能较低，并且占用很大空间，所以应该使用快慢双指针
    private static ListNode detectCycleMy1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (!set.contains(current)) {
                set.add(current);
            } else {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 快慢双指针
    private static ListNode detectCycleMy2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head; // 要注意进入时起跑点得一样
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != head) {
                    // 数学可以证明，从相遇点一步一步走到环起点的距离和从head走到环起点的距离是一样的
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 2, 0, -4},
                {1, 2},
                {1},
        };
        int[] cyclePositions = new int[]{
                1,
                0,
                -1,
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_CYCLE_LIST, valuesSet[i], cyclePositions[i]);
            startTime = System.currentTimeMillis();
            result = detectCycleMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("detectCycle My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_CYCLE_LIST,
                    result) + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_CYCLE_LIST, valuesSet[i], cyclePositions[i]);
            startTime = System.currentTimeMillis();
            result = detectCycleMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("detectCycle My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_CYCLE_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
