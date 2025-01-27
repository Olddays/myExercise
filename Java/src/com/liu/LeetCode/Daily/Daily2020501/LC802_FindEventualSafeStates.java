package com.liu.LeetCode.Daily.Daily2020501;

import java.util.*;

public class LC802_FindEventualSafeStates {

    private static List<Integer> eventualSafeNodesMy1(int[][] graph) {
        int length = graph.length;
        List<Integer> result = new ArrayList<>();
        boolean[] isTerminal = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (graph[i].length == 0) { // terminal nodes
                isTerminal[i] = true;
            }
        }
        for (int i = 0; i < length; i++) {
            boolean isSafeNode = true;
            for (int val : graph[i]) {
                if (!isTerminal[val]) {
                    isSafeNode = false;
                    break;
                }
            }
            if (isSafeNode) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> eventualSafeNodesAnswer1(int[][] graph) {
        int length = graph.length;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graphList = new ArrayList<>();
        boolean[] visited = new boolean[length];
        boolean[] hasCycle = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (graph[i].length == 0) {
                visited[i] = true;
                hasCycle[i] = false;
            }
            List<Integer> list = new ArrayList<>();
            for (int val : graph[i]) {
                list.add(val);
            }
            graphList.add(list);
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                depthFirstSearch(graphList, i, visited, hasCycle);
            }
        }
        for (int i = 0; i < hasCycle.length; i++) {
            if (!hasCycle[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean depthFirstSearch(List<List<Integer>> graph, int preCheckNode, boolean[] visited, boolean[] hasCycle) {
        visited[preCheckNode] = true;
        hasCycle[preCheckNode] = true;
        for (int i : graph.get(preCheckNode)) {
            if (!visited[i] && depthFirstSearch(graph, i, visited, hasCycle)) {
                return true;
            } else if (hasCycle[i]) {
                return true;
            }
        }
        hasCycle[preCheckNode] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][][] graphList = new int[][][]{
                {{}, {0, 2, 3, 4}, {3}, {4}, {}},
                {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}},
                {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}},
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < graphList.length; i++) {
            startTime = System.currentTimeMillis();
            result = eventualSafeNodesMy1(graphList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("eventualSafeNodes My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < graphList.length; i++) {
            startTime = System.currentTimeMillis();
            result = eventualSafeNodesAnswer1(graphList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("eventualSafeNodes Answer1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
