package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.Stack;

public class LC232_ImplementQueueUsingStacks {
    static class MyQueue {

        private int size;
        private Stack<Integer> stack;

        public MyQueue() {
            stack = new Stack<>();
            size = 0;
        }

        public void push(int x) {
            stack.add(x);
            size++;
        }

        public int pop() {
            if (size == 0) return -1;
            int result = stack.get(0);
            stack.remove(0);
            size--;
            return result;
        }

        public int peek() {
            if (size == 0) return -1;
            return stack.get(0);
        }

        public boolean empty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int val = obj.peek();
        System.out.println("ImplementQueueUsingStacks peek " + val);
        val = obj.pop();
        System.out.println("ImplementQueueUsingStacks pop " + val);
        boolean val2 = obj.empty();
        System.out.println("ImplementQueueUsingStacks empty " + val2);
    }
}
