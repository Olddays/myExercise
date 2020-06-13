package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liu on 2020/6/7.
 */
public class TD06_QueueReconstructionByHeight {

    public static int[][] reconstructQueueAnswer1(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }

    // TimeLimited
    public static int[][] reconstructQueueMy1(int[][] people) {
        int length = people.length;
        if (length == 0) {
            return people;
        }
        quickSort(people, 0, length - 1);
        int[][] result = new int[length][];
        for (int[] point : people) {
            int local = point[1];
            while (result[local] != null || !upperCheck(result, point, local)) {
                int[] cache = result[local];
                if (cache == null) {
                    local++;
                } else if (cache[0] < point[0]) {
                    local++;
                } else {
                    local--;
                }
            }
            result[local] = point;
        }
        return result;
    }

    private static boolean upperCheck(int[][] result, int[] point, int local) {
        int count = 0;
        for (int i = 0; i < local; i++) {
            if (result[i] == null || result[i][0] >= point[0]) {
                count++;
            }
        }
        return count == point[1];
    }

    private static void quickSort(int[][] people, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int[] temp = people[low];

        while (i < j) {
            while (temp[0] <= people[j][0] && i < j) {
                j--;
            }
            while (temp[0] >= people[i][0] && i < j) {
                i++;
            }
            if (i < j) {
                int[] cache = people[j];
                people[j] = people[i];
                people[i] = cache;
            }

        }
        people[low] = people[i];
        people[i] = temp;
        quickSort(people, low, j - 1);
        quickSort(people, j + 1, high);
    }
}
