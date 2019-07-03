package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT001_DecimalismPlalindrome {
    /**
     * 如果把某个数的各个数字按相反的 顺序排列，得到的数和原来的数相同，则 这个数就是“回文数”。譬如 123454321 就是一个回文数。
     * 问题:
     * 求用十进制、二进制、八进制表示都是回 文数的所有数字中，大于十进制数 10 的最小值。
     * 例:
     * 9(十进制数)= 1001(二进制数)=11( 八进制数)
     * ※ 本例中的十进制数 9 小于 10，因此不符合要求。
     */

    public static int getDecimalismPlalindromeMy1() {
        int result = 11;
        while (true) {
            List<Integer> binary = getDataList(result, 2);
            List<Integer> octonary = getDataList(result, 8);
            List<Integer> decimalism = getDataList(result, 10);
            if (checkPlalindrome(binary) && checkPlalindrome(octonary) && checkPlalindrome(decimalism)) {
                return result;
            }
            result++;
        }
    }

    private static List<Integer> getDataList(int input, int target) {
        List<Integer> list = new ArrayList<>();
        int cache = input;
        while (cache > 0) {
            list.add(cache % target);
            cache = cache / target;
        }
        return list;
    }

    private static boolean checkPlalindrome(List<Integer> list) {
        int length = list.size();
        boolean isSingleNum = length % 2 == 1;
        if (!isSingleNum) {
            int left = 0;
            int right = length - 1;
            while (left < right) {
                if (!list.get(left++).equals(list.get(right--))) {
                    return false;
                }
            }
            return true;
        } else {
            int left = 0;
            int right = length - 1;
            while (left < right - 1) {
                if (!list.get(left++).equals(list.get(right--))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int getDecimalismPlalindromeAnswer1() {
        int result = 11;
        while (true) {
            String binary = Integer.toBinaryString(result);
            String octonary = Integer.toOctalString(result);
            String decimalism = String.valueOf(result);
            if (checkPlalindrome(binary) && checkPlalindrome(octonary) && checkPlalindrome(decimalism)) {
                return result;
            }
            result += 2;
            // 因为是二进制的回文数，所以如果最低位是 0，那么相应地最高位 也是 0。但是，以 0 开头肯定是不恰当的，由此可知最低位为 1。
            // 如果用二进制表示时最低位为 1，那这个数一定是奇数，因此只考 虑奇数的情况就可以。
        }
    }

    private static boolean checkPlalindrome(String input) {
        int length = input.length();
        boolean isSingleNum = length % 2 == 1;
        if (!isSingleNum) {
            int left = 0;
            int right = length - 1;
            while (left < right) {
                if (input.charAt(left++) != input.charAt(right--)) {
                    return false;
                }
            }
            return true;
        } else {
            int left = 0;
            int right = length - 1;
            while (left < right - 1) {
                if (input.charAt(left++) != input.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
