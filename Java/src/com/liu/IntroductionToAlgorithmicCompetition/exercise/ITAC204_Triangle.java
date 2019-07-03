package com.liu.IntroductionToAlgorithmicCompetition.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC204_Triangle {

    /**
     * 输入正整数n<=20,输出一个n层的倒三角形.例如n=5时输出如下:
     * #########
     *  #######
     *   #####
     *    ###
     *     #
     */

    public static void getTriangleMy1(int n) {
        for (int i = n; i >= 0; i--) {
            String printString = "";
            for (int j = 0; j < n - i; j++) {
                printString += " ";
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                printString += "#";
            }
            System.out.println(printString);
        }
    }
}
