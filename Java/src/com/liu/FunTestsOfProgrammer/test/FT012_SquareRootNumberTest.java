package com.liu.FunTestsOfProgrammer.test;

import java.util.Map;

import static com.liu.FunTestsOfProgrammer.exercise.FT012_SquareRootNumber.getSquareRootNumberMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT012_SquareRootNumber.getSquareRootNumberMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT012_SquareRootNumberTest {

    public static void main(String[] args) {
        int[] maxNums = new int[]{
                10, 150
        };
        Map<Integer, Integer> result;
        long startTime;
        long endTime;

        for (int maxNum : maxNums) {
            startTime = System.currentTimeMillis();
            result = testMy1(maxNum);
            endTime = System.currentTimeMillis();
            System.out.println("SquareRootNumber My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (Map.Entry entry : result.entrySet()) {
                System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testMy2(maxNum);
            endTime = System.currentTimeMillis();
            System.out.println("SquareRootNumber My 2 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (Map.Entry entry : result.entrySet()) {
                System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
            }
            System.out.println();
        }
    }

    private static Map<Integer, Integer> testMy1(int maxNum) {
        return getSquareRootNumberMy1(maxNum);
    }

    private static Map<Integer, Integer> testMy2(int maxNum) {
        return getSquareRootNumberMy2(maxNum);
    }
}
