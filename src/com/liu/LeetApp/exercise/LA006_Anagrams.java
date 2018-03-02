package com.liu.LeetApp.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liu on 2016/12/5.
 */
public class LA006_Anagrams {

    // Given an array of strings, return all groups of strings that are anagrams.

    // Note: All inputs will be in lower-case.

    // Medium

    // Error 出现了空指针,因为result没有new
    public static ArrayList<ArrayList<String>> anagramsMy1(String[] input) {
        ArrayList<ArrayList<String>> result = null;
        if (input.length < 2) {
            return result;
        }
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int fingerPrint = 1;
            char[] itemChars = item.toCharArray();
            for (int i = 0; i < itemChars.length; i++) {
                fingerPrint = fingerPrint * (itemChars[i] * i + 27);
            }
            ArrayList<String> cache;
            if (null != cacheMap.get(fingerPrint) && cacheMap.get(fingerPrint).size() > 0) {
                cache = cacheMap.get(fingerPrint);
                if (!cache.contains(item)) {
                    cache.add(item);
                    cacheMap.put(fingerPrint, cache);
                }
            } else {
                cache = new ArrayList<>();
                cache.add(item);
                cacheMap.put(fingerPrint, cache);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

    // Error result内容为空,由于使用的是乘法,所以计算顺序引起了fingerPrint的数值不一致
    public static ArrayList<ArrayList<String>> anagramsMy2(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (input.length < 2) {
            return result;
        }
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int fingerPrint = 1;
            char[] itemChars = item.toCharArray();
            for (int i = 0; i < itemChars.length; i++) {
                fingerPrint = fingerPrint * (itemChars[i] * i + 27);
            }
            ArrayList<String> cache;
            if (null != cacheMap.get(fingerPrint) && cacheMap.get(fingerPrint).size() > 0) {
                cache = cacheMap.get(fingerPrint);
                if (!cache.contains(item)) {
                    cache.add(item);
                    cacheMap.put(fingerPrint, cache);
                }
            } else {
                cache = new ArrayList<>();
                cache.add(item);
                cacheMap.put(fingerPrint, cache);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

    // Error result内容不正确,由于使用的是乘法,其中乘以了i,而i会出现0值,所以计算顺序引起了本应不一致的fingerPrint的数值一致
    public static ArrayList<ArrayList<String>> anagramsMy3(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (input.length < 2) {
            return result;
        }
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int fingerPrint = 1;
            char[] itemChars = item.toCharArray();
            for (int i = 0; i < itemChars.length; i++) {
                fingerPrint = fingerPrint + (itemChars[i] * i + 27);
            }
            ArrayList<String> cache;
            if (null != cacheMap.get(fingerPrint) && cacheMap.get(fingerPrint).size() > 0) {
                cache = cacheMap.get(fingerPrint);
                if (!cache.contains(item)) {
                    cache.add(item);
                    cacheMap.put(fingerPrint, cache);
                }
            } else {
                cache = new ArrayList<>();
                cache.add(item);
                cacheMap.put(fingerPrint, cache);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

    // Error 由于乘了i,那么不同位置的数字一定会引起数据不一致,应该乘常量
    public static ArrayList<ArrayList<String>> anagramsMy4(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (input.length < 2) {
            return result;
        }
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int fingerPrint = 1;
            char[] itemChars = item.toCharArray();
            for (int i = 1; i <= itemChars.length; i++) {
                fingerPrint = fingerPrint + (itemChars[i - 1] * i + 27);
            }
            ArrayList<String> cache;
            if (null != cacheMap.get(fingerPrint) && cacheMap.get(fingerPrint).size() > 0) {
                cache = cacheMap.get(fingerPrint);
                if (!cache.contains(item)) {
                    cache.add(item);
                    cacheMap.put(fingerPrint, cache);
                }
            } else {
                cache = new ArrayList<>();
                cache.add(item);
                cacheMap.put(fingerPrint, cache);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

    public static ArrayList<ArrayList<String>> anagramsMy5(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (input.length < 2) {
            return result;
        }
        int constant = 27;
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int fingerPrint = 1;
            char[] itemChars = item.toCharArray();
            for (int i = 0; i < itemChars.length; i++) {
                fingerPrint = fingerPrint + (itemChars[i] * constant + constant);
            }
            ArrayList<String> cache;
            if (null != cacheMap.get(fingerPrint) && cacheMap.get(fingerPrint).size() > 0) {
                cache = cacheMap.get(fingerPrint);
                if (!cache.contains(item)) {
                    cache.add(item);
                    cacheMap.put(fingerPrint, cache);
                }
            } else {
                cache = new ArrayList<>();
                cache.add(item);
                cacheMap.put(fingerPrint, cache);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

    public static ArrayList<ArrayList<String>> anagramsAnswer(String[] input) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (input.length < 2) {
            return result;
        }
        HashMap<Integer, ArrayList<String>> cacheMap = new HashMap<>();
        for (String item : input) {
            int constantA = 378551;
            int constantB = 63689;
            int[] count = new int[26];
            for (int i = 0; i < item.length(); i++) {
                count[item.charAt(i) - 'a']++;
            }
            int fingerPrint = 0;
            for (int num : count) {
                fingerPrint = fingerPrint * constantA + num;
                constantA = constantA * constantB;
            }
            if (!cacheMap.containsKey(fingerPrint)) {
                cacheMap.put(fingerPrint, new ArrayList<>());
            }
            if (!cacheMap.get(fingerPrint).contains(item)) {
                cacheMap.get(fingerPrint).add(item);
            }
        }
        result.addAll(cacheMap.entrySet().stream().filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getValue).collect(Collectors.toList()));
        return result;
    }

}
