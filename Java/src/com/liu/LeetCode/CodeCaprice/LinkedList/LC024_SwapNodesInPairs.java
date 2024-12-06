package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC024_SwapNodesInPairs {

    private static ListNode swapPairsMy1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode result = head.next;
        int count = 0;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (count % 2 == 0) {
                cur.next = next.next;
                next.next = cur;
                if (pre != null) {
                    pre.next = next;
                }
                pre = cur;
            } else {
                pre = cur;
                cur = next;
            }
            count++;
        }
        return result;
    }

    private static ListNode swapPairsMy2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
        return head.next;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4},
                {1, 2},
                {1},
                {},
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = swapPairsMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("swapPairs My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = swapPairsMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("swapPairs My2 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
