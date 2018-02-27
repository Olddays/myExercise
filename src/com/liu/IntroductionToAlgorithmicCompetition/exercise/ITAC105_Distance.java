package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC105_Distance {

    /**
     * 输入4个浮点数x1,y1,x2,y2,输出平面坐标系中点(x1,y1)到点(x2,y2)的距离.
     */

    public static double getDistanceMy1(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
