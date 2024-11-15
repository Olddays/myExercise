package com.liu.LeetCode.FifteenPatterns.DepthFirstSearch;

import java.util.*;

public class LC210_CourseScheduleII {
    private static int[] findOrderAnswer1(int numCourses, int[][] prerequisites) {
        int[] sortedOrder = new int[numCourses];
        int index = 0;
        // if n is smaller than or equal to zero we will return the empty array
        if (numCourses <= 0) {
            return new int[0];
        }
        // Store the count of incoming prerequisites in a hashmap
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        // a. Initialize the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. Build the graph
        for (int[] prerequisite : prerequisites) {
            int parent = prerequisite[1];
            int child = prerequisite[0];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all n with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        // traverse in inDegree using key
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of
        // its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            // pop an element from the start of the sources and store
            // the element in vertex
            int vertex = sources.poll();
            // append the vertex at the end of the sorted_order
            sortedOrder[index++] = vertex;
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            // traverse in graph[vertex] using child
            // get the node's children to decrement
            // their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                // if inDegree[child] is 0 append the child in the deque sources
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (index != numCourses) { // topological sort is not possible as the graph has a cycle
            return new int[0];
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        int[] numCoursesSet = new int[]{
                2,
                4,
                1,
        };
        int[][][] prerequisitesSet = new int[][][]{
                {{1, 0}},
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < numCoursesSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = findOrderAnswer1(numCoursesSet[i], prerequisitesSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("pathSum My1 result" + i + " ");
            for (int num : result) {
                System.out.print(num + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
