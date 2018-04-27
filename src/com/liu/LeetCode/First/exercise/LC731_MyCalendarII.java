package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liu on 2017/9/30.
 */
public class LC731_MyCalendarII {
    /**
     * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
     * <p>
     * Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
     * <p>
     * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
     * <p>
     * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
     * <p>
     * Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     * Example 1:
     * MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(50, 60); // returns true
     * MyCalendar.book(10, 40); // returns true
     * MyCalendar.book(5, 15); // returns false
     * MyCalendar.book(5, 10); // returns true
     * MyCalendar.book(25, 55); // returns true
     * Explanation:
     * The first two events can be booked.  The third event can be double booked.
     * The fourth event (5, 15) can't be booked, because it would result in a triple booking.
     * The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
     * The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
     * the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
     * Note:
     * <p>
     * The number of calls to MyCalendar.book per test case will be at most 1000.
     * In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
     * Hint:
     * Store two sorted lists of intervals: one list will be all times that are at least single booked,
     * and another list will be all times that are definitely double booked.
     * If none of the double bookings conflict, then the booking will succeed,
     * and you should update your single and double bookings accordingly.
     */

    public static abstract class CalendarII {
        public abstract boolean book(int startTime, int endTime);
    }

    // 无法处理(24,40)(43,50)(27,43)这种情况，在这个情况下第二个map里面会出现(27,43)而非(27,40)进而导致错误
    public static class MyCalendarIIMy1 extends CalendarII {
        TreeMap<Integer, Integer> calendarFirst;
        TreeMap<Integer, Integer> calendarSecond;

        public MyCalendarIIMy1() {
            calendarFirst = new TreeMap<>();
            calendarSecond = new TreeMap<>();
        }

        @Override
        public boolean book(int startTime, int endTime) {
            boolean needBookSecondCalendar = false;
            Integer floorKeyFirst = calendarFirst.floorKey(startTime);
            if (floorKeyFirst != null && calendarFirst.get(floorKeyFirst) > startTime) {
                Integer floorKeySecond = calendarSecond.floorKey(startTime);
                needBookSecondCalendar = true;
                if (floorKeySecond != null && calendarSecond.get(floorKeySecond) > startTime) {
                    return false;
                }
            }
            Integer ceilingKeyFirst = calendarFirst.ceilingKey(startTime);
            if (ceilingKeyFirst != null && ceilingKeyFirst < endTime) {
                Integer ceilingKeySecond = calendarSecond.ceilingKey(startTime);
                needBookSecondCalendar = true;
                if (ceilingKeySecond != null && ceilingKeySecond < endTime) {
                    return false;
                }
            }
            calendarFirst.put(startTime, endTime);
            if (needBookSecondCalendar) {
                int start = floorKeyFirst != null ? Math.max(startTime, floorKeyFirst) : startTime;
                int end = ceilingKeyFirst != null ? Math.min(endTime, ceilingKeyFirst) : endTime;
                calendarSecond.put(start, end);
            }
            return true;
        }
    }

    public static MyCalendarIIMy1 getMyCalendarIIMy1() {
        return new MyCalendarIIMy1();
    }

    public static class MyCalendarIIAnswer1 extends CalendarII {
        TreeMap<Integer, Integer> calendar;

        public MyCalendarIIAnswer1() {
            calendar = new TreeMap<>();
        }

        @Override
        public boolean book(int startTime, int endTime) {
            calendar.put(startTime, calendar.getOrDefault(startTime, 0) + 1); // 先计入，其中start作为起点计入正数，end作为终点记为负数
            calendar.put(endTime, calendar.getOrDefault(endTime, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : calendar.entrySet()) {
                count += entry.getValue();
                if (count > 2) { // 当出现连续三个起点的时候，说明出现问题
                    calendar.put(startTime, calendar.get(startTime) - 1);
                    if (calendar.get(startTime) == 0) { // 此时根据计数，将一开始计入的数据给清除掉
                        calendar.remove(startTime);
                    }
                    calendar.put(endTime, calendar.get(endTime) + 1);
                    if (calendar.get(endTime) == 0) {
                        calendar.remove(endTime);
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public static MyCalendarIIAnswer1 getMyCalendarIIAnswer1() {
        return new MyCalendarIIAnswer1();
    }

    // https://leetcode.com/problems/my-calendar-ii/discuss/109519/JavaC++-Clean-Code-with-Explanation
    public static class MyCalendarIIAnswer2 extends CalendarII {
        private List<int[]> books;

        public MyCalendarIIAnswer2() {
            books = new ArrayList<>();
        }

        @Override
        public boolean book(int startTime, int endTime) {
            MyCalendar overlaps = new MyCalendar();
            for (int[] b : books) {
                if (Math.max(b[0], startTime) < Math.min(b[1], endTime)) {// overlap exist
                    if (!overlaps.book(Math.max(b[0], startTime), Math.min(b[1], endTime))) {
                        return false; // overlaps overlapped
                    }
                }
            }
            books.add(new int[]{startTime, endTime});
            return true;
        }

        private static class MyCalendar {
            List<int[]> books = new ArrayList<>();

            public boolean book(int start, int end) {
                for (int[] b : books) {
                    if (Math.max(b[0], start) < Math.min(b[1], end)) {
                        return false;
                    }
                }
                books.add(new int[]{start, end});
                return true;
            }
        }
    }

    public static MyCalendarIIAnswer2 getMyCalendarIIAnswer2() {
        return new MyCalendarIIAnswer2();
    }
}
