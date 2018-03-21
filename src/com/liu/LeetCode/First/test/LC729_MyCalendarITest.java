package com.liu.LeetCode.First.test;

import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.getMyCalendarIAnswer1;
import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.getMyCalendarIMy1;
import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.getMyCalendarIMy2;
import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.MyCalendarIMy1;
import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.MyCalendarIMy2;
import static com.liu.LeetCode.First.exercise.LC729_MyCalendarI.MyCalendarIAnswer1;

/**
 * Created by liu on 2017/9/14.
 */
public class LC729_MyCalendarITest {

    public static void main(String[] args) {
//        int[] startTimes = {
//                10, 15, 20
//        };
//        int[] endTimes = {
//                20, 25, 30
//        };
        int[] startTimes = {
                47, 33, 39, 33, 25, 26, 19, 3, 8, 18
        };
        int[] endTimes = {
                50, 41, 45, 42, 32, 35, 25, 8, 13, 27
        };
        boolean result;
        long startTime;
        long endTime;

        MyCalendarIMy1 resultMy1 = testMy1();
        for (int i = 0; i < startTimes.length; i++) {
            startTime = System.currentTimeMillis();
            result = resultMy1.book(startTimes[i], endTimes[i]);
            endTime = System.currentTimeMillis();
            System.out.println("MyCalendarI My 1 times " + i + " result " + result + " during time " + (endTime - startTime));
        }

        MyCalendarIMy2 resultMy2 = testMy2();
        for (int i = 0; i < startTimes.length; i++) {
            startTime = System.currentTimeMillis();
            result = resultMy2.book(startTimes[i], endTimes[i]);
            endTime = System.currentTimeMillis();
            System.out.println("MyCalendarI My 2 times " + i + " result " + result + " during time " + (endTime - startTime));
        }

        MyCalendarIAnswer1 resultAnswer1 = testAnswer1();
        for (int i = 0; i < startTimes.length; i++) {
            startTime = System.currentTimeMillis();
            result = resultAnswer1.book(startTimes[i], endTimes[i]);
            endTime = System.currentTimeMillis();
            System.out.println("MyCalendarI Answer 1 times " + i + "  result " + result + " during time " + (endTime - startTime));
        }
    }

    private static MyCalendarIMy1 testMy1() {
        return getMyCalendarIMy1();
    }

    private static MyCalendarIMy2 testMy2() {
        return getMyCalendarIMy2();
    }

    private static MyCalendarIAnswer1 testAnswer1() {
        return getMyCalendarIAnswer1();
    }
}
