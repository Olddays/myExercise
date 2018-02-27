package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC201_Digit {

    /**
     * 输入一个不超过10的9次方的正整数,输出它的位数.例如12735的位数是5.请不要使用任何数学函数,只用四则运算和循环语句实现.
     */

    public static int getDigitMy1(int n) {
        int result = 0;
        while (n > 0) {
            n = n / 10;
            result++;
        }
        return result;
    }
}
