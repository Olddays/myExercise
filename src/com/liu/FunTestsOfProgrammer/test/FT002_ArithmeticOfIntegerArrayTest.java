package com.liu.FunTestsOfProgrammer.test;


import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT002_ArithmeticOfIntegerArray.getArithmeticOfIntegerArrayAnswer1;
import static com.liu.FunTestsOfProgrammer.exercise.FT002_ArithmeticOfIntegerArray.getArithmeticOfIntegerArrayMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT002_ArithmeticOfIntegerArrayTest {

    public static void main(String[] args) {
        List<Integer> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("ArithmeticOfIntegerArray My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testAnswer1();
        endTime = System.currentTimeMillis();
        System.out.println("ArithmeticOfIntegerArray Answer 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1() {
        return getArithmeticOfIntegerArrayMy1();
    }

    private static List<Integer> testAnswer1() {
        return getArithmeticOfIntegerArrayAnswer1();
    }
}
