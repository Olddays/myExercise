package com.liu.LeetCode.ThirtyDays202006.test;


import static com.liu.LeetCode.ThirtyDays202006.exercise.TD06_QueueReconstructionByHeight.reconstructQueueMy1;
import static com.liu.LeetCode.ThirtyDays202006.exercise.TD06_QueueReconstructionByHeight.reconstructQueueAnswer1;

/**
 * Created by Liu on 2020/6/7.
 */
public class TD06_QueueReconstructionByHeight_Test {
    public static void main(String[] args) {
        int[][] people;
        int[][] result;
        long startTime;
        long endTime;

        people = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(people);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_QueueReconstructionByHeight My 1 result " + result + " during time " + (endTime - startTime));
        for (int[] c : result) {
            System.out.println(c[0] + " " + c[1]);
        }
        System.out.println();

        startTime = System.currentTimeMillis();
        result = testMAnswer(people);
        endTime = System.currentTimeMillis();
        System.out.println("TD06_QueueReconstructionByHeight Answer 1 result " + result + " during time " + (endTime - startTime));
        for (int[] c : result) {
            System.out.println(c[0] + " " + c[1]);
        }
        System.out.println();
    }

    private static int[][] testMy1(int[][] people) {
        return reconstructQueueMy1(people);
    }

    private static int[][] testMAnswer(int[][] people) {
        return reconstructQueueAnswer1(people);
    }

}
