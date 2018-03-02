package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC381_InsertDeleteGetRandomOOneDuplicatesAllowed {
    /**
     * Design a data structure that supports all following operations in average O(1) time.
     * Note: Duplicate elements are allowed.
     * <p>
     * insert(val): Inserts an item val to the collection.
     * remove(val): Removes an item val from the collection if present.
     * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
     * <p>
     * Example:
     * <p>
     * // Init an empty collection.
     * RandomizedCollection collection = new RandomizedCollection();
     * <p>
     * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
     * collection.insert(1);
     * <p>
     * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
     * collection.insert(1);
     * <p>
     * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
     * collection.insert(2);
     * <p>
     * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
     * collection.getRandom();
     * <p>
     * // Removes 1 from the collection, returns true. Collection now contains [1,2].
     * collection.remove(1);
     * <p>
     * // getRandom should return 1 and 2 both equally likely.
     * collection.getRandom();
     */

    public static class RandomizedCollection {

        ArrayList<Integer> list;
        HashMap<Integer, Set<Integer>> localSet;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
            localSet = new HashMap<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = localSet.containsKey(val);
            if (!contain) {
                localSet.put(val, new LinkedHashSet<>());
            }
            localSet.get(val).add(list.size());
            list.add(val);
            return !contain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = localSet.containsKey(val);
            if (contain) {
                int localCache = localSet.get(val).iterator().next();
                localSet.get(val).remove(localCache);
                if (localCache < list.size() - 1) { // not the last one then swap the last one with this val
                    int lastOne = list.get(list.size() - 1);
                    list.set(localCache, lastOne); // 移动到最后一个位置
                    localSet.get(lastOne).remove(list.size() - 1);
                    localSet.get(lastOne).add(localCache);
                }
                list.remove(list.size() - 1);
                if (localSet.get(val).isEmpty()) {
                    localSet.remove(val);
                }
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Random rand = new Random();
            int i = rand.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
