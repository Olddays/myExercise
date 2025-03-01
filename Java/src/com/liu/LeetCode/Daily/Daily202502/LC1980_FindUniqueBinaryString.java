package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC1980_FindUniqueBinaryString {

    // 因为输入的数据只有n个，那么只要依次选择，第一个的第一位的反，第二个的第二位的反，第三个的第三位的反，就可以得到答案
    // 因为结果肯定和每个答案都不一样，因为跟每个已有数据都有一位是反的
    // 类似 对角论证法 Cantor's diagonal argument https://en.wikipedia.org/wiki/Cantor%27s_diagonal_argument
    private static String findDifferentBinaryStringMy1(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');              // Using ternary operator
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[][] numsList = new String[][]{
                {"00", "10"},
                {"00", "01"},
                {"01", "10"},
                {"111", "011", "001"},
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findDifferentBinaryStringMy1(numsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findDifferentBinaryString My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
