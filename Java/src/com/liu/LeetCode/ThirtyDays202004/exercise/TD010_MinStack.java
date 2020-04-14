package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.ArrayList;
import java.util.List;

public class TD010_MinStack {
    public static class MinStack {

        List<Integer> integerList;
        int min;

        public MinStack() {
            integerList = new ArrayList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            integerList.add(x);
            min = Math.min(min, x);
        }

        public void pop() {
            int size = integerList.size();
            if (size > 0) {
                int preRemove = integerList.get(size - 1);
                integerList.remove(size - 1);
                if (preRemove == min) {
                    min = Integer.MAX_VALUE;
                    for (int i : integerList) {
                        min = Math.min(i, min);
                    }
                }
            }
        }

        public int top() {
            int size = integerList.size();
            if (size > 0) {
                return integerList.get(size - 1);
            }
            return 0;
        }

        public int getMin() {
            return min;
        }
    }
}
