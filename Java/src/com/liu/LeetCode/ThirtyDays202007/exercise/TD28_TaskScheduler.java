package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.*;

/**
 * Created by Liu on 2020/7/28.
 */
public class TD28_TaskScheduler {

    // 仅考虑了在n=2时的,ABCABCDE*DE这种方案,
    // 没有考虑在n=2时的,ABCDEABCDE方案,可以节约一个时间
    public static int leastIntervalMy1(char[] tasks, int n) {
        int length = tasks.length;
        if (n == 0) {
            return length;
        }
        Map<Character, Integer> taskMap = new HashMap<>();
        for (char c : tasks) {
            taskMap.put(c, taskMap.getOrDefault(c, 0) + 1);
        }
        Comparator<Map.Entry<Character, Integer>> valCmp = (o1, o2) -> o2.getValue() - o1.getValue();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(taskMap.entrySet());
        Collections.sort(list, valCmp);

        char[] cacheList = new char[length * (n + 1)];

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> entry = list.get(i);
            int lastSame = 0;
            for (int j = 0; j < entry.getValue(); j++) {
                int t = j * (n + 1) + i;
                if (cacheList[t] == '\0') {
                    cacheList[t] = entry.getKey();
                    lastSame = t;
                } else {
                    t = lastSame + (n + 1);
                    while (cacheList[t] != '\0') {
                        t++;
                    }
                    lastSame = t;
                    cacheList[t] = entry.getKey();
                }
            }
        }
        System.out.println();
        for (int i = cacheList.length - 1; i >= 0; i--) {
            if (cacheList[i] != '\0') {
                return i + 1;
            }
        }
        return length;
    }

    public static int leastIntervalAnswer1(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

}
