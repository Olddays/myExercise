package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT016_StringSquares {
    /**
     * 假设分别将3根长度相同的绳子摆成3个四边形。其中2根摆成长方形，剩下1根摆成正方形。
     * 这时，会出现2个长方形的面积之和等于正方形面积的情况（假设长方形和正方形的各边长都为整数）。
     * <p>
     * 例）绳子长度为20时，可以折出以下这些正方形和长方形。
     * 第 1 根  长 1× 宽 9 的长方形  →  面积＝ 9
     * 第 2 根  长 2× 宽 8 的长方形  →  面积＝ 16
     * 第 3 根  长 5× 宽 5 的正方形  →  面积＝ 25
     * 进一步改变绳子长度并摆成长方形和正方形，统计满足条件的长方形和正方形的组合。
     * 这里，将同比整数倍的结果看作同一种解法。
     * 例）绳子长度为40, 60, …时，可以通过对上例进行等比运算得出以下这些正方形和长方形的组合，
     * 但要将它们看作同一种解法，所以这一类只统计为1种。
     *  ● 绳子长度＝ 40
     * 　第 1 根  长 2× 宽 18 的长方形    →  面积＝ 36
     * 　第 2 根  长 4× 宽 16 的长方形    →  面积＝ 64
     * 　第 3 根  长 10× 宽 10 的正方形  →  面积＝ 100
     *  ● 绳子长度＝ 60
     * 　第 1 根  长 3× 宽 27 的长方形    →  面积＝ 81
     * 　第 2 根  长 6× 宽 24 的长方形    →  面积＝ 144
     * 　第 3 根  长 15× 宽 15 的正方形  →  面积＝ 225
     * <p>
     * 问题：
     * 求绳子长度从 1 增长到 500 时，共有多少种组合能使摆出的 2 个长方形面积之和等于正方形的面积？
     */

    public static int getStringSquaresMy1(int maxLength) {
        List<String> result = new ArrayList<>();
        for (int i = 4; i <= maxLength; i += 4) {
            int lengthCount = i / 2;
            int squareArea = i / 4 * i / 4;
            int firstHeight = 1;
            int firstWidth = lengthCount - 1;
            while (firstHeight <= firstWidth) {
                int firstArea = firstHeight * firstWidth;
                int secondHeight = 1;
                int secondWidth = lengthCount - 1;
                while (secondHeight <= secondWidth) {
                    int secondArea = secondHeight * secondWidth;
                    secondHeight++;
                    secondWidth--;
                    if (firstArea + secondArea == squareArea) {
                        int gcd = getGreatestCommonDivisor(firstArea, secondArea);
                        String proportion = String.valueOf(firstArea / gcd)
                                + String.valueOf(secondArea / gcd);
                        if (!result.contains(proportion)) {
                            result.add(proportion);
                        }
                    }
                }
                firstHeight++;
                firstWidth--;
            }
        }
        return result.size() / 2;
    }

    // 周长相等，故设正方形的面积为c²，则一个长方形为(c-x)(c+x)=c²-x²，
    // 则剩下的满足条件的面积为c²-(c²-x²)=x²，
    // 则可以认为四边形面积应该满足a²+b²=c²，即满足勾股定理。
    // 同时由于同比整数倍的结果看作同一种，则可以认为a和b的最大公约数应该为1。
    // 由于左右互换算作同一种，最后返回值要除2。
    public static int getStringSquaresMy2(int maxLength) {
        int result = 0;
        for (int c = 1; c <= maxLength / 4; c++) {
            for (int b = 1; b <= c - 1; b++) {
                for (int a = 1; a <= c - 1; a++) {
                    if (c * c == b * b + a * a) {
                        if (getGreatestCommonDivisor(a, b) == 1) {
                            result++;
                        }
                    }
                }
            }
        }
        return result / 2;
    }

    private static int getGreatestCommonDivisor(int a, int b) {
        int max = Math.max(a, b);
        for (int i = max; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
