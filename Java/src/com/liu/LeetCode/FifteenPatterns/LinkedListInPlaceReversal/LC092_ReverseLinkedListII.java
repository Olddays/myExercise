package com.liu.LeetCode.FifteenPatterns.LinkedListInPlaceReversal;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils.NODE_TYPE;
import com.liu.LeetCode.common.tools.Utils;

public class LC092_ReverseLinkedListII {

    private static ListNode reverseBetweenMy1(ListNode head, int left, int right) {
        ListNode result = head;
        if (head == null || head.next == null) {
            return result;
        }
        int index = 1;
        ListNode preStart = null;
        ListNode point = head;
        ListNode start = point;
        while (index < left) {
            preStart = point;
            point = point.next;
            start = point;
            index++;
        }
        ListNode previous;
        ListNode next = point.next;
        while (index < right) {
            previous = point;
            point = next;
            next = next.next;
            point.next = previous;
            index++;
        }
        if (preStart != null) {
            preStart.next = point;
        } else {
            result = point;
        }
        start.next = next;
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {5},
                {},
        };
        int[][] pairSet = new int[][]{
                {1, 5},
                {3, 5},
                {1, 3},
                {2, 4},
                {1, 1},
                {1, 1},
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = reverseBetweenMy1(node, pairSet[i][0], pairSet[i][1]);
            endTime = System.currentTimeMillis();
            System.out.println("reverseBetween My1 result" + i + " " + Utils.getNodePrintableLog(NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
