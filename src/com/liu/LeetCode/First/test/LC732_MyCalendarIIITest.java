package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC732_MyCalendarIII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC732_MyCalendarIIITest {

    public static void main(String[] args) {
        int[] startTimes = {
                10, 50, 10, 5, 5, 25
        };
        int[] endTimes = {
                20, 60, 40, 15, 10, 55
        };
//        int[] startTimes = {
//                24, 43, 27, 5, 30, 14, 3, 3, 25, 6
//        };
//        int[] endTimes = {
//                40, 50, 43, 21, 40, 29, 19, 14, 39, 19
//        };
        int result;
        long startTime;
        long endTime;

        CalendarIII calendarII = testMy1();
        for (int i = 0; i < startTimes.length; i++) {
            startTime = System.currentTimeMillis();
            result = calendarII.book(startTimes[i], endTimes[i]);
            endTime = System.currentTimeMillis();
            System.out.println("MyCalendarIII My 1 times " + i + " result " + result + " during time " + (endTime - startTime));
        }
    }

    private static MyCalendarIIIMy1 testMy1() {
        return getMyCalendarIIIMy1();
    }
}
