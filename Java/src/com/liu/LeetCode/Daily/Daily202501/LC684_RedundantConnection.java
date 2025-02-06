package com.liu.LeetCode.Daily.Daily202501;

public class LC684_RedundantConnection {

    private static int[] findRedundantConnectionAnswer1(int[][] edges) {
        int[] par = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            if (unionFind(par, edge[0]) == unionFind(par, edge[1])) {
                return edge;
            } else {
                par[unionFind(par, edge[1])] = unionFind(par, edge[0]);
            }
        }
        return edges[0];
    }

    private static int unionFind(int[] par, int x) {
        if (x != par[x]) {
            par[x] = unionFind(par, par[x]);
        }
        return par[x];
    }

    public static void main(String[] args) {
        int[][][] edgesList = new int[][][]{
                {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}},
                {{1, 2}, {1, 3}, {2, 3}},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < edgesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = findRedundantConnectionAnswer1(edgesList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("findRedundantConnection Answer1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

    }
}
