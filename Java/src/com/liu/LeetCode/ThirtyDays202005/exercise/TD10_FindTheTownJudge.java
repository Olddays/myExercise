package com.liu.LeetCode.ThirtyDays202005.exercise;

import java.util.HashMap;

/**
 * Created by Liu on 2020/5/10.
 */
public class TD10_FindTheTownJudge {
    public static int findJudge(int N, int[][] trust) {
        if (N <= 1) {
            return N;
        }
        HashMap<Integer, Integer> beTrustedSet = new HashMap<>();
        boolean[] toTrustSet = new boolean[N + 1];
        for (int[] pair : trust) {
            int toTrust = pair[0];
            int beTrusted = pair[1];
            toTrustSet[toTrust] = true;
            beTrustedSet.put(beTrusted, beTrustedSet.getOrDefault(beTrusted, 0) + 1);
        }
        for (int i = 1; i <= N; i++) {
            boolean toTrust = toTrustSet[i];
            if (!toTrust && beTrustedSet.getOrDefault(i, 0) == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
