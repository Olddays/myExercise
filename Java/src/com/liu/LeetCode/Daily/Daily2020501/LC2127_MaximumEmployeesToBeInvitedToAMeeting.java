package com.liu.LeetCode.Daily.Daily2020501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2127_MaximumEmployeesToBeInvitedToAMeeting {


    private static int maximumInvitationsAnswer1(int[] favorite) {
        int length = favorite.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = 0;

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == favorite[favorite[i]]) {
                if (i < favorite[i]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(favorite[i]);
                    pairs.add(pair);
                }
            } else {
                graph.get(favorite[i]).add(i);
            }
        }

        boolean[] visited = new boolean[length];
        for (List<Integer> pair : pairs) {
            answer += dfs(graph, pair.get(0), visited) + dfs(graph, pair.get(1), visited);
        }

        int[] counter = new int[length];
        int[] round = new int[length];

        int rnd = 1;

        int circleMax = 0;

        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            if (round[i] != 0) {
                continue;
            }

            int cnt = 1;
            int j = i;
            while (counter[j] == 0) {
                counter[j] = cnt;
                round[j] = rnd;
                j = favorite[j];
                cnt++;
            }
            if (round[j] == rnd) {
                circleMax = Math.max(circleMax, cnt - counter[j]);
            }
            rnd++;
        }
        return Math.max(circleMax, answer);
    }

    private static int dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        int max = 0;
        for (int neighbor : graph.get(node)) {
            max = Math.max(max, dfs(graph, neighbor, visited));
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[][] favoriteList = new int[][]{
                {2, 2, 1, 2},
                {1, 2, 0},
                {3, 0, 1, 4, 1},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < favoriteList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumInvitationsAnswer1(favoriteList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumInvitations My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
