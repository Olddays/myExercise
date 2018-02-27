package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC138_CopyListwithRandomPointer.*;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC138_CopyListwithRandomPointerTest {

    public static void main(String[] args) {
        int[] input = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        RandomListNode head = new RandomListNode(0);
        RandomListNode cache = head;
        RandomListNode node;
        for (int i : input) {
            node = new RandomListNode(i);
            cache.next = node;
            cache = node;
        }
        long startTime;
        RandomListNode result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testAnswer1(head);
        endTime = System.currentTimeMillis();
        System.out.println("CopyListwithRandomPointer Answer 1 result.label " + result.label + " during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.label + " ");
            result = result.next;
        }

        startTime = System.currentTimeMillis();
        result = testAnswer2(head);
        endTime = System.currentTimeMillis();
        System.out.println("CopyListwithRandomPointer Answer 2 result.label " + result.label + " during time " + (endTime - startTime));
        while (result != null) {
            System.out.print(result.label + " ");
            result = result.next;
        }
    }

    private static RandomListNode testAnswer1(RandomListNode head) {
        return getCopyListwithRandomPointerAnswer1(head);
    }

    private static RandomListNode testAnswer2(RandomListNode head) {
        return getCopyListwithRandomPointerAnswer2(head);
    }
}
