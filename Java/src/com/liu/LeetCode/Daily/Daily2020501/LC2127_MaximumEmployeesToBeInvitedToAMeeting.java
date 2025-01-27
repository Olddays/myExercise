package com.liu.LeetCode.Daily.Daily2020501;

import java.util.*;

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

    private static int maximumInvitationsAnswer2(int[] favorite) {
        int length = favorite.length;
        int[] inDeg = new int[length];
        int[] chainLen = new int[length];
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();

        // Count how many people favor each employee
        for (int f : favorite) {
            inDeg[f]++;
        }

        // Start with employees no one favorites (chain starters)
        for (int i = 0; i < length; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }

        // Process chains to calculate max chain lengths
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            int v = favorite[u];
            chainLen[v] = Math.max(chainLen[v], chainLen[u] + 1);
            if (--inDeg[v] == 0) {
                queue.add(v);
            }
        }

        int maxCycle = 0, pairChains = 0;

        // Detect cycles and calculate results
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }

            int cycleLen = 0, current = i;
            // Measure cycle length
            while (!visited[current]) {
                visited[current] = true;
                current = favorite[current];
                cycleLen++;
            }

            if (cycleLen == 2) {// Mutual pair
                pairChains += 2 + chainLen[i] + chainLen[favorite[i]];
            } else {
                maxCycle = Math.max(maxCycle, cycleLen);
            }
        }

        return Math.max(maxCycle, pairChains);
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
            System.out.println("maximumInvitations Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < favoriteList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumInvitationsAnswer2(favoriteList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumInvitations Answer2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
