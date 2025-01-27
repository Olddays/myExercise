package com.liu.LeetCode.Daily.Daily2020501;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC407_TrappingRainWaterII {

    private static int trapRainWaterAnswer1(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Add first and last column
        for (int i = 0; i < n; i++) {
            vis[i][0] = true;
            vis[i][m - 1] = true;
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][m - 1], i, m - 1});
        }

        // Add first and last row
        for (int i = 0; i < m; i++) {
            vis[0][i] = true;
            vis[n - 1][i] = true;
            pq.offer(new int[]{heightMap[0][i], 0, i});
            pq.offer(new int[]{heightMap[n - 1][i], n - 1, i});
        }

        int result = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], r = curr[1], c = curr[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    result += Math.max(0, h - heightMap[nr][nc]);
                    pq.offer(new int[]{Math.max(h, heightMap[nr][nc]), nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][][] heightMapList = new int[][][]{
                {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}},
                {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < heightMapList.length; i++) {
            startTime = System.currentTimeMillis();
            result = trapRainWaterAnswer1(heightMapList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("trapRainWater Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

    }
}
