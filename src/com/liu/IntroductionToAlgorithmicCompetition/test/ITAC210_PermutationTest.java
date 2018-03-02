package com.liu.IntroductionToAlgorithmicCompetition.test;

import java.util.List;

import static com.liu.IntroductionToAlgorithmicCompetition.exercise.ITAC210_Permutation.getPermutationMy1;

/**
 * Created by liu on 2016/11/27.
 */
public class ITAC210_PermutationTest {

    public static void main(String[] args) {
        long startTime;
        List<List<Integer>> result;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("Permutation My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> testMy1() {
        return getPermutationMy1();
    }

}
