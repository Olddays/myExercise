package com.liu.SelfTest.exercise;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by liu on 2016/12/30.
 */
public class MT001_DynamicProgrammingCoinNumber {

    // 如果我们有面值为{1, 2, 5}的硬币若干,如何使用最少的硬币凑够M元
    // 动态规划,要找到子问题和状态转移方程

    public static int getDynamicProgrammingCoinNumberMy1(int[] coins, int target) {
        int[] stepCache = new int[target + 1];
        ArrayList<Integer> oneStepCache = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    oneStepCache.add(stepCache[i - coins[j]] + 1);
                }
            }
            if (oneStepCache.size() > 0) {
                Collections.sort(oneStepCache);
                stepCache[i] = oneStepCache.get(0);
                oneStepCache.clear();
            } else {
                stepCache[i] = 0;
            }
        }
        return stepCache[target];
    }

}
