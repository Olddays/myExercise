package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by liu on 2017/9/30.
 */
public class LC729_MyCalendarI {
    /**
     * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.
     * <p>
     * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
     * <p>
     * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
     * <p>
     * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
     * <p>
     * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     * Example 1:
     * MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(15, 25); // returns false
     * MyCalendar.book(20, 30); // returns true
     * Explanation:
     * The first event can be booked.  The second can't because time 15 is already booked by another event.
     * The third event can be booked, as the first event takes every time less than 20, but not including 20.
     * Note:
     * <p>
     * The number of calls to MyCalendar.book per test case will be at most 1000.
     * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
     * <p>
     * Hint:
     * Store the events as a sorted list of intervals.
     * If none of the events conflict, then the new event can be added.
     */

    // 结构上的错误,构建了一对一的链接,
    // 会导致输入(47, 50)(33, 41)(39, 45)这种交叉情况时会出现错误
    public static class MyCalendarIMy1 {
        private List<Integer> startList;
        private List<Integer> endList;

        public MyCalendarIMy1() {
            startList = new ArrayList<>();
            endList = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            if (startTime > endTime) {
                return false;
            }
            if (startList.size() == 0) {
                startList.add(startTime);
                endList.add(endTime);
                return true;
            }
            if (startList.size() == 1) {
                if (endList.get(0) <= startTime) {
                    startList.add(0, startTime);
                    endList.add(0, endTime);
                    return true;
                }
                if (endTime <= startList.get(0)) {
                    startList.add(startTime);
                    endList.add(endTime);
                    return true;
                }
            }
            if (endTime < startList.get(0)) {
                startList.add(0, startTime);
                endList.add(0, endTime);
                return true;
            }
            if (endList.get(endList.size() - 1) < startTime) {
                startList.add(endList.size() - 1, startTime);
                endList.add(endList.size() - 1, endTime);
                return true;
            }
            for (int i = 1; i < startList.size(); i++) {
                int nowStart = startList.get(i);
                int lastEnd = endList.get(i - 1);
                if (lastEnd <= startTime && endTime <= nowStart) {
                    startList.add(i, startTime);
                    endList.add(i, endTime);
                    return true;
                }
            }
            return false;
        }
    }

    public static MyCalendarIMy1 getMyCalendarIMy1() {
        return new MyCalendarIMy1();
    }

    // 当输入过大的时候时间复杂度过高
    public static class MyCalendarIMy2 {
        private boolean[] dateList;
        private int nowSize;

        public MyCalendarIMy2() {
            nowSize = 1;
            dateList = new boolean[nowSize];
        }

        public boolean book(int startTime, int endTime) {
            if (startTime > endTime) {
                return false;
            }
            if (nowSize < endTime) {
                boolean[] newList = new boolean[endTime + 1];
                for (int i = 0; i < dateList.length; i++) {
                    newList[i] = dateList[i];
                }
                dateList = newList;
                nowSize = endTime;
            }
            for (int i = startTime; i < endTime; i++) {
                if (dateList[i]) {
                    return false;
                }
            }
            for (int i = startTime; i < endTime; i++) {
                dateList[i] = true;
            }
            return true;
        }
    }

    public static MyCalendarIMy2 getMyCalendarIMy2() {
        return new MyCalendarIMy2();
    }


    public static class MyCalendarIAnswer1 {
        TreeMap<Integer, Integer> calendar;

        public MyCalendarIAnswer1() {
            calendar = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            Integer floorKey = calendar.floorKey(startTime);
            if (floorKey != null && calendar.get(floorKey) > startTime) {
                return false;
            }
            Integer ceilingKey = calendar.ceilingKey(startTime);
            if (ceilingKey != null && ceilingKey < endTime) {
                return false;
            }

            calendar.put(startTime, endTime);
            return true;
        }
    }

    public static MyCalendarIAnswer1 getMyCalendarIAnswer1() {
        return new MyCalendarIAnswer1();
    }
}
