package com.liu.LeetCode.ThirtyDays202004.exercise;

public class TD12_LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i : stones) {
            max = Math.max(i, max);
        }
        int[] wights = new int[max + 1];
        for (int i : stones) {
            wights[i]++;
        }
        int cache = max;
        wights[max]--;
        int local = max;
        while (local > 0) {
            if (wights[local] > 0) {
                if (cache > 0) {
                    int diff = cache - local;
                    wights[diff]++;
                    wights[local]--;
                    cache = 0;
                    if (diff > local) {
                        local = diff;
                    }
                } else {
                    cache = local;
                    wights[local]--;
                }
            } else {
                local--;
            }
        }
        return cache;
    }
}
