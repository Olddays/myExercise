package com.liu.LeetCode.ThirtyDays202004.test;

import com.liu.LeetCode.ThirtyDays202004.exercise.TD24_LRUCache.LRUCache;

/**
 * Created by Liu on 2020/4/24.
 */
public class TD24_LRUCache_Test {

    public static void main(String[] args) {
        String output;
        LRUCache obj;
        output = "";

        obj = new LRUCache(2);
        output += obj.get(2) + " ";
        obj.put(2, 6);
        output += obj.get(1) + " ";
        obj.put(1, 5);
        obj.put(1, 2);
        output += obj.get(1) + " ";
        output += obj.get(2) + " ";
        System.out.println(output);

        output = "";
        obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(1, 1);
        obj.put(2, 3);
        obj.put(4, 1);
        output += obj.get(1) + " ";
        output += obj.get(2) + " ";
        System.out.println(output);
    }

}
