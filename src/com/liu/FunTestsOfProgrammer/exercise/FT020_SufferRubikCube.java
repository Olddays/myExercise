package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT020_SufferRubikCube {
    /**
     * 西班牙有个著名景点叫圣家堂,其中“受难立面”上主要画着耶稣从“最后的晚餐”到“升天”的场景,
     * 其中还有一个如下所示的魔方阵,因“纵、横、对角线的数字之和都是33”而闻名(据说耶稣辞世时是33岁)
     * 如果不局限于由纵、横、对角线的数字相加,那么和数为33的组合有310种之多
     * (网上有很多“4个数字相加......”这样的问题,如果限定只能由4个数字相加,则是88种)。
     * 1 14 14 4
     * 11 7 6 9
     * 8 10 10 5
     * 13 2 3 15
     * <p>
     * 问题：
     * 使用这个魔方阵,进行满足下列条件的加法运算,求“和相同的组合”的种数最多时的和。
     * 【条件】
     * ● ● 不限于由纵、横、对角线上的数字相加
     * ● ● 加数的个数不限于 4 个
     * ※ 能得出 33 这个“和”的组合共有 310 种。因此,如果组合数没有超过 310 种,那么最后答案就是 33。
     * <p>
     * Hint：
     * 这里是穷举所有加法运算的组合,注意尽量优化处理速度。
     */

    public static int getSufferRubikCubeMy1(int[][] cubeSet) {
        return 0;
    }
}