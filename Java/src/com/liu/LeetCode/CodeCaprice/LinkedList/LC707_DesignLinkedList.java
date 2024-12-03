package com.liu.LeetCode.CodeCaprice.LinkedList;

import com.liu.LeetCode.common.bean.ListNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC707_DesignLinkedList {
    // 使用虚拟头节点进行，方便增删查改
    static class MyLinkedList {

        class Node {
            int val;
            Node next;
            Node prev;
        }

        private int size;
        private Node virtualNode;

        public MyLinkedList() {
            virtualNode = new Node();
            size = 0;
            virtualNode.next = virtualNode;
            virtualNode.prev = virtualNode;
        }

        public int get(int index) {
            if (size <= index) {
                return -1;
            }
            Node cache = virtualNode.next;
            for (int i = 0; i < index; i++) {
                cache = cache.next;
            }
            return cache.val;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            // 新前后
            node.next = virtualNode.next;
            node.prev = virtualNode;
            // 老head的前 此处注意空
            virtualNode.next.prev = node;
            // 老virtual的后
            virtualNode.next = node;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            // 新前后
            node.next = virtualNode;
            node.prev = virtualNode.prev;
            // 老tail的后 此处注意空
            virtualNode.prev.next = node;
            // 老virtual的前
            virtualNode.prev = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (size < index) {
                return;
            }
            Node node = new Node();
            node.val = val;
            Node cache = virtualNode.next;
            for (int i = 0; i < index; i++) {
                cache = cache.next;
            }
            // 不用判断空，因为链表是双向循环链表
            // 新前后
            node.prev = cache.prev;
            node.next = cache;
            // 老前的后
            cache.prev.next = node;
            // 自己的前
            cache.prev = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (size <= index) {
                return;
            }
            Node cache = virtualNode.next;
            for (int i = 0; i < index; i++) {
                cache = cache.next;
            }
            // 自己后的前
            cache.next.prev = cache.prev;
            // 自己前的后
            cache.prev.next = cache.next;
            // 自己前后
            cache.next = null;
            cache.prev = null;
            size--;
        }
    }


    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        int val = obj.get(1);
        System.out.println("DesignLinkedList " + val);
        obj.deleteAtIndex(1);
        val = obj.get(1);
        System.out.println("DesignLinkedList " + val);
    }
}
