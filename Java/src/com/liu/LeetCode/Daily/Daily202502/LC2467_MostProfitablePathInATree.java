package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC2467_MostProfitablePathInATree {

    // Beats 40.17%
    private static int mostProfitablePathAnswer1(int[][] edges, int bob, int[] amount) {
        int length = amount.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int[] bobPath = new int[length];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> bobPathList = new ArrayList<>();

        fillBobPath(graph, bobPathList, bob, -1);
        for (int i = 0; i < bobPathList.size(); i++) {
            bobPath[bobPathList.get(i)] = i;
        }

        return getAliceMaxScore(graph, bobPath, amount, 0, 0, -1, 0);
    }

    private static boolean fillBobPath(Map<Integer, List<Integer>> graph, ArrayList<Integer> bobPathList, int bobNode, int parentNode) {
        if (bobNode == 0) {
            return true; // 到达根节点
        }
        for (int neighborNode : graph.get(bobNode)) {
            if (neighborNode != parentNode) {
                bobPathList.add(bobNode);
                if (fillBobPath(graph, bobPathList, neighborNode, bobNode)) {
                    return true;
                }
                bobPathList.remove(bobPathList.size() - 1);
            }
        }
        return false;
    }

    private static int getAliceMaxScore(Map<Integer, List<Integer>> graph, int[] bobPath, int[] amount, int timestamp, int nowNode, int parentNode, int currentScore) {
        if (bobPath[nowNode] == -1 || bobPath[nowNode] > timestamp) {
            currentScore += amount[nowNode];
        } else if (bobPath[nowNode] == timestamp) {
            currentScore += amount[nowNode] / 2;
        }
        if (graph.get(nowNode).size() == 1 && nowNode != 0) {
            return currentScore;
        }
        int maxScore = Integer.MIN_VALUE;
        for (int neighborNode : graph.get(nowNode)) {
            if (neighborNode != parentNode) {
                maxScore = Math.max(maxScore, getAliceMaxScore(graph, bobPath, amount, timestamp + 1, neighborNode, nowNode, currentScore));
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[][][] edgesList = new int[][][]{
                {{0, 1}, {1, 2}, {1, 3}, {3, 4}},
                {{0, 1}},
        };
        int[] bobList = new int[]{
                3,
                1,
        };
        int[][] amountList = new int[][]{
                {-2, 4, 2, -4, 6},
                {-7280, 2350},
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < edgesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = mostProfitablePathAnswer1(edgesList[i], bobList[i], amountList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("mostProfitablePath Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
