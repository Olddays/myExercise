package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC108_Abs {

    /**
     * 输入一个浮点数,输出它的绝对值,保留两位小数.
     */

    public static double getAbsMy1(double n) {
        String cacheDouble = String.format("%.2f", Math.abs(n));
        return Double.valueOf(cacheDouble);
    }
}
