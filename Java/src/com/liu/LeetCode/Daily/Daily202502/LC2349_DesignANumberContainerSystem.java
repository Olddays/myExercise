package com.liu.LeetCode.Daily.Daily202502;


import java.util.*;

public class LC2349_DesignANumberContainerSystem {
    // Time Limit Exceeded
    private static class NumberContainersMy1 {
        private Map<Integer, Integer> container;
        private Map<Integer, List<Integer>> valueMap;

        public NumberContainersMy1() {
            container = new HashMap<>();
            valueMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (container.containsKey(index)) {
                int oldNumber = container.get(index);
                replaceValue(index, oldNumber, number);
            } else {
                List<Integer> list = valueMap.getOrDefault(number, new ArrayList<>());
                list.add(index);
                list.sort(Comparator.naturalOrder());
                valueMap.put(number, list);
            }
            container.put(index, number);
        }

        private void replaceValue(int index, int oldNumber, int number) {
            List<Integer> oldList = valueMap.get(oldNumber);
            oldList.remove(Integer.valueOf(index));
            if (oldList.isEmpty()) {
                valueMap.remove(oldNumber);
            }
            List<Integer> newList = valueMap.getOrDefault(number, new ArrayList<>());
            newList.add(index);
            newList.sort(Comparator.naturalOrder());
            valueMap.put(number, newList);
        }

        public int find(int number) {
            if (valueMap.containsKey(number)) {
                return valueMap.get(number).get(0);
            }
            return -1;
        }
    }

    // 改用HashMap和minHeap，降低时间复杂度，整体思路是一样的
    private static class NumberContainersMy2 {
        private Map<Integer, Integer> container;
        private Map<Integer, Queue<Integer>> valueMap;

        public NumberContainersMy2() {
            container = new HashMap<>();
            valueMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (container.containsKey(index)) {
                int oldNumber = container.get(index);
                if (oldNumber == number) {
                    return;
                }
                valueMap.get(oldNumber).remove(index);
            }
            // Beats 84.25%
            // Queue<Integer> queue = valueMap.getOrDefault(number, new PriorityQueue<>());
            // queue.offer(index);
            // valueMap.put(number, queue);
            // Beats 96.58%
            valueMap.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
            // computeIfAbsent方法要比put快
            container.put(index, number);
        }

        public int find(int number) {
            if (valueMap.containsKey(number)) {
                if (!valueMap.get(number).isEmpty()) {
                    return valueMap.get(number).peek();
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] functionList = new int[][]{
                {1, 2, 1, 2, 2, 2},
                {2, 1, 1, 1, 1, 2, 1, 2},
        };
        int[][][] argList = new int[][][]{
                {{1, 10}, {10}, {1, 20}, {10}, {20}, {30}},
                {{10}, {2, 10}, {1, 10}, {3, 10}, {5, 10}, {10}, {1, 20}, {10}},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < functionList.length; i++) {
            startTime = System.currentTimeMillis();
            System.out.print("MyCalendar My1 test" + i + " ");
            NumberContainersMy1 numberContainers = new NumberContainersMy1();
            for (int j = 0; j < functionList[i].length; j++) {
                int function = functionList[i][j];
                if (function == 1) {
                    numberContainers.change(argList[i][j][0], argList[i][j][1]);
                } else if (function == 2) {
                    result = numberContainers.find(argList[i][j][0]);
                    System.out.print("find " + argList[i][j][0] + " " + result + ", ");
                }
            }
            endTime = System.currentTimeMillis();
            System.out.println("during time " + (endTime - startTime));
        }

        for (int i = 0; i < functionList.length; i++) {
            startTime = System.currentTimeMillis();
            System.out.print("MyCalendar My1 test" + i + " ");
            NumberContainersMy2 numberContainers = new NumberContainersMy2();
            for (int j = 0; j < functionList[i].length; j++) {
                int function = functionList[i][j];
                if (function == 1) {
                    numberContainers.change(argList[i][j][0], argList[i][j][1]);
                } else if (function == 2) {
                    result = numberContainers.find(argList[i][j][0]);
                    System.out.print("find " + argList[i][j][0] + " " + result + ", ");
                }
            }
            endTime = System.currentTimeMillis();
            System.out.println("during time " + (endTime - startTime));
        }
    }
}
