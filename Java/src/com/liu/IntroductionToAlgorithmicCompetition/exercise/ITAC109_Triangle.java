package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC109_Triangle {

    /**
     * 输入三角形三边长度值(均为正整数),判断它是否能为直角三角形的三个边长.
     * 如果可以则输出"yes",如果不能,则输出"no".如果根本无法构成三角形,则输出"not a triangle".
     */

    public static String getTriangleMy1(int x, int y, int z) {
        double x2 = Math.pow(x, 2);
        double y2 = Math.pow(y, 2);
        double z2 = Math.pow(z, 2);
        if (x2 + y2 == z2) {
            return "yes";
        } else if (x2 + y2 > z2) {
            return "no";
        } else {
            return "not a triangle";
        }
    }
}
