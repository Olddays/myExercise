package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC1976_NumberOfWaysToArriveAtDestination {

    // 题目是两个部分，一个是找到最小值，一个是有多少个不同的最小值
    // 最小值可以用dijkstra算法，找最小值可以用dp来记录
    // 找最小值的过程中，记录最小值的个数，dp数组表示到达这个点的最小值的路径之和
    // Beats 20.44%
    private static int countPathsAnswer1(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int time = road[2];
            graph.get(start).add(new int[]{end, time});
            graph.get(end).add(new int[]{start, time});
        }

        long[] dist = new long[n];
        int[] dp = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE); // 求最小值，所以给个最大值作为默认值
        dist[0] = 0; // 到达0的时间为0
        dp[0] = 1; // 到0的路径为1

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0])); // 按照时间排序;
        pq.offer(new long[]{0, 0}); // 0是时间，0是节点

        int MOD = 1000000007; // 题目要求取模

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];
            if (currTime > dist[currNode]) {
                continue; // 已经有更短的路径，跳过
            }
            for (int[] neighbor : graph.get(currNode)) { // 遍历当前节点的邻居节点
                int nextNode = neighbor[0];
                int nextTime = neighbor[1];
                if (dist[currNode] + nextTime < dist[nextNode]) { // 找到更短的路径
                    dist[nextNode] = dist[currNode] + nextTime;
                    dp[nextNode] = dp[currNode];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if (dist[currNode] + nextTime == dist[nextNode]) { // 时间一样，路径数相加
                    dp[nextNode] = (dp[currNode] + dp[nextNode]) % MOD;
                }
            }
        }

        return dp[n - 1];
    }

    // 使用visited来减少一层group数组，并且将List改为数组，所以提升到Beats 100%
    private static int countPathsAnswer2(int n, int[][] roads) {
        long inf = Long.MAX_VALUE / 2;
        int mod = 1_000_000_007;
        long[][] graph = new long[n][n]; // 从i点到j点的时间
        long[] dist = new long[n]; // 从0到i点的最短时间
        long[] count = new long[n]; // 从0到i点的最短时间的路径数
        boolean[] visited = new boolean[n]; // 是否已遍历

        for (int i = 0; i < n; i++) {
            // 从i到i的时间改为最大值，避免自己到自己的路径默认值0影响到最小值的判断，因为此处的graph里面放的是从i点到j点的时间
            Arrays.fill(graph[i], inf);
        }
        Arrays.fill(dist, inf);

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            int time = road[2];
            graph[start][end] = time;
            graph[end][start] = time;
        }

        graph[0][0] = 0;
        dist[0] = 0;
        count[0] = 1;
        for (int i = 0; i < n; i++) {
            int cur = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (cur == -1 || dist[j] < dist[cur])) {
                    cur = j;
                }
            }
            visited[cur] = true;
            for (int j = 0; j < n; j++) {
                if (j == cur) {
                    continue;
                }

                long newDist = dist[cur] + graph[cur][j];
                if (dist[j] > newDist) {
                    dist[j] = newDist;
                    count[j] = count[cur];
                } else if (dist[j] == newDist) {
                    count[j] += count[cur];
                    count[j] %= mod;
                }
            }
        }
        return (int) count[n - 1];
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                7,
                2,
        };
        int[][][] roadsList = new int[][][]{
                {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}},
                {{1, 0, 10}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPathsAnswer1(nList[i], roadsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPaths Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countPathsAnswer2(nList[i], roadsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countPaths Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
