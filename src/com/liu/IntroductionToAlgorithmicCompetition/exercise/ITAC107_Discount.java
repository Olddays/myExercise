package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC107_Discount {

    /**
     * 一件衣服95元,若消费满300元,可以打八五折. 输入购买衣服件数,输出需要支付的金额(单位:元),保存两位小数.
     */

    public static double getDiscountMy1(int n) {
        int sum = n * 30;
        if (sum >= 300) {
            return 300 * 0.85;
        }
        return sum;
    }
}
