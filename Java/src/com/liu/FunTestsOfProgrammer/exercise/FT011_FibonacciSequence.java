package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT011_FibonacciSequence {
    /**
     * 斐波那契数列因古希腊建筑《伯特农神殿》和雕塑《米罗的维纳斯》上出现的“黄金分割”而闻名，有许多有趣的数学特性。
     * 斐波那契数列由两个 1 开端，其后的每一位数字都是前两位数字之和。
     * 譬如 1 和 1 的和为 2，1 和 2 的和为 3，2 和 3 的和为 5，3 和 5 的 和为 8......一直这样继续计算下去，
     * 就得到下面这样的数列。
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * 这个数列就是“斐波那契数列”。计算这个数列中相邻两个数的商值，可以得到如表 1 所示的结果。
     * 可以看到，商值最终慢慢地趋近 1.618。这就是有名的“黄金分割”的由来。
     * <p>
     * 表1  斐波那契数列的数字
     * 1/1 = 1.00000
     * 2/1 = 2.00000
     * 3/2 = 1.50000
     * 5/3 = 1.66667
     * 8/5 = 1.60000
     * 13/8 = 1.62500
     * 21/13 = 1.61538
     * 34/21 = 1.61905
     * 55/34 = 1.61765
     * 89/55 = 1.61818
     * <p>
     * 问题:
     * 如下例所示，用斐波那契数列中的每个数除以其数位上所有数字之和。
     * 请继续例中的计算，求出后续 5 个最小的能整除的数。
     * 例)
     * 2     → 2÷2
     * 3     → 3÷3
     * 5     → 5÷5
     * 8     → 8÷8
     * 21   → 21÷3  ... 2+1=3，因而除以3
     * 144 → 144÷9  ... 1 + 4 + 4 = 9，因而除以 9
     * Hint:
     * 斐波那契数列计算下去，很快数值就会变得非常大，要注意位数。
     */

    public static List<Long> getFibonacciSequenceMy1(int resultSize) {
        List<Long> result = new ArrayList<>();
        long nowSize = 0;
        long first = 1;
        long second = 1;
        while (nowSize < resultSize) {
            if (second % getDigitNumSum(second) == 0) {
                nowSize++;
                result.add(second);
            }
            long cache = first;
            first = second;
            second += cache;
        }
        return result;
    }

    private static long getDigitNumSum(long input) {
        long result = 0;
        long cache = input;
        while (cache > 0) {
            result += cache % 10;
            cache /= 10;
        }
        return result;
    }
}
