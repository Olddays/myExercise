package com.liu.LeetCode.Daily.Daily202504;

import java.util.*;

public class LC2145_CountTheHiddenSequences {

    // 因为这个是个lower到upper的范围，也就是说differences中，如果是一直正（单调增）或者一直负（单调减）的话，可能会越界
    // 那么就找到单调增最大增多少，单调减最多减多少，压缩differences
    // 换句话说，也就是找到difference遍历过程中叠加出来的最大最小值
    // 然后与lower和upper进行计算处理
    // The last two iterators are initialized with 0 because the initial difference for a[0] is 0 as there is no element present to the left of it.
    // 最大值最小值的默认值应该都是0，因为a[0]是0，因为左侧没有值，所以diff是0
    // Beats 92.06%
    private static int numberOfArraysMy1(int[] differences, int lower, int upper) {
        long maxDiff = 0; // 这里的min和max都是diff，所以不会出现Integer.MIN_VALUE和Integer.MAX_VALUE
        long minDiff = 0;
        long sum = 0;
        for (int difference : differences) {
            sum += difference;
            maxDiff = Math.max(maxDiff, sum);
            minDiff = Math.min(minDiff, sum);
        }
        // 此时最小值l的取值范围就是 l+min>=lower && l+max<upper 也就是 l在[lower-min, upper-max)
        // 此时最大值u的取值范围就是 u+min>lower && u+max<=upper 也就是 u在(lower-min, upper-max]
        return (int) Math.max(0, (upper - maxDiff) - (lower - minDiff) + 1);
    }

    public static void main(String[] args) {
        int[][] differencesList = new int[][]{
                {-40},
                {4, -7, 2},
                {1, -3, 4},
                {3, -4, 5, 1, -2},
        };
        int[] lowerList = new int[]{
                -46,
                3,
                1,
                -4,
        };
        int[] upperList = new int[]{
                53,
                6,
                6,
                5,
        };
        int[] resultList = new int[]{
                60,
                0,
                2,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < differencesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numberOfArraysMy1(differencesList[i], lowerList[i], upperList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numberOfArrays My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
