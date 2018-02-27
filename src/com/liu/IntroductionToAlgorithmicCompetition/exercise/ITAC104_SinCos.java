package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC104_SinCos {

    /**
     * 输入正整数n(n<360),输出n度的正弦\余弦函数值. 提示: 使用数学函数
     */

    public static double[] getSinCosMy1(int n) {
        double[] result = new double[2];
        result[0] = Math.sin(n);
        result[1] = Math.cos(n);
        return result;
    }
}
