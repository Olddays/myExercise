package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC101_Average {

    /**
     * 输入整数数组,输出它们的平均值,保留3位小数.
     */

    public static double getAverageMy1(int[] nums) {
        int length = nums.length;
        double result = 0;
        if (length == 0) {
            return result;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        String cacheDouble = String.format("%.3f", (double)sum / (double)length);
        result = Double.valueOf(cacheDouble);
        return result;
    }

}
