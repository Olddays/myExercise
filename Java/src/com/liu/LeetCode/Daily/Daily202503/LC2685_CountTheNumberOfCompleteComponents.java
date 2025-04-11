package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2685_CountTheNumberOfCompleteComponents {

    // DSU
    // Beats 90.92%
    static class DSU {
        private int[] parent;
        private int[] rank;
        private int[] count; // 用count记录每个点的链接数量，如果在一个组里面，有人的连接数量不相等，那么就不是一个完全图

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            count[rootX] += count[rootY]; // 计算的就是组合内的联通数量
            count[rootY] = count[rootX];
            // 一种解释：Rank用于表示有多少链接，也就是链接的元素越多rank越大，所以rank[xx]++表示xx增加了一个链接
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
            if (rank[rootX] == rank[rootY]) {
                rank[rootX]++;
            }
        }

        public int count(int x) {
            return count[find(x)];
        }
    }

    private static int countCompleteComponentsMy1(int n, int[][] edges) {
        int[] counter = new int[n];
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
            counter[edge[0]]++;
            counter[edge[1]]++;
        }
        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groups.add(dsu.find(i));
        }
        for (int i = 0; i < n; i++) {
            if (dsu.count(i) != counter[i] + 1) {
                groups.remove(dsu.find(i));
            }
        }
        return groups.size();
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                3,
                4,
                5,
                5,
                6,
                6,
        };
        int[][][] edgesList = new int[][][]{
                {{1, 0}, {2, 0}, {2, 1}},
                {{2, 0}, {3, 1}, {3, 2}},
                {{1, 2}, {3, 4}, {1, 4}, {2, 3}},
                {{1, 2}, {3, 4}, {1, 4}, {2, 3}, {1, 3}, {2, 4}},
                {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}},
                {{0, 1}, {0, 2}, {1, 2}, {3, 4}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countCompleteComponentsMy1(nList[i], edgesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countCompleteComponents Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
