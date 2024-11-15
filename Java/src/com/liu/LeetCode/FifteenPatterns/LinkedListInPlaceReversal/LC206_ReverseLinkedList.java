package com.liu.LeetCode.FifteenPatterns.LinkedListInPlaceReversal;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils.NODE_TYPE;
import com.liu.LeetCode.common.tools.Utils;

public class LC206_ReverseLinkedList {

    private static ListNode reverseListMy1(ListNode head) {
        ListNode result = head;
        if (head == null || head.next == null) {
            return result;
        }
        ListNode previous;
        ListNode point = head;
        ListNode next = point.next;
        while (next != null) {
            previous = point;
            point = next;
            next = next.next;
            point.next = previous;
            if (next == null) {
                result = point;
            }
        }
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2},
                {1},
                {},
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            startTime = System.currentTimeMillis();
            ListNode node = (ListNode) NodeCreator.createNode(NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            result = reverseListMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("reverseList My1 result" + i + " " + Utils.getNodePrintableLog(NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
