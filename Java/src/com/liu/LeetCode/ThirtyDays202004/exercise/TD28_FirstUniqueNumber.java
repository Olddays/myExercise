package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Liu on 2020/4/29.
 */
public class TD28_FirstUniqueNumber {

    public static class FirstUniqueMy1 {

        private LinkedList<Integer> uniqueList;
        private HashSet<Integer> dataSet;

        public FirstUniqueMy1(int[] nums) {
            uniqueList = new LinkedList<>();
            dataSet = new HashSet<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (uniqueList.size() > 0) {
                return uniqueList.get(0);
            }
            return -1;
        }

        public void add(int value) {
            if (dataSet.contains(value)) {
                uniqueList.remove(Integer.valueOf(value));
            } else {
                dataSet.add(value);
                uniqueList.add(value);
            }
        }
    }

    private class FirstUniqueMy2 {
        private class Node {
            public Node next;
            public int value;

            public Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        private HashMap<Integer, Node> hashmap;
        private Node dummpy;
        private Node cur;

        public FirstUniqueMy2(int[] nums) {
            hashmap = new HashMap<>();
            dummpy = new Node(0);
            cur = dummpy;
            for (int num : nums) {
                add(num);
            }
        }

        public void add(int value) {
            if (!hashmap.containsKey(value)) {
                Node node = new Node(value);
                cur.next = node;
                hashmap.put(value, cur);
                cur = cur.next;
            } else {
                // contains duplicate key;
                Node prev = hashmap.get(value);
                if (prev != null) {
                    prev.next = prev.next.next;
                    if (prev.next != null) {
                        int prevNextValue = prev.next.value;
                        hashmap.put(prevNextValue, prev);
                    } else {
                        //这里很重要，别忘记了，如果delete掉是最后一个元素，那么cur = prev;
                        cur = prev;
                    }
                    //这里很巧妙的,如果是第二次遇见，那么直接设置node为null,
                    //但是hashmap里面还是保留key，表示遇见过；
                    hashmap.put(value, null);
                }
            }
        }

        public int showFirstUnique() {
            if (dummpy.next != null) {
                return dummpy.next.value;
            } else {
                return -1;
            }
        }
    }

}
