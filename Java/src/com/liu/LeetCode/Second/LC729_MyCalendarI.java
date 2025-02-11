package com.liu.LeetCode.Second;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC729_MyCalendarI {
    // Beats 32.99%
    private static class MyCalendarMy1 {
        private int minTime;
        private int maxTime;
        private List<int[]> bookList;

        public MyCalendarMy1() {
            minTime = Integer.MAX_VALUE;
            maxTime = Integer.MIN_VALUE;
            bookList = new ArrayList<>();
        }

        public boolean book(int startTime, int endTime) {
            if (endTime < minTime) {
                combineBookList(0, startTime, endTime);
                return true;
            }
            if (startTime > maxTime) {
                combineBookList(bookList.size(), startTime, endTime);
                return true;
            }
            int index = searchBookListIndex(startTime, endTime);
            if (index == -1) {
                return false;
            }
            combineBookList(index, startTime, endTime);
            return true;
        }

        private int searchBookListIndex(int startTime, int endTime) {
            for (int i = 0; i < bookList.size(); i++) {
                int[] book = bookList.get(i);
                if (startTime > book[1]) {
                    continue;
                }
                if (startTime >= book[0] && startTime < book[1]) {
                    return -1;
                }
                if (endTime > book[0] && endTime <= book[1]) {
                    return -1;
                }
                if (startTime <= book[0] && endTime >= book[1]) {
                    return -1;
                }
                if (endTime <= book[0]) {
                    return i;
                }
            }
            return bookList.size();
        }

        private void combineBookList(int index, int startTime, int endTime) {
            if (bookList.isEmpty()) {
                bookList.add(new int[]{startTime, endTime});
                minTime = startTime;
                maxTime = endTime;
                return;
            }
            if (index == 0) {
                minTime = startTime;
                int[] book = bookList.get(0);
                if (book[0] == endTime) {
                    book[0] = startTime;
                    return;
                }
                bookList.add(0, new int[]{startTime, endTime});
            } else if (index == bookList.size()) {
                maxTime = endTime;
                int[] book = bookList.get(bookList.size() - 1);
                if (book[1] == startTime) {
                    book[1] = endTime;
                    return;
                }
                bookList.add(bookList.size(), new int[]{startTime, endTime});
            } else {
                int[] lastBook = bookList.get(index - 1);
                int[] book = bookList.get(index);
                if (book[0] == endTime && lastBook[1] == startTime) {
                    lastBook[1] = book[1];
                    bookList.remove(book);
                } else if (book[0] == endTime) {
                    book[0] = startTime;
                } else if (lastBook[1] == startTime) {
                    lastBook[1] = endTime;
                } else {
                    bookList.add(index, new int[]{startTime, endTime});
                }
            }
        }

    }

    // 使用TreeMap可以节省很多问题，内部自动排序了
    private static class MyCalendarAnswer1 {
        private TreeMap<Integer, Integer> calendar;

        public MyCalendarAnswer1() {
            calendar = new TreeMap<>();
            calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
            boolean res = end <= pair.getValue();
            if (res) {
                calendar.put(end, start);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][][] bookList = new int[][][]{
                {{97, 100}, {33, 51}, {89, 100}, {83, 100}, {75, 92}, {76, 95}, {19, 30}, {53, 63}, {8, 23}, {18, 37}, {87, 100}, {83, 100}, {54, 67}, {35, 48}, {58, 75}, {70, 89}, {13, 32}, {44, 63}, {51, 62}, {2, 15}},
                {{40, 49}, {40, 49}, {49, 50}, {49, 50}, {27, 34}, {23, 30}, {39, 46}, {8, 15}, {3, 9}, {2, 8}, {48, 50}, {46, 50}, {4, 12}, {4, 10}, {30, 36}, {47, 50}, {15, 23}, {43, 50}, {49, 50}, {24, 33}, {17, 26}, {3, 11}, {45, 50}, {3, 8}, {32, 40}, {37, 43}, {5, 13}, {0, 9}, {48, 50}, {14, 22}},
                {{20, 29}, {13, 22}, {44, 50}, {1, 7}, {2, 10}, {14, 20}, {19, 25}, {36, 42}, {45, 50}, {47, 50}, {39, 45}, {44, 50}, {16, 25}, {45, 50}, {45, 50}, {12, 20}, {21, 29}, {11, 20}, {12, 17}, {34, 40}, {10, 18}, {38, 44}, {23, 32}, {38, 44}, {15, 20}, {27, 33}, {34, 42}, {44, 50}, {35, 40}, {24, 31}},
                {{10, 20}, {15, 25}, {20, 30}},
                {{47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32}, {26, 35}, {19, 25}, {3, 8}, {8, 13}, {18, 27}},
                {{37, 50}, {33, 50}, {4, 17}, {35, 48}, {8, 25}},
        };
        long startTime;
        boolean result;
        long endTime;

        for (int i = 0; i < bookList.length; i++) {
            startTime = System.currentTimeMillis();
            System.out.print("MyCalendar My1 test" + i + " ");
            MyCalendarMy1 myCalendar = new MyCalendarMy1();
            for (int j = 0; j < bookList[i].length; j++) {
                int[] book = bookList[i][j];
                result = myCalendar.book(book[0], book[1]);
                System.out.print("book(" + book[0] + ", " + book[1] + ") " + result + ", ");
            }
            endTime = System.currentTimeMillis();
            System.out.println("during time " + (endTime - startTime));
        }

        for (int i = 0; i < bookList.length; i++) {
            startTime = System.currentTimeMillis();
            System.out.print("MyCalendar Answer1 test" + i + " ");
            MyCalendarAnswer1 myCalendar = new MyCalendarAnswer1();
            for (int j = 0; j < bookList[i].length; j++) {
                int[] book = bookList[i][j];
                result = myCalendar.book(book[0], book[1]);
                System.out.print("book(" + book[0] + ", " + book[1] + ") " + result + ", ");
            }
            endTime = System.currentTimeMillis();
            System.out.println("during time " + (endTime - startTime));
        }
    }
}
