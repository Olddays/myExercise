package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC002_AddTwoNumbers.ListNode;

import static com.liu.LeetCode.First.exercise.LC002_AddTwoNumbers.addTwoNumbersMy1;
import static com.liu.LeetCode.First.exercise.LC002_AddTwoNumbers.addTwoNumbersMy2;

/**
 * Created by liu on 2017/9/6.
 */
public class LC002_AddTwoNumbersTest {

    // 思路:
    // 首先,题目的要求很简单,通过链表的方式来模拟两个数字的相加,链表每个节点只能有一个个位数字,有大于个位的时候要进行进位操作
    //      已知的关系为: 每个节点只有一位数字,需要进位,要注意最后一步进位
    // 然后就是逐步遍历相加,本题重点在于注意各种边界情况的判断
    // 目前使用的解法的时间复杂度为log(n + m)

    public static void main(String[] args) {
        int[] l1Nums = new int[]{2, 4, 3, 9, 4};
        int[] l2Nums = new int[]{5, 6, 8, 7, 5};
        ListNode l1 = new ListNode(0);
        ListNode l1Cache = l1;
        ListNode l2 = new ListNode(0);
        ListNode l2Cache = l2;
        for (int num : l1Nums) {
            l1Cache.next = new ListNode(num);
            l1Cache = l1Cache.next;
        }
        for (int num : l2Nums) {
            l2Cache.next = new ListNode(num);
            l2Cache = l2Cache.next;
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(l1, l2);
        endTime = System.currentTimeMillis();
        while (null != result){
            System.out.println("addTwoNumbers My 1 result " + result.val + " during time " + (endTime - startTime));
            result = result.next;
        }

        startTime = System.currentTimeMillis();
        result = testMy2(l1, l2);
        endTime = System.currentTimeMillis();
        while (null != result){
            System.out.println("addTwoNumbers My 2 result " + result.val + " during time " + (endTime - startTime));
            result = result.next;
        }
    }

    private static ListNode testMy1(ListNode l1, ListNode l2) {
        return addTwoNumbersMy1(l1, l2);
    }

    private static ListNode testMy2(ListNode l1, ListNode l2) {
        return addTwoNumbersMy2(l1, l2);
    }
}
