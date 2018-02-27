package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC207_Approximation {

    /**
     * 近似计算,计算 π/4 = 1 - 1/3 + 1/5 - 1/7 + ……, 直到最后一项小于10的-6次方
     */

    public static double getApproximationMy1() {
        double result = 0;
        int n = 1;
        boolean shouldAdd = true;
        while ((double) 1 / (double) n > 0.000001) {
            if (shouldAdd) {
                result += (double) 1 / (double) n;
            } else {
                result -= (double) 1 / (double) n;
            }
            shouldAdd = !shouldAdd;
            n += 2;
        }
        return result;
    }
}
