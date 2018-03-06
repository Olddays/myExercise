package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT007_BinaryDate.getBinaryDateMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT007_BinaryDateTest {

    public static void main(String[] args) {
        int[] starts = new int[]{
                19641010
        };
        int[] ends = new int[]{
                20200724
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int num = 0; num < starts.length; num++) {
            int start = starts[num];
            int end = ends[num];
            startTime = System.currentTimeMillis();
            result = testMy1(start, end);
            endTime = System.currentTimeMillis();
            System.out.println("BinaryDate My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> testMy1(int startTime, int endTime) {
        return getBinaryDateMy1(startTime, endTime);
    }
}
