package com.liu.IntroductionToAlgorithmicCompetition.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC202_Daffodil {

    /**
     * 输出100~999中的所有水仙花数.水仙花数是指一个n位数(n≥3),它的每个位上的数字的n次幂之和等于它本身.例如153 = 1的三次方+5的三次方+3的三次方
     */

    public static List<Integer> getDaffodilMy1() {
        List<Integer> result = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            int cache = 0;
            char[] list = String.valueOf(i).toCharArray();
            for (char c : list) {
                cache += Math.pow(c - '0', list.length);
            }
            if (i == cache) {
                result.add(i);
            }
        }
        return result;
    }
}
