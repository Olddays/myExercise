package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC110_Year {

    /**
     * 输入年份,判断是否为闰年. 如果是,则输出"yes",否则输出"no". 提示: 简单地判断除以4的余数是不够的.
     */

    public static String getYearMy1(int year) {
        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
