package com.liu.LeetCode.Second.FastSlowPointers;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils.NODE_TYPE;

public class LC141_LinkedListCycle {

    private static boolean hasCycleMy1(ListNode head) {
        boolean hasCycle = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next!= null) {
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
