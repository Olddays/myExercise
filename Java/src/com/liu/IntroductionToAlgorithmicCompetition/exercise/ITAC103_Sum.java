package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC103_Sum {

    /**
     * 输入正整数n,输出1+2+…+n的值. 提示: 目标是解决问题,而不是练习变成.
     */

    public static int getSumMy1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
