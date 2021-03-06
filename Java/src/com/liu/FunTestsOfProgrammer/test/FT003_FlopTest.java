package com.liu.FunTestsOfProgrammer.test;


import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT003_Flop.getFlopMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT003_FlopTest {

    public static void main(String[] args) {
        List<Integer> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("Flop My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1() {
        return getFlopMy1();
    }
}
