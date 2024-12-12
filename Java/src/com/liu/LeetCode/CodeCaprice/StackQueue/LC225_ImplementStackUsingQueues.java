package com.liu.LeetCode.CodeCaprice.StackQueue;

import java.util.ArrayList;
import java.util.List;

public class LC225_ImplementStackUsingQueues {
    static class MyStack {

        private int size;
        private List<Integer> list;

        public MyStack() {
            size = 0;
            list = new ArrayList<Integer>();
        }

        public void push(int x) {
            size++;
            list.add(x);
        }

        public int pop() {
            if (size == 0) return -1;
            int val = list.get(size - 1);
            list.remove(size - 1);
            size--;
            return val;
        }

        public int top() {
            if (size == 0) return -1;
            return list.get(size - 1);
        }

        public boolean empty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        MyStack obj;
        int val;
        boolean val2;

        obj = new MyStack();
        obj.push(1);
        obj.push(2);
        val = obj.top();
        System.out.println("ImplementStackUsingQueues peek " + val);
        val = obj.pop();
        System.out.println("ImplementStackUsingQueues pop " + val);
        val2 = obj.empty();
        System.out.println("ImplementStackUsingQueues empty " + val2);

        obj = new MyStack();
        obj.push(1);
        val = obj.pop();
        System.out.println("ImplementStackUsingQueues pop " + val);
        obj.push(2);
        val = obj.top();
        System.out.println("ImplementStackUsingQueues peek " + val);
        val2 = obj.empty();
        System.out.println("ImplementStackUsingQueues empty " + val2);
    }
}
