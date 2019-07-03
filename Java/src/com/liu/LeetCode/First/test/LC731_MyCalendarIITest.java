package com.liu.LeetCode.First.test;

import java.util.ArrayList;
import java.util.List;

import static com.liu.LeetCode.First.exercise.LC731_MyCalendarII.*;

/**
 * Created by liu on 2017/9/14.
 */
public class LC731_MyCalendarIITest {

    public static void main(String[] args) {
//        int[] startTimes = {
//                10, 50, 10, 5, 5, 25
//        };
//        int[] endTimes = {
//                20, 60, 40, 15, 10, 55
//        };
        int[] startTimes = {
                24, 43, 27, 5, 30, 14, 3, 3, 25, 6
        };
        int[] endTimes = {
                40, 50, 43, 21, 40, 29, 19, 14, 39, 19
        };
        boolean result;
        long startTime;
        long endTime;

        List<CalendarII> resultList = new ArrayList<>();
        resultList.add(testMy1());
        resultList.add(testAnswer1());
        resultList.add(testAnswer2());
        for (CalendarII calendarII : resultList) {
            for (int i = 0; i < startTimes.length; i++) {
                startTime = System.currentTimeMillis();
                result = calendarII.book(startTimes[i], endTimes[i]);
                endTime = System.currentTimeMillis();
                String[] testClassNameParts = calendarII.getClass().toString().split("II");
                String testClassName = testClassNameParts[testClassNameParts.length - 1];
                System.out.println("MyCalendarII " + testClassName
                        + " times " + i + " result " + result + " during time " + (endTime - startTime));
            }
            System.out.println();
        }
    }

    private static MyCalendarIIMy1 testMy1() {
        return getMyCalendarIIMy1();
    }

    private static MyCalendarIIAnswer1 testAnswer1() {
        return getMyCalendarIIAnswer1();
    }

    private static MyCalendarIIAnswer2 testAnswer2() {
        return getMyCalendarIIAnswer2();
    }
}
