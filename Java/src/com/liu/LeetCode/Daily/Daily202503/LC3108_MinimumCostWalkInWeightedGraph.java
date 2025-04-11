package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;
import java.util.Map;

public class LC3108_MinimumCostWalkInWeightedGraph {
    // 因为cost的计算是路径的按位与，所以case2里面的从1到2，可以先从1到2（cost1）再从2到1（cost1&6=0），再从1到2（cost0&1），所以cost=0
    // 如果联通，那么按位与的边越多理论上数值越小，也就是对每一个在连通图里面的边，都与一下，然后取最小值
    // DFS的问题是你需要知道推出点，也就是递归的return条件，但是这个题目每条路可以走无数次，所以不满足DFS的条件，因为找不到一个return条件
    // 所以使用并查集（不相交集DSU），因为并查集的路径压缩可以保证，路径上的所有点的cost都可以被压缩到一起
    // 并查集的路径压缩可以保证，路径上的所有点的cost都可以被压缩到一起
    // Beats 52.35%
    static class DSU {
        int[] parent;
        int[] rank;
        int[] weights;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            weights = new int[n];
            // 131071的二进制是11111111111111111，也就是32位全1，且大于题目的最大值10^5
            Arrays.fill(weights, 131071);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) { // 确定所属的group，如果回溯上去的parent一致，那么group也一致
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y, int weight) {
            int xx = find(x);
            int yy = find(y);
            // 没搞懂这个rank到底是干啥的。。删掉也可以AC，需要查查相关的算法，应该会有解答
            // 一种解释：Rank用于表示有多少链接，也就是链接的元素越多rank越大，所以rank[xx]++表示xx增加了一个链接
            if (rank[xx] < rank[yy]) {
                parent[xx] = yy;
            } else {
                parent[yy] = xx;
            }
            if (rank[xx] == rank[yy]) {
                rank[xx]++;
            }
            int newWeight = weights[xx] & weights[yy] & weight;
            weights[xx] = newWeight;
            weights[yy] = newWeight;
        }

        public int minimumCostOfWalk(int x, int y) {
            if (x == y) {
                return 0;
            }
            int xx = find(x);
            int yy = find(y);
            if (xx != yy) { // 不连通
                return -1;
            }
            return weights[xx];
        }
    }

    private static int[] minimumCostAnswer1(int n, int[][] edges, int[][] query) {
        DSU uf = new DSU(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            result[i] = uf.minimumCostOfWalk(query[i][0], query[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                3,
                5,
        };
        int[][][] edgesList = new int[][][]{
                {{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}},
                {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}},
        };
        int[][][] queryList = new int[][][]{
                {{1, 2}},
                {{0, 3}, {3, 4}},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = minimumCostAnswer1(nList[i], edgesList[i], queryList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("minOperations Answer1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
