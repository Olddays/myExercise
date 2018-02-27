package com.liu.IntroductionToAlgorithmicCompetition.exercise;

/**
 * Created by baidu on 2016/12/30.
 */
public class ITAC205_Stat {

    /**
     * 输入一个正整数n,然后读取n个正整数a1,a2,a3,…,an,最后再读一个正整数m.统计a1,a2,a3,…,an中有多少个整数的值小于m.
     * 提示: 如果重定向和fopen都可以使用,哪个比较方便?
     */

    public static int getStatMy1(int[] nums, int m) {
        int result = 0;
        for (int num : nums) {
            if (num < m) {
                result++;
            }
        }
        return result;
    }
}
