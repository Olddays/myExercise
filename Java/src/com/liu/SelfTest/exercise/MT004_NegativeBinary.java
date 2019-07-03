package com.liu.SelfTest.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 11/02/2018.
 */
public class MT004_NegativeBinary {

    // 输入数字,输出一个从左到右排序的-2进制的形式的表示.(输入内容是非负整数)

    public static int[] getNegativeBinaryMy1(int input) {
        if (input < 0) {
            return new int[0];
        }

        // 先确定最后结果多少位
        int sum = 1;
        int idx = 0;
        while (sum < input) {
            idx += 1;
            sum += Math.pow(2, idx * 2);
        }
        idx = idx * 2 + 1;

        // 状态初始化
        int[] result = new int[idx];

        // 最后一位初始化
        if (input > 0) {
            result[idx - 1] = 1;
            sum = input - (int) Math.pow(2, idx - 1);
            idx -= 1;
        } else {
            sum = 0;
        }
        if (sum < 1) {
            return result;
        }

//        for (int i = 0; i < idx; i++) {
//            int cache = (int) Math.pow(-2, idx);
//            for (int j = 0; j < 2; j++) {
//                if (j == 0) {
//                    sum -= cache;
//                } else {
//                    sum += cache;
//                }
//            }
//        }


//        int[][] cache = new int[idx + 1][idx + 1];
//        for (int i = 1; i <= idx; i++) {
//            cache[i][0] = cache[i - 1][0] + (int) Math.pow(-2, i - 1);
//        }
//        for (int j = 1; j <= idx; j++) {
//            cache[0][j] = cache[0][j - 1] + (int) Math.pow(-2, j - 1);
//        }
//
//        for (int i = 1; i <= idx; i++) {
//            for (int j = 1; j <= idx; j++) {
//                cache[i][j] = cache[i - 1][j - 1] + (int) Math.pow(-2, Math.max(i - 1, j - 1));
//            }
//        }

//        checkNextLocation(result, idx - 1, sum);

        return result;
    }

    private static boolean checkNextLocation(int[] set, int idx, int sum) {
        System.out.print(sum + " ");
        if (sum == 0) {
            return true;
        }
        int cache = (int) Math.pow(-2, idx);
        if (idx >= 0) {  //使用递归进行遍历左孩子
            boolean result = checkNextLocation(set, idx - 1, sum - cache);
            if (result) {
                set[idx] = 1;
                return true;
            } else {
                set[idx] = 0;
                return false;
            }
        }
        return false;
    }
}
