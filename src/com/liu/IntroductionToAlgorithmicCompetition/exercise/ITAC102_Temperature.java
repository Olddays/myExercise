package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC102_Temperature {

    /**
     * 输入华氏温度f,输出对应的摄氏温度c,保留3位小数. 提示: c = 5(f-32)/9
     */

    public static double getTemperatureMy1(int f) {
        String cacheDouble = String.format("%.3f",
                (double) ((f - 32) * 5) / (double) 9);
        return Double.valueOf(cacheDouble);
    }
}
