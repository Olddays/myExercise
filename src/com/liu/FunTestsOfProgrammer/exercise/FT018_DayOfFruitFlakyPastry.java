package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT018_DayOfFruitFlakyPastry {
    /**
     * 日本每月的22日是水果酥饼日。
     * 因为看日历的时候，22日的上方刚好是15日，也就是“‘22’这个数字上面点缀着草莓” 。
     * 切分酥饼的时候，要求切分后每一块上面的草莓个数都不相同。
     * 假设切分出来的N块酥饼上要各有“1~N 个（共 N(N ＋ 1)÷2 个草莓）”。
     * 但这里要追加一个条件，那就是“一定要使相邻的两块酥饼上的数字之和是平方数”。
     * 举个例子，假设N＝4时采用如图4的切法。
     * 这时，虽然1＋3＝4得到的是平方数，但“1 和 4”“ 2 和 3”“ 2 和 4”的部分都不满足条件（图4）。
     * <p>
     * 问题
     * 求可以使切法满足条件的最小的 N（N ＞ 1）。
     */

    // 方案可用，但是遍历时间太长
    public static int getDayOfFruitFlakyPastryMy1() {
        int result = 32;
        while (true) {
            int maxCount = result * (result + 1) / 2;
            List<Integer> squareNumList = new ArrayList<>();
            for (int i = 1; i * i <= maxCount; i++) {
                squareNumList.add(i * i);
            }
            List<Integer> usableNumList = new ArrayList<>();
            for (int i = 1; i <= result; i++) {
                usableNumList.add(i);
            }
            if (checkSquareMy1(usableNumList, squareNumList)) {
                return result;
            }
            result++;
        }
    }

    private static boolean checkSquareMy1(List<Integer> usableNumList, List<Integer> squareNumList) {
        List<int[]> list = new ArrayList<>();
        int[] cache = new int[usableNumList.size()];
        for (int i = 0; i < usableNumList.size(); i++) {
            cache[i] = usableNumList.get(i);
        }
        getUsableNumSet(list, cache, 0, usableNumList.size());
        for (int[] set : list) {
            boolean allDataContain = true;
            for (int i : set) {
                if (!squareNumList.contains(i)) {
                    allDataContain = false;
                    break;
                }
            }
            if (allDataContain) {
                return true;
            }
        }
        return false;
    }

    private static void getUsableNumSet(List<int[]> list, int[] usableNumList, int start, int length) {
        if (start == length - 1) {
            int[] cache = new int[length];
            for (int i = 0; i < length; i++) {
                cache[i] = usableNumList[i] + usableNumList[(i + 1) % length];
            }
            if (!list.contains(cache)) {
                list.add(cache);
            }
        } else {
            for (int i = start; i < length; i++) {
                int temp = usableNumList[start];
                usableNumList[start] = usableNumList[i];
                usableNumList[i] = temp;
                getUsableNumSet(list, usableNumList, start + 1, length);
                temp = usableNumList[start];
                usableNumList[start] = usableNumList[i];
                usableNumList[i] = temp;
            }
        }
    }

    public static int getDayOfFruitFlakyPastryMy2() {
        int result = 32;
        while (true) {
            int maxCount = result * 2 - 1; // 相邻的两块最大合
            List<Integer> squareNumList = new ArrayList<>();
            for (int i = 1; i * i <= maxCount; i++) {
                squareNumList.add(i * i);
            }
            List<Integer> usableNumList = new ArrayList<>();
            for (int i = 1; i <= result; i++) {
                usableNumList.add(i);
            }
            List<Integer> log = new ArrayList<>();
            log.add(1);
            if (checkSquareMy2(result, 1, log, squareNumList, usableNumList)) {
                return result;
            }
            result++;
        }
    }

    // 先计算好都有哪些可用的平方数，然后进行判断。
    // 切分后是个循环队列，所以可以认为第一个恒定为1，因为是可以循环到1开始的。
    // 在处理过程中保证每次下一个都满足平方数的条件即可。
    private static boolean checkSquareMy2(int n, int pre, List<Integer> log, List<Integer> squareNumList, List<Integer> usableNumList) {
        if (n == log.size()) {
            if (squareNumList.contains(1 + pre)) {
                return true;
            }
        } else {
            for (int i : usableNumList) {
                if (!log.contains(i)) {
                    if (squareNumList.contains(pre + i)) {
                        log.add(i);
                        boolean checked = checkSquareMy2(n, i, log, squareNumList, usableNumList);
                        if (checked) {
                            return true;
                        }
                        log.remove(new Integer(i));
                    }
                }
            }
        }
        return false;
    }
}