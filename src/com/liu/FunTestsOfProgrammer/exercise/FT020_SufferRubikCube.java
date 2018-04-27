package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 218/02/28.
 */
public class FT020_SufferRubikCube {
    /**
     * 西班牙有个著名景点叫圣家堂,其中“受难立面”上主要画着耶稣从“最后的晚餐”到“升天”的场景,
     * 其中还有一个如下所示的魔方阵,因“纵、横、对角线的数字之和都是33”而闻名(据说耶稣辞世时是33岁)
     * 如果不局限于由纵、横、对角线的数字相加,那么和数为33的组合有310种之多
     * (网上有很多“4个数字相加......”这样的问题,如果限定只能由4个数字相加,则是88种)。
     * 1 14 14 4
     * 11 7 6 9
     * 8 10 10 5
     * 13 2 3 15
     * <p>
     * 问题：
     * 使用这个魔方阵,进行满足下列条件的加法运算,求“和相同的组合”的种数最多时的和。
     * 【条件】
     * ● ● 不限于由纵、横、对角线上的数字相加
     * ● ● 加数的个数不限于 4 个
     * ※ 能得出 33 这个“和”的组合共有 310 种。因此,如果组合数没有超过 310 种,那么最后答案就是 33。
     * <p>
     * Hint：
     * 这里是穷举所有加法运算的组合,注意尽量优化处理速度。
     */

    // 将数字根据是否出现进行编码，然后遍历全部可能的编码，再根据编码进行求和后比较
    // 时间复杂度太高
    public static int getSufferRubikCubeMy1(int[] cubeSet) {
        int length = cubeSet.length;
        List<String> codingList = new ArrayList<>();
        for (int i = 0; i <= length; i++) { // 取i个1
            int[] coding = new int[length];
            for (int j = 0; j < i; j++) {
                coding[j] = 1;
            }
            getSetFullPermutation(codingList, coding, 0, length);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for (String coding : codingList) {
            int total = 0;
            char[] codeList = coding.toCharArray();
            for (int i = 0; i < length; i++) {
                char code = codeList[i];
                if (code == '1') {
                    total += cubeSet[i];
                }
            }
            if (cache.containsKey(total)) {
                cache.put(total, cache.get(total) + 1);
            } else {
                cache.put(total, 1);
            }
        }
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    private static void getSetFullPermutation(List<String> list, int[] coding, int start, int end) {
        if (start == end - 1) {
            String cache = "";
            for (int i = 0; i < end; i++) {
                cache += coding[i];
            }
            if (!list.contains(cache)) {
                list.add(cache);
            }
        } else {
            for (int i = start + 1; i < end; i++) {
                int temp = coding[start];
                coding[start] = coding[i];
                coding[i] = temp;
                getSetFullPermutation(list, coding, start + 1, end);
                temp = coding[start];
                coding[start] = coding[i];
                coding[i] = temp;
            }
        }
    }

    public static int getSufferRubikCubeMy2(int[] cubeSet) {
        int sum = 0;
        for (int cube : cubeSet) {
            sum += cube;
        }
        int[] cache = new int[sum + 1];
        cache[0] = 1;
        for (int cube : cubeSet) {
            for (int i = sum - cube; i >= 0; i--) {
                cache[i + cube] += cache[i];
            }
        }
        int max = 0;
        int result = 0;
        for (int i = 0; i < sum + 1; i++) {
            int count = cache[i];
            if (max < count) {
                max = count;
                result = i;
            }
        }
        return result;
    }
}