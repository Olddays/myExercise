package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Liu on 2020/6/12.
 */
public class TD12_InsertDeleteGetRandomO1 {
    public static class RandomizedSetMy1 {

        private HashSet<Integer> set;
        private int size;
        private Random random;

        public RandomizedSetMy1() {
            set = new HashSet<>();
            size = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!set.contains(val)) {
                return false;
            }
            set.remove(val);
            size--;
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(size);
            Integer[] array = new Integer[size];
            set.toArray(array);
            return array[index];
        }
    }

    public static class RandomizedSetMy2 {

        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private int size;
        private Random random;

        public RandomizedSetMy2() {
            map = new HashMap<>();
            list = new ArrayList<>();
            size = 0;
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, size);
            list.add(val);
            size++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int local = map.get(val);
            if (local != size - 1) {
                int lastVal = list.get(size - 1);
                list.set(local, lastVal);
                map.put(lastVal, local);
            }
            map.remove(val);
            list.remove(size - 1);
            size--;
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(size);
            return list.get(index);
        }
    }
}
