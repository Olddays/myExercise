package com.liu.LeetApp.exercise;

/**
 * Created by baidu on 2016/11/30.
 */
public class LA004_AddBinary {
    // Given two binary strings, return their sum (also a binary string).

    // For example.
    // a = "11"
    // b = "1"
    // Return "100"

    // Difficulty: Easy

    // Error 计算错误 输入"111", "11"时会输出 1244949
    public static String getAddBinaryMy1(String a, String b) {
        String result = "";
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return result;
        }
        if (a.length() < b.length()) {
            String tem = a;
            a = b;
            b = tem;
        }
        int carry = 0;
        int aLength = a.length();
        int bLength = b.length();
        String cacheA = a.substring(aLength - bLength);
        String cacheB = a.substring(0, aLength - bLength);
        for (int i = b.length() - 1; i >= 0; i--) {
            int sum = (int) cacheA.charAt(i) + b.charAt(i) + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        for (int i = cacheB.length() - 1; i >= 0; i--) {
            int sum = (int) cacheB.charAt(i) + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    // Error 问题同上 Integer是无法解决的,charAt会直接得到对应数据的ASCII码,其中'1' = 49
    public static String getAddBinaryMy2(String a, String b) {
        String result = "";
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return result;
        }
        if (a.length() < b.length()) {
            String tem = a;
            a = b;
            b = tem;
        }
        int carry = 0;
        int aLength = a.length();
        int bLength = b.length();
        String cacheA = a.substring(aLength - bLength);
        String cacheB = a.substring(0, aLength - bLength);
        for (int i = b.length() - 1; i >= 0; i--) {
            int sum = Integer.valueOf(cacheA.charAt(i)) + Integer.valueOf(b.charAt(i)) + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        for (int i = cacheB.length() - 1; i >= 0; i--) {
            int sum = Integer.valueOf(cacheB.charAt(i)) + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    // Error 计算错误 输入"111", "11"时会输出"1011",carry和result的计算方式反了
    public static String getAddBinaryMy3(String a, String b) {
        String result = "";
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return result;
        }
        if (a.length() < b.length()) {
            String tem = a;
            a = b;
            b = tem;
        }
        int carry = 0;
        int aLength = a.length();
        int bLength = b.length();
        String cacheA = a.substring(aLength - bLength);
        String cacheB = a.substring(0, aLength - bLength);
        for (int i = b.length() - 1; i >= 0; i--) {
            int sum = cacheA.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        for (int i = cacheB.length() - 1; i >= 0; i--) {
            int sum = cacheB.charAt(i) - '0' + carry;
            carry = sum % 2;
            result = String.valueOf(sum / 2) + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    // Not Perfect 代码比较冗长,做了字符串切片比较容易出问题
    public static String getAddBinaryMy4(String a, String b) {
        String result = "";
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return result;
        }
        if (a.length() < b.length()) {
            String tem = a;
            a = b;
            b = tem;
        }
        int carry = 0;
        int aLength = a.length();
        int bLength = b.length();
        String cacheA = a.substring(aLength - bLength);
        String cacheB = a.substring(0, aLength - bLength);
        for (int i = b.length() - 1; i >= 0; i--) {
            int sum = cacheA.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        for (int i = cacheB.length() - 1; i >= 0; i--) {
            int sum = cacheB.charAt(i) - '0' + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2) + result;
        }
        if (carry == 1) {
            result = "1" + result;
        }
        return result;
    }

    public static String getAddBinaryAnswer(String a, String b) {
        if (a.length() < b.length()) {
            String tem = a;
            a = b;
            b = tem;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;
        String result = "";
        while (pb >= 0) {
            int sum = (a.charAt(pa) - '0') + (b.charAt(pb) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pa--;
            pb--;
        }
        while (pa >= 0) {
            int sum = (a.charAt(pa) - '0') + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            pa--;
        }
        if (carries == 1) {
            result = "1" + result;
        }
        return result;
    }
}
