package com.liu.LeetCode.Daily.Daily202505;

import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC2094_Finding3_DigitEvenNumbers {

    // back trace
    // 带有剪枝
    // Time Limit Exceeded
    private static int[] findEvenNumbersMy1Error(int[] digits) {
        Set<Integer> result = new HashSet<>();
        boolean[] visited = new boolean[digits.length];
        findEvenNumbersMy1Helper(digits, 0, visited, 0, result);
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int num : result) {
            resultArray[index++] = num;
        }
        Arrays.sort(resultArray);
        return resultArray;
    }

    private static void findEvenNumbersMy1Helper(int[] digits, int count, boolean[] visited, int cache, Set<Integer> result) {
        if (count == 3) {
            result.add(cache);
        }
        for (int i = 0; i < digits.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (digits[i] == 0 && cache == 0) { // 规避0在前和单数
                findEvenNumbersMy1Helper(digits, count, visited, cache, result);
            } else if (digits[i] % 2 == 1 && count == 2) { // 规避奇数
                findEvenNumbersMy1Helper(digits, count, visited, cache, result);
            } else {
                findEvenNumbersMy1Helper(digits, count + 1, visited, cache * 10 + digits[i], result);
            }
            visited[i] = false;
        }
    }

    // Beats 92.10%
    private static int[] findEvenNumbersMy1(int[] digits) {
        int[] map = new int[10];
        for (int num : digits) {
            map[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) { // 百位
            if (map[i] == 0) { // 已经没有可用值
                continue;
            }
            map[i]--; // 记录使用
            for (int j = 0; j <= 9; j++) {// 十位
                if (map[j] == 0) { // 已经没有可用值
                    continue;
                }
                map[j]--; // 记录使用
                for (int k = 0; k <= 8; k += 2) { // 个位
                    if (map[k] == 0) { // 已经没有可用值
                        continue;
                    }
                    map[k]--; // 记录使用
                    res.add(i * 100 + j * 10 + k);
                    map[k]++; // 回溯
                }
                map[j]++; // 回溯
            }
            map[i]++; // 回溯
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] arrList = new int[][]{
                {1, 8, 7, 7, 1, 1, 5, 4, 0, 0, 7, 5, 1, 7, 9},
                {2, 1, 3, 0},
                {2, 2, 8, 8, 2},
                {3, 7, 5},
        };
        int[][] resultList = new int[][]{
                {100, 104, 108, 110, 114, 118, 140, 148, 150, 154, 158, 170, 174, 178, 180, 184, 190, 194, 198, 400, 408, 410, 418, 450, 458, 470, 478, 480, 490, 498, 500, 504, 508, 510, 514, 518, 540, 548, 550, 554, 558, 570, 574, 578, 580, 584, 590, 594, 598, 700, 704, 708, 710, 714, 718, 740, 748, 750, 754, 758, 770, 774, 778, 780, 784, 790, 794, 798, 800, 804, 810, 814, 840, 850, 854, 870, 874, 890, 894, 900, 904, 908, 910, 914, 918, 940, 948, 950, 954, 958, 970, 974, 978, 980, 984},
                {102, 120, 130, 132, 210, 230, 302, 310, 312, 320},
                {222, 228, 282, 288, 822, 828, 882},
                {},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < arrList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findEvenNumbersMy1(arrList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findEvenNumbers My1 result" + i + " " + Arrays.toString(result) + " result check "
                    + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
