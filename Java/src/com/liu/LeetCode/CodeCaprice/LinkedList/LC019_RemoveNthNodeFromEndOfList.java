package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC019_RemoveNthNodeFromEndOfList {

    private static ListNode removeNthFromEndMy1(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        ListNode pre = null; // 虚拟头节点
        cur = head;
        while (length > n) {
            pre = cur;
            cur = cur.next;
            length--;
        }
        if (cur == head) {
            return head.next;
        } else {
            pre.next = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, 4, 5},
                {1},
                {1, 2},
        };
        int[] nSet = new int[]{
                2,
                1,
                1,
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = removeNthFromEndMy1(node, nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeNthFromEnd My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
