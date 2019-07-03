package com.liu.FunTestsOfProgrammer.exercise;


import java.util.*;

/**
 * Created by liu on 218/02/28.
 */
public class FT023_WinnerTakesAllTwentyOne {
    /**
     * 赌场经典的二十一点游戏中，每回合最少下注1枚硬币，赢了可以得到2枚硬币，输了硬币会被收走。
     * 假设最开始只拥有1枚硬币，并且每回合下注1枚，那么4回合后还能剩余硬币的硬币枚数变化情况如下所示，共有6种。
     * * 1-赢-2-赢-3-赢-4-赢-5
     * * |    |   |    |
     * * 输   |   |    输
     * * |    |   输   |
     * * 0    |   |    3
     * *      |   |
     * *      输   2-赢-3
     * *      |  |
     * *      |   输
     * *      |   |
     * *      |   1
     * *      |
     * *      1-赢-2-赢-3
     * *      |    |
     * *      输   1
     * *      |
     * *      0
     * 问题
     * 求最开始拥有10枚硬币时，持续24回合后硬币还能剩余的硬币枚数变化情况共有多少种？
     * <p>
     * Hint：
     * 使用深度优先搜索的树状结构会相对简单
     */

    // 由于有输和赢两种情况，则可以看作一个二叉树，每个节点上的数字作为当前硬币的数量
    // 且起始节点的数量和最深节点的深度根据输入参数判断
    public static int getWinnerTakesAllTwentyOneMy1(int startNum, int depth) {
        List<List<Integer>> cache = new ArrayList<>();
        getUsablePathList(cache, new ArrayList<>(), depth, startNum, 0);
        return cache.size();
    }

    private static void getUsablePathList(List<List<Integer>> result, ArrayList<Integer> cache, int totalDepth,
                                          int nowNum, int nowDepth) {
        if (nowNum > 0) {
            if (nowDepth == totalDepth) {
                result.add(new ArrayList<>(cache));
            } else {
                // 输
                cache.add(nowNum - 1);
                getUsablePathList(result, cache, totalDepth, nowNum - 1, nowDepth + 1);
                cache.remove(cache.size() - 1);
                // 赢
                cache.add(nowNum + 1);
                getUsablePathList(result, cache, totalDepth, nowNum + 1, nowDepth + 1);
                cache.remove(cache.size() - 1);
            }
        }
    }

    // 省略了数据的输入、记录与比对，降低了很多的时间复杂度，但是方法一更加通用，能把过程路径记录下来
    public static int getWinnerTakesAllTwentyOneMy2(int startNum, int depth) {
        if (startNum == 0) {
            return 0;
        }
        if (depth == 0) {
            return 1;
        }
        int win = getWinnerTakesAllTwentyOneMy2(startNum + 1, depth - 1); // 赢的路径数量
        int lose = getWinnerTakesAllTwentyOneMy2(startNum - 1, depth - 1); // 输的路径数量
        return win + lose;
    }

}