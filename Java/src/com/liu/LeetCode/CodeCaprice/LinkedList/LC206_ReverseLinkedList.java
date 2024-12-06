package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC206_ReverseLinkedList {

    // 双指针方法
    private static ListNode reverseListMy1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 单向链表，需要记录三个点，当前节点，前一个节点，后一个节点
        ListNode result = null;
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = null; // 中断
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            result = cur;
            cur = next;
        }
        return result;
    }

    // 双指针方法 去掉一些可以删减的部分
    private static ListNode reverseListMy2(ListNode head) {
        // 单向链表，需要记录三个点，当前节点，前一个节点，后一个节点
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 递归方法
    private static ListNode reverseListMy3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return doReverse(head, null);
    }

    private static ListNode doReverse(ListNode current, ListNode pre) {
        if (current == null) {
            return pre;
        }
        ListNode next = current.next;
        current.next = pre;
        // 参考双指针，下一次循环的pre变成了current，下一次的current变成了next
        return doReverse(next, current);
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2},
                {1, 2, 3, 4, 5},
                {},
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = reverseListMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("reverseList My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = reverseListMy2(node);
            endTime = System.currentTimeMillis();
            System.out.println("reverseList My2 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = reverseListMy3(node);
            endTime = System.currentTimeMillis();
            System.out.println("reverseList My3 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
