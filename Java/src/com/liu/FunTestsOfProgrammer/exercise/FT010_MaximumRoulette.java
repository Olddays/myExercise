package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT010_MaximumRoulette {
    /**
     * 轮盘游戏被称为“赌场女王”。
     * 庄家在转动的轮盘中投入滚珠，挑战者的神经跟随滚珠，滚珠落入押注数字的那一刻，
     * 一本千金的迷幻梦境在心头挥之不去。
     * 流传较广的轮盘数字排布和设计有“欧式规则”和“美式规则”两种。
     * 下面我们要找出在这些规则下，“连续 n 个数字的和”最大的位置。
     * 举个例子，当n ＝ 3 时，按照欧式规则得到的和最大的组合是36, 11, 30 这个组合，
     * 和为77；而美式规则 下则是24, 36, 13 这个组合，得到的和为 73（ 图10 ）。
     * <p>
     * 欧式规则
     * 0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30,
     * 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7,
     * 28, 12, 35, 3, 26
     * <p>
     * 美式规则 0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15,
     * 3, 24, 36, 13, 1, 00, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6,
     * 21, 33, 16, 4, 23, 35, 14, 2
     * <p>
     * 问题：
     * 当2≤n ≤ 36 时，求连续n个数之和最大的情况，
     * 并找出满足条件 欧式规则下的和小于美式规则下的和的 n 的个数。
     * Hint：
     * 因为转盘是圆形的，所以如果用数组表示，要注意访问的元素下标。
     */

    private static final int[] EUROPE_RULE = {
            0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30,
            8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7,
            28, 12, 35, 3, 26};

    private static final int[] AMERICA_RULE = {
            0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15,
            3, 24, 36, 13, 1, 00, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6,
            21, 33, 16, 4, 23, 35, 14, 2};

    // 动态规划 把排序问题转化成一个路径数量问题
    public static List<Integer> getMaximumRouletteMy1(int minN, int maxN) {
        List<Integer> result = new ArrayList<>();
        for (int i = minN; i <= maxN; i++) {
            if (getMaximumRoulette(EUROPE_RULE, i) < getMaximumRoulette(AMERICA_RULE, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static int getMaximumRoulette(int[] input, int n) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            int cache = 0;
            for (int j = 0; j < n; j++) {
                cache += input[(i + j) % input.length];
            }
            result = Math.max(result, cache);
        }
        return result;
    }
}
