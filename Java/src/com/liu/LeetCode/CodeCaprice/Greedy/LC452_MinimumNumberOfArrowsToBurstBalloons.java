package com.liu.LeetCode.CodeCaprice.Greedy;

import java.util.*;

public class LC452_MinimumNumberOfArrowsToBurstBalloons {

    // 核心是寻找重合点
    // Beats 42.34%
    private static int findMinArrowShotsMy1(int[][] points) {
        int length = points.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); // 这里要用结束点进行排序
        // 因为是从小到大，所以结束点才能确定边界，如果结束点比之后的某一个的开始点小才能确定不重合
        // 所以只需要比较结束点即可
        // 如果用开始点排序，就不能确保结束点和开始点的比较，核心还是先处理一个，再处理另一个，因为后续的遍历要针对开始点做，所以一开始要处理好结束点（即是对结束点排序）
        int count = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < length; i++) {
            if (points[i][0] > prevEnd) { // 不重合
                count++;
                prevEnd = points[i][1]; // 更新比较用的point
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][][] pointsList = new int[][][]{
                {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}},
                {{-2147483646, -2147483645}, {2147483646, 2147483647}},
                {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}},
                {{10, 16}, {2, 8}, {1, 6}, {7, 12}},
                {{1, 2}, {3, 4}, {5, 6}, {7, 8}},
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < pointsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findMinArrowShotsMy1(pointsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findMinArrowShots My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
