package com.liu.LeetCode.Second.LinkedListInPlaceReversal;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils.NODE_TYPE;
import com.liu.LeetCode.common.tools.Utils;

public class LC024_SwapNodesInPairs {

    private static ListNode swapPairsMy1(ListNode head) { // 两两交换，需要四个标记点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (current != null && next != null) {
            current.next = next.next;
            next.next = current;
            if (previous != null) {
                previous.next = next;
            }
            previous = current;
            current = current.next;
            if (current != null) {
                next = current.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4},
                {1, 2, 3},
                {1},
                {},
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            startTime = System.currentTimeMillis();
            ListNode node = (ListNode) NodeCreator.createNode(NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            result = swapPairsMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("swapPairs My1 result" + i + " " + Utils.getNodePrintableLog(NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
