package com.liu.IntroductionToAlgorithmicCompetition.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2016/12/30.
 */
public class ITAC210_Permutation {

    /**
     * 用1,2,3,…,9组成3个三位数,abc,def和ghi,每个数字恰好使用一次,要求abc:def:ghi = 1:2:3.输出所有解.
     * 提示,不用太动脑筋
     */

    public static List<List<Integer>> getPermutationMy1() {
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 123; first <= 329; first++) {
            int second = first * 2;
            int third = first * 3;
            int result_add = 0;
            int result_mul = 1;

            int a;
            int b;
            int c;

            // 对于第一个值
            a = first / 100;        //百位
            b = first / 10 % 10;    //十位
            c = first % 10;         //个位
            result_add += a + b + c;    //分解出来的位数相加
            result_mul *= a * b * c;    //相乘

            // 对于第二个值
            a = second / 100;        //百位
            b = second / 10 % 10;    //十位
            c = second % 10;         //个位
            result_add += a + b + c;    //分解出来的位数相加
            result_mul *= a * b * c;    //相乘

            // 对于第三个值
            a = third / 100;        //百位
            b = third / 10 % 10;    //十位
            c = third % 10;         //个位
            result_add += a + b + c;    //分解出来的位数相加
            result_mul *= a * b * c;    //相乘

            // 判断数据合理性
            if (result_add == 45 && result_mul == 362880) {
                List<Integer> cache = new ArrayList<>();
                cache.add(first);
                cache.add(second);
                cache.add(third);
                result.add(cache);
            }
        }
        return result;
    }
}
