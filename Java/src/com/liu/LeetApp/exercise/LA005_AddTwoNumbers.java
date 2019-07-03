package com.liu.LeetApp.exercise;

/**
 * Created by liu on 2016/12/1.
 */
public class LA005_AddTwoNumbers {

    // You are given two linked lists representing two non-negative numbers.
    // The digits are stored in reverse order and each of their nodes contain a single digit.
    // Add the two numbers and return it as a linked list.

    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8

    // Difficulty: Medium

    // Error 由于长度设置问题,少了一个点
    public static Node addTwoNumbersMy1(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength() - 1;
        int secondLength = second.getLength() - 1;
        Node firstCache = first.next;
        Node secondCache = second.next;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result;
    }

    // Error 不应该从next开始算,Cache直接从原始点开始算,返回值不应该是new出来的临时点而是他的next
    public static Node addTwoNumbersMy2(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength();
        int secondLength = second.getLength();
        Node firstCache = first.next;
        Node secondCache = second.next;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result;
    }

    // Error firstCache和secondCache没有往下走
    public static Node addTwoNumbersMy3(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength();
        int secondLength = second.getLength();
        Node firstCache = first;
        Node secondCache = second;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result.next;
    }

    // Error 第二个while里面不应该出现secondCache,会引起空指针
    public static Node addTwoNumbersMy4(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength();
        int secondLength = second.getLength();
        Node firstCache = first;
        Node secondCache = second;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            secondCache = secondCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result.next;
    }

    public static Node addTwoNumbersMy5(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength();
        int secondLength = second.getLength();
        Node firstCache = first;
        Node secondCache = second;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            secondCache = secondCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result.next;
    }

    public static Node addTwoNumbersAnswer(Node first, Node second) {
        Node result = new Node(0);
        int carry = 0;
        if (first.getLength() < second.getLength()) {
            Node cache = first;
            first = second;
            second = cache;
        }
        int firstLength = first.getLength();
        int secondLength = second.getLength();
        Node firstCache = first;
        Node secondCache = second;
        Node resultCache = result;
        while (secondLength > 0) {
            int sum = firstCache.num + secondCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            secondCache = secondCache.next;
            firstLength--;
            secondLength--;
        }
        while (firstLength > 0) {
            int sum = firstCache.num + carry;
            carry = sum / 10;
            resultCache.next = new Node(sum % 10);
            resultCache = resultCache.next;
            firstCache = firstCache.next;
            firstLength--;
        }
        if (carry > 0) {
            resultCache.next = new Node(carry);
        }
        return result.next;
    }

    public static class Node {
        public int num;
        public Node next;

        public Node(int num) {
            this.num = num;
        }

        public boolean hasNext() {
            return next != null;
        }

        public int getLength() {
            Node cache = next;
            int result = 1;
            while (cache != null) {
                result++;
                cache = cache.next;
            }
            return result;
        }
    }

}
