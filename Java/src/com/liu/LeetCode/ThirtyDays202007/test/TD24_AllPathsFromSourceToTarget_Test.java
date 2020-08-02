package com.liu.LeetCode.ThirtyDays202007.test;

import java.util.List;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD24_AllPathsFromSourceToTarget.allPathsSourceTarget;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD24_AllPathsFromSourceToTarget_Test {

    public static void main(String[] args) {
        int[][] graph;
        List<List<Integer>> result;
        long startTime;
        long endTime;

        graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        };
        startTime = System.currentTimeMillis();
        result = testMy1(graph);
        endTime = System.currentTimeMillis();
        System.out.println("TD24_AllPathsFromSourceToTarget My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        graph = new int[][]{
                {},
        };
        startTime = System.currentTimeMillis();
        result = testMy1(graph);
        endTime = System.currentTimeMillis();
        System.out.println("TD24_AllPathsFromSourceToTarget My 1 result size: " + result.size() + ", during time " + (endTime - startTime));
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<List<Integer>> testMy1(int[][] graph) {
        return allPathsSourceTarget(graph);
    }
}
