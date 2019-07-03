package com.liu.FunTestsOfProgrammer.exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT007_BinaryDate {
    /**
     * 问题
     * 把年月日表示为 YYYYMMDD 这样的 8 位整数，然后把这个整数转换成 二进制数并且逆序排列，再把得到的二进制数转换成十进制数，求与原日期一致的日期。
     * 求得的日期要在上一次东京奥运会(1964 年 10 月 10 日)到下一 次东京奥运会(预定举办日期为 2020 年 7 月 24 日)之间。
     * 例)日期为1966年7月13日时
     * 1 YYYYMMDD 格式→ 19660713
     * 2 转换成二进制数→ 1001010111111111110101001
     * 3 逆序排列→ 1001010111111111110101001
     * 4 把逆序排列得到的二进制数转换成十进制数→ 19660713
     * ......回到 1966 年 7 月 13 日(最初的日期)
     * Hint:
     * 这里如何处理日期是关键。特别是每个月的天数不尽相同，还需要考虑闰年的问题。
     * 脚本语言大多都有处理日期的工具库，可以利用起来。
     */

    public static List<Integer> getBinaryDateMy1(int startDate, int endDate) {
        Calendar start = Calendar.getInstance();
        start.set(startDate / 10000, startDate / 100 % 100, startDate % 100);
        Long startTime = start.getTimeInMillis();

        Calendar end = Calendar.getInstance();
        end.set(endDate / 10000, endDate % 10000 / 100, endDate % 100);
        Long endTime = end.getTimeInMillis();

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTime;
        List<Integer> result = new ArrayList<>();
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            int date = Integer.valueOf(df.format(d));
            if (checkPlalindrome(date)) {
                result.add(date);
            }
            time += oneDay;
        }
        return result;
    }

    private static boolean checkPlalindrome(int date) {
        String binary = Integer.toBinaryString(date);
        int left = 0;
        int right = binary.length() - 1;
        if (binary.length() % 2 == 1) {
            while (left < right - 1) {
                if (binary.charAt(left++) != binary.charAt(right--)) {
                    return false;
                }
            }
        } else {
            while (left < right) {
                if (binary.charAt(left++) != binary.charAt(right--)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> getBinaryDateMy2(int startDate, int endDate) {
        Calendar start = Calendar.getInstance();
        start.set(startDate / 10000, startDate / 100 % 100, startDate % 100);
        Long startTime = start.getTimeInMillis();

        Calendar end = Calendar.getInstance();
        end.set(endDate / 10000, endDate % 10000 / 100, endDate % 100);
        Long endTime = end.getTimeInMillis();

        Long oneDay = 1000 * 60 * 60 * 24l;

        Long time = startTime;
        List<Integer> result = new ArrayList<>();
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            int date = Integer.valueOf(df.format(d));

            if (Integer.parseInt(reverseString(Integer.toBinaryString(date)), 2) == date) {
                result.add(date);
            }

            time += oneDay;
        }
        return result;
    }

    private static String reverseString(String input) {
        int length = input.length();
        if (length <= 1)
            return input;
        String left = input.substring(0, length / 2);
        String right = input.substring(length / 2, length);
        return reverseString(right) + reverseString(left);
    }
}
