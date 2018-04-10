package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT017_ThreeLeggedRace {
    /**
     * 以前有个电视节目，全国各地的小学生在这个节目里参加“30人31足”竞赛。
     * 后来电视剧里也出现过这些小学生练习的场景，并且全国大赛时小学生们表现出来的速度也曾引人注目。
     * 下面探讨一下什么样的排列顺序在“30人31足”比赛里比较有利。
     * 多个女生连续排列，体力上会处于劣势，所以原则是尽量不让女生相邻（男生可以连续排列）。
     * <p>
     * 问题：
     * 求 30 个人排成一排时，一共有多少种有利的排列方式？
     * 假设这里只考虑男女的排列情况，不考虑具体某个人的位置。
     * 举个例子，4个人（4人5足）的情况下如图3所示，共有8种排列方式。
     * Hint:
     * 与其考虑所有人的排列情况，不如看看一个人一个人地增加的方法，这样可能简单一些
     * 思路：
     * 在满足条件的排列方法中，“每次添加一人，并保证女生不会连续排列”这种方法相对简单。
     * 那么，当n 人排列时，如果最右边是男生， 则“加一个男生或者一个女生”；
     * 如果最右边是女生，则“只能加一个男生”。
     * 我们还可以再换个角度来看，具体如下。
     *  ● 如果第 n 个人是男生，则第 n － 1 个人可以是男生也可以是女生
     *  ● 如果第 n 个人是女生，则第 n － 1 个人只能是男生 也相当于下面这样：
     *  ● 如果最后一个人是男生，则排列方式数与 n － 1 个人时一致
     *  ● 如果最后一个人是女生，则第n －1个人是男生… 排列方式数与n － 2 个人时一致
     * 即斐波那契额数列
     */

    public static int getThreeLeggedRaceMy1(int maxNumber) {
        // 输入要+1的原因是我们要判断正要加入第31个人的时候的情况
        return getNextRace(maxNumber + 1);
    }

    private static int getNextRace(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return getNextRace(num - 2) + getNextRace(num - 1);
    }
}