package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC203_RemoveLinkedListElements {

    // 可以在最前假如一个临时节点来避免第一个元素删除的情况
    private static ListNode removeElementsMy1(ListNode head, int val) {
        ListNode result = head;
        ListNode lastNode = null;
        ListNode nowNode = head;
        while (nowNode != null) {
            if (nowNode.val == val) {
                if (lastNode == null) { // 处理第一个元素就要删除的情况
                    nowNode = nowNode.next;
                    result = nowNode;
                } else {
                    lastNode.next = nowNode.next;
                    nowNode = nowNode.next;
                }
            } else {
                // 要处理所有元素都删掉的情况，所以在else里面
                lastNode = nowNode;
                nowNode = nowNode.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {7, 7, 7, 7},
                {1, 2, 6, 3, 4, 5, 6},
                {},
        };
        int[] valList = new int[]{
                7,
                6,
                1,
        };
        ListNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            ListNode node = (ListNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = removeElementsMy1(node, valList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeElements My1 result" + i + " " + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_NORMAL_LIST,
                    result) + " during time " + (endTime - startTime));
        }
    }
}
