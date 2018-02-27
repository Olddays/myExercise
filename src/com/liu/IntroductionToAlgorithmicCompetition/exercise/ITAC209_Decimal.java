package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC209_Decimal {

    /**
     * 输入正整数a,b,c,输出a/b的小数形式,精确到小数点后c位,a,b<=10的6吃饭,c<=100.
     * 例如 a=1,b=6,c=4时应输出0.1667
     */

    public static double getDecimalMy1(int a, int b, int c) {
        double result = (double) a / (double) b;
        String cacheDouble = String.format("%." + c + "f", result);
        return Double.valueOf(cacheDouble);
    }
}
