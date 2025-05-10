package com.liu.LeetCode.Daily.Daily202505;

import java.util.*;

public class LC2071_MaximumNumberOfTasksYouCanAssign {

    private static int maxTaskAssignMy1(int[] tasks, int[] workers, int pills, int strength) {
        int left = 0, right = Math.min(tasks.length, workers.length);
        Arrays.sort(tasks);
        Arrays.sort(workers);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int usedPills = 0;
            TreeMap<Integer, Integer> avail = new TreeMap<>();
            for (int i = workers.length - mid; i < workers.length; ++i)
                avail.put(workers[i], avail.getOrDefault(workers[i], 0) + 1);

            boolean canAssign = true;
            for (int i = mid - 1; i >= 0; --i) {
                int t = tasks[i];
                int w = avail.lastKey();
                if (w >= t) {
                    decrement(avail, w);
                } else {
                    Integer key = avail.ceilingKey(t - strength);
                    if (key == null || ++usedPills > pills) {
                        canAssign = false;
                        break;
                    }
                    decrement(avail, key);
                }
            }

            if (canAssign)
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private static void decrement(TreeMap<Integer, Integer> m, int k) {
        int c = m.get(k);
        if (c == 1) m.remove(k);
        else m.put(k, c - 1);
    }

    public static void main(String[] args) {
        int[][] tasksList = new int[][]{
                {3, 2, 1},
                {5, 4},
        };
        int[][] workersList = new int[][]{
                {0, 3, 3},
                {0, 0, 0},
        };
        int[] pillsList = new int[]{
                1,
                1,
        };
        int[] strengthList = new int[]{
                1,
                5,
        };
        int[] resultList = new int[]{
                1,
                0,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < tasksList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxTaskAssignMy1(tasksList[i], workersList[i], pillsList[i], strengthList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maxTaskAssign My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
