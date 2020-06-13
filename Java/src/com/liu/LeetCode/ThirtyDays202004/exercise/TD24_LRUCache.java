package com.liu.LeetCode.ThirtyDays202004.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liu on 2020/4/24.
 */
public class TD24_LRUCache {
    public static class LRUCache {
        private int mCapacity;
        private List<Integer> mList;
        private Map<Integer, Integer> mMap;

        public LRUCache(int capacity) {
            mCapacity = capacity;
            mList = new ArrayList<>();
            mMap = new HashMap<>();
        }

        public int get(int key) {
            if (mMap.containsKey(key)) {
                mList.remove(Integer.valueOf(key));
                mList.add(key);
                return mMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (mMap.containsKey(key)) {
                mMap.put(key, value);
                mList.remove(Integer.valueOf(key));
                mList.add(key);
            } else {
                if (mMap.size() == mCapacity) {
                    mMap.remove(mList.get(0));
                    mList.remove(0);
                }
                mList.add(key);
                mMap.put(key, value);
            }
        }
    }
}
