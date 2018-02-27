package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC206_Harmony {

    /**
     * 调和级数,输入正整数n,输出H(n) = 1 + 1/2 + 1/3 + …… + 1/n 的值,保留3位小数.例如n=3时答案为1.833.
     */

    public static double getHarmonyMy1(int n) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += (double)1 / (double)i;
        }
        String cacheDouble = String.format("%.3f", result);
        return Double.valueOf(cacheDouble);
    }
}
