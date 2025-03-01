package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.*;

public class LC406_QueueReconstructionByHeight {

    // Beats 86.28%
    // 两个维度，那么就需要先确定一个维度再确定一个维度
    private static int[][] reconstructQueueMy1(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> { // 身高从大到小，k从小到大，身高优先
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        for (int[] person : people) {
            // 因为时从高到低排序的，那么按照k把数据插入的话，就可以确保前面有k个比自己高的人
            result.add(person[1], person); // 插入到k位置上
        }
        return result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][][] peopleList = new int[][][]{
                {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}},
                {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}},
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < peopleList.length; i++) {
            startTime = System.currentTimeMillis();
            result = reconstructQueueMy1(peopleList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("reconstructQueue My1 result" + i + " ");
            for (int[] vals : result) {
                for (int val : vals) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
