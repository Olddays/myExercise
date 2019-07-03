package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC208_Subsequence {

    /**
     * 输入两个正整数 n < m < 10的6次方, 输出 1/n² + 1/(n+1)² + … + 1/m², 保留5位小数.
     * 例如n=2,m=4时答案是0.42361, n=65536,m=655360时答案是0.00001. 注意:本题有陷阱.
     */

    public static double getSubsequenceMy1(int n, int m) {
        double result = 0;
        for (int i = n; i <= m; i++) {
            result += (double) 1 / Math.pow(i, 2);
        }
        String cacheDouble = String.format("%.5f", result);
        return Double.valueOf(cacheDouble);
    }
}
