package com.liu.IntroductionToAlgorithmicCompetition.test;

import java.util.List;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC202_Daffodil.getDaffodilMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC202_DaffodilTest {

    public static void main(String[] args) {
        List<Integer> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("Daffodil My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> testMy1() {
        return getDaffodilMy1();
    }

}
