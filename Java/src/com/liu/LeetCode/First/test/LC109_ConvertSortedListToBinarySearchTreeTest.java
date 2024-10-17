package com.liu.LeetCode.First.test;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.bean.TreeNode;

import static com.liu.LeetCode.First.exercise.LC109_ConvertSortedListToBinarySearchTree.sortedListToBST;

/**
 * Created by Liu on 2020/6/5.
 */
public class LC109_ConvertSortedListToBinarySearchTreeTest {
    public static void main(String[] args) {
        ListNode head;
        TreeNode result;
        long startTime;
        long endTime;

        int[] nums = new int[]{
                -10, -3, 0, 5, 9
        };
        head = new ListNode(nums[0]);
        ListNode cache = head;
        for (int i = 1; i < nums.length; i++) {
            cache.next = new ListNode(nums[i]);
            cache = cache.next;
        }
        startTime = System.currentTimeMillis();
        result = testMy1(head);
        endTime = System.currentTimeMillis();
        System.out.println("TD04_ReverseString My 1 result " + result + " during time " + (endTime - startTime));
        preorderPrint(result);
        System.out.println();

    }

    private static void preorderPrint(TreeNode result) {
        if (result != null) {
            System.out.print(result.val + " ");
            preorderPrint(result.left);
            preorderPrint(result.right);
        }
    }

    private static TreeNode testMy1(ListNode head) {
        return sortedListToBST(head);
    }

}
