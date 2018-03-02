package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2017/9/14.
 */
public class LC006_ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * <p>
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string text, int nRows);
     * <p>
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */

    // 在各种情况下会出现问题
    public static String getZigZagConversionMy1(String s, int numRows) {
        if (s.length() < numRows || numRows <= 1) {
            return s;
        }
        String result = "";
        char[] inputArray = s.toCharArray();
        if (numRows == 2) {
            String cache = "";
            for (int i = 0; i < inputArray.length; i++) {
                if (i % 2 == 0) {
                    result += inputArray[i];
                } else {
                    cache += inputArray[i];
                }
            }
            result += cache;
            return result;
        }
        List<Character>[] cacheList = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            cacheList[i] = new ArrayList<>();
        }
        int count = 0;
        cacheList[count].add(inputArray[0]);
        boolean down = true;
        int key = numRows - 1;
        for (int i = 1; i < inputArray.length; i++) {
            char c = inputArray[i];
            count++;
            if (((count - 1) / key) % 2 == 1) {
                down = !down;
            }
            int lineNo = count % (down ? numRows + 1 : numRows - 1);
            cacheList[lineNo].add(c);
        }
        for (List<Character> list : cacheList) {
            for (char c : list) {
                result += c;
            }
        }
        return result;
    }

    // 列几个样例会发现一个规律,即每一个v行样式的最后一个值都是numRows的2倍减2.
    // 故可以从对称性的角度解决,每个最低点都是numRows-1的数字.
    public static String getZigZagConversionMy2(String s, int numRows) {
        if (s.length() < numRows || numRows <= 1) {
            return s;
        }
        String result = "";
        char[] inputArray = s.toCharArray();
        List<Character>[] cacheList = new List[numRows];
        for (int i = 0; i < numRows; i++) {
            cacheList[i] = new ArrayList<>();
        }
        boolean down = false;
        int key = numRows - 1;
        for (int i = 0; i < inputArray.length; i++) {
            char c = inputArray[i];
            if (i % key == 0) {
                down = !down;
            }
            int lineNo = down ? i % key : (key - i % key);
            cacheList[lineNo].add(c);
        }
        for (List<Character> list : cacheList) {
            for (char c : list) {
                result += c;
            }
        }
        return result;
    }
}
