package com.liu.LeetCode.First.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC138_CopyListwithRandomPointer {
    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     * <p>
     * Return a deep copy of the list.
     */
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */

    public static class RandomListNode {
        public int label;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int x) {
            this.label = x;
        }
    }

    /**
     * An intuitive solution is to keep a hash table for each node in the list,
     * via which we just need to iterate the list in 2 rounds respectively to
     * create nodes and assign the values for their random pointers. As a result,
     * the space complexity of this solution is O(N), although with a linear time complexity.
     * <p>
     * As an optimised solution, we could reduce the space complexity into constant.
     * The idea is to associate the original node with its copy node in a single linked list.
     * In this way, we don't need extra space to keep track of the new nodes.
     * <p>
     * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
     * <p>
     * Iterate the original list and duplicate each node. The duplicate
     * of each node follows its original immediately.
     * Iterate the new list and assign the random pointer for each
     * duplicated node.
     * Restore the original list and extract the duplicated nodes.
     * <p>
     * The algorithm is implemented as follows:
     */
    public static RandomListNode getCopyListwithRandomPointerAnswer1(RandomListNode head) {
        RandomListNode iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    public static RandomListNode getCopyListwithRandomPointerAnswer2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
