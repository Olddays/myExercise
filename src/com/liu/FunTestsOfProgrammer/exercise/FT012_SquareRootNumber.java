package com.liu.FunTestsOfProgrammer.exercise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 218/02/28.
 */
public class FT012_SquareRootNumber {
    /**
     * 我们初中的时候就学过平方根，说起“根”大家都应该有印象。
     * 举个例子，2 的平方根就是 ±1.414213562373095048...这个无限小数。
     * 不只是 Excel，大部分的编程语言都内置了求平方根的函数，使用起来非常简单。
     * <p>
     * 问题:
     * 求在计算平方根的时候，最早让 0~9 的数字全部出现的最小整数。
     * 注意这里只求平方根为正数的情况，并且请分别求包含整数部分的情况和只看小数部分的情况。
     * 例) 2 的平方根 :1.414213562373095048...     ( 0 ~ 9全部出现需要19位)
     */

    public static Map<Integer, Integer> getSquareRootNumberMy1(int maxNum) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i <= maxNum; i++) {
            String[] parts = highQualitySqrt(i).split("\\.");
            if (parts.length < 2) {
                continue;
            }
            char[] cache = parts[1].toCharArray();
            int num = getAllFoundIndexNum(cache);
            if (num > 0) {
                result.put(i, num);
            }
        }
        return result;
    }

    private static String highQualitySqrt(int input) {
        BigDecimal x1 = new BigDecimal(1);
        BigDecimal x2;
        BigDecimal dif;

        BigDecimal precision = x1.divide(new BigDecimal(10).pow(100));
        while (true) {
            x2 = x1.subtract(x1.pow(2).subtract(new BigDecimal(input)).divide(x1.multiply(new BigDecimal(input)),
                    100, BigDecimal.ROUND_HALF_EVEN));
            if (x1.compareTo(x2) == 1) {
                dif = x1.subtract(x2);
            } else {
                dif = x2.subtract(x1);
            }
            if (dif.compareTo(precision) == -1) {
                break;
            }
            x1 = x2;
        }
        return String.valueOf(x1);
    }

    // 由于没有限制最大输入，则我们可以直接的认为，当小数点后的十个位置满足我们的需要的时候就是对应的数字
    // 所以我们可以认为不需要进行高精度的运算
    public static Map<Integer, Integer> getSquareRootNumberMy2(int maxNum) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i <= maxNum; i++) {
            String[] parts = String.valueOf(Math.sqrt(i)).split("\\.");
            if (parts.length < 2) {
                continue;
            }
            char[] cache = parts[1].toCharArray();
            int num = getAllFoundIndexNum(cache);
            if (num > 0) {
                result.put(i, num);
            }
        }
        return result;
    }

    private static int getAllFoundIndexNum(char[] cache) {
        boolean[] catcher = new boolean[10];
        int nowFoundCount = 0;
        for (int j = 0; j < cache.length; j++) {
            char c = cache[j];
            int index = Integer.valueOf(String.valueOf(c));
            if (!catcher[index]) {
                catcher[index] = true;
                nowFoundCount++;
            }
            if (nowFoundCount == 10) {
                return j + 1;
            }
        }
        return 0;
    }
}
