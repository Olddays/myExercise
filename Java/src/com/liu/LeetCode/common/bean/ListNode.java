package com.liu.LeetCode.common.bean;

/**
 * Created by Liu on 2020/7/20.
 */
public class ListNode extends BaseNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
