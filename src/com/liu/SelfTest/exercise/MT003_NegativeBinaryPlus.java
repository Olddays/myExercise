package com.liu.SelfTest.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 11/02/2018.
 */
public class MT003_NegativeBinaryPlus {

    // 输入一个从左到右排序的-2进制数字,输出此数字+1后的值的-2进制从左到右排序形式的表示.(输入内容是非负整数的-2进制表示)

    public static int[] getNegativeBinaryPlusAnswer1(int[] input) {
        if (input.length == 0) {
            return new int[0];
        }
        List<Integer> cache = new ArrayList<>();
        int idx = 0;
        int residue = 1;
        while (residue != 0 || idx < input.length) {
            if (idx >= input.length) {
                cache.add(residue);
            } else {
                cache.add(input[idx] + residue);
            }
            if (cache.get(idx) == 2) {
                cache.set(idx, 0);
                residue = -1;
            } else if (cache.get(idx) == -1) {
                cache.set(idx, 1);
                residue = 1;
            } else {
                residue = 0;
            }
            idx += 1;
        }
        int[] result = new int[cache.size()];
        for (int i = 0; i < cache.size(); i++) {
            result[i] = cache.get(i);
        }
        return result;
    }
}
