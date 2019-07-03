package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by liu on 2017/9/30.
 */
public class LC380_InsertDeleteGetRandomOOne {
    /**
     * Design a data structure that supports all following operations in average O(1) time.
     * <p>
     * insert(val): Inserts an item val to the set if not already present.
     * remove(val): Removes an item val from the set if present.
     * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
     * <p>
     * Example:
     * <p>
     * // Init an empty set.
     * RandomizedSet randomSet = new RandomizedSet();
     * <p>
     * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
     * randomSet.insert(1);
     * <p>
     * // Returns false as 2 does not exist in the set.
     * randomSet.remove(2);
     * <p>
     * // Inserts 2 to the set, returns true. Set now contains [1,2].
     * randomSet.insert(2);
     * <p>
     * // getRandom should return either 1 or 2 randomly.
     * randomSet.getRandom();
     * <p>
     * // Removes 1 from the set, returns true. Set now contains [2].
     * randomSet.remove(1);
     * <p>
     * // 2 was already in the set, so return false.
     * randomSet.insert(2);
     * <p>
     * // Since 2 is the only number in the set, getRandom always return 2.
     * randomSet.getRandom();
     */
    // I got a similar question for my phone interview. The difference is that the duplicated number is allowed.
    // So, think that is a follow-up of this question.
    // How do you modify your code to allow duplicated number?
    public static class RandomizedSet {

        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int cache = map.get(val);
                if (cache < list.size() - 1) { // not the last one then swap the last one with this val
                    int lastOne = list.get(list.size() - 1);
                    list.set(cache, lastOne);
                    map.put(lastOne, cache);
                }
                map.remove(val);
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random rand = new Random();
            int i = rand.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
