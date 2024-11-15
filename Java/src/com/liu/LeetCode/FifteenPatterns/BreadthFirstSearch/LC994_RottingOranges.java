package com.liu.LeetCode.FifteenPatterns.BreadthFirstSearch;

import java.util.*;

public class LC994_RottingOranges {

    private static int orangesRottingMy1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 先找到初始所有的腐烂位置
        boolean hasOrange = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (!hasOrange && grid[i][j] == 1) {
                    hasOrange = true;
                }
            }
        }
        if (queue.isEmpty()) {
            if (hasOrange) {
                return -1;
            }
            return 0;
        }
        int count = 0;
        // 然后进行扩散
        // 通过queue的while，找到临近的未腐烂的橘子
        boolean hasRotten = false;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            if (x > 0 && grid[x - 1][y] == 1) { // 上
                grid[x - 1][y] = 2;
                queue.add(new int[]{x - 1, y});
                hasRotten = true;
            }
            if (x < row - 1 && grid[x + 1][y] == 1) { // 下
                grid[x + 1][y] = 2;
                queue.add(new int[]{x + 1, y});
                hasRotten = true;
            }
            if (y > 0 && grid[x][y - 1] == 1) { // 左
                grid[x][y - 1] = 2;
                queue.add(new int[]{x, y - 1});
                hasRotten = true;
            }
            if (y < col - 1 && grid[x][y + 1] == 1) { // 右
                grid[x][y + 1] = 2;
                queue.add(new int[]{x, y + 1});
                hasRotten = true;
            }
            if (hasRotten) {
                hasRotten = false;
                count++;
                /// 这里有问题，不是每一个橘子+1，是每一组橘子+1
            }
        }
        // 最后判断一下，有没有没烂的
        for (int[] line : grid) {
            for (int orange : line) {
                if (orange == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private static int orangesRottingMy2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 先找到初始所有的腐烂位置
        int count = 0;
        boolean hasOrange = false; // 如果没有橘子，那就是0，如果只有普通橘子，那就是-1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    List<int[]> list = map.getOrDefault(count, new ArrayList<>());
                    list.add(new int[]{i, j});
                    map.put(count, list);
                } else if (!hasOrange && grid[i][j] == 1) {
                    hasOrange = true;
                }
            }
        }
        if (map.isEmpty()) {
            if (hasOrange) {
                return -1;
            }
            return 0;
        }
        // 然后进行扩散
        // 通过queue的while，找到临近的未腐烂的橘子
        boolean hasRotten = false;
        while (!map.isEmpty()) {
            List<int[]> nodeSet = map.get(count);
            for (int[] node : nodeSet) {
                int x = node[0];
                int y = node[1];
                if (x > 0 && grid[x - 1][y] == 1) { // 上
                    grid[x - 1][y] = 2;
                    List<int[]> list = map.getOrDefault(count + 1, new ArrayList<>());
                    list.add(new int[]{x - 1, y});
                    map.put(count + 1, list);
                    hasRotten = true;
                }
                if (x < row - 1 && grid[x + 1][y] == 1) { // 下
                    grid[x + 1][y] = 2;
                    List<int[]> list = map.getOrDefault(count + 1, new ArrayList<>());
                    list.add(new int[]{x + 1, y});
                    map.put(count + 1, list);
                    hasRotten = true;
                }
                if (y > 0 && grid[x][y - 1] == 1) { // 左
                    grid[x][y - 1] = 2;
                    List<int[]> list = map.getOrDefault(count + 1, new ArrayList<>());
                    list.add(new int[]{x, y - 1});
                    map.put(count + 1, list);
                    hasRotten = true;
                }
                if (y < col - 1 && grid[x][y + 1] == 1) { // 右
                    grid[x][y + 1] = 2;
                    List<int[]> list = map.getOrDefault(count + 1, new ArrayList<>());
                    list.add(new int[]{x, y + 1});
                    map.put(count + 1, list);
                    hasRotten = true;
                }
            }
            map.remove(count);
            if (hasRotten) {
                count++;
                hasRotten = false;
            }
        }
        // 最后判断一下，有没有没烂的
        for (int[] line : grid) {
            for (int orange : line) {
                if (orange == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    // 使用一个四向数组来替代四个判断，但是会变慢
    private static int orangesRottingMy3(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        // 先找到初始所有的腐烂位置
        int count = 0;
        boolean hasOrange = false; // 如果没有橘子，那就是0，如果只有普通橘子，那就是-1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    List<int[]> list = map.getOrDefault(count, new ArrayList<>());
                    list.add(new int[]{i, j});
                    map.put(count, list);
                } else if (!hasOrange && grid[i][j] == 1) {
                    hasOrange = true;
                }
            }
        }
        if (map.isEmpty()) {
            if (hasOrange) {
                return -1;
            }
            return 0;
        }
        // 然后进行扩散
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 通过queue的while，找到临近的未腐烂的橘子
        boolean hasRotten = false;
        while (!map.isEmpty()) {
            List<int[]> nodeSet = map.get(count);
            for (int[] node : nodeSet) {
                int x = node[0];
                int y = node[1];
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX >= 0 && newX <= row - 1 && newY >= 0 && newY <= col - 1 && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        List<int[]> list = map.getOrDefault(count + 1, new ArrayList<>());
                        list.add(new int[]{newX, newY});
                        map.put(count + 1, list);
                        hasRotten = true;
                    }
                }
            }
            map.remove(count);
            if (hasRotten) {
                count++;
                hasRotten = false;
            }
        }
        // 最后判断一下，有没有没烂的
        for (int[] line : grid) {
            for (int orange : line) {
                if (orange == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][][] gridSet = new int[][][]{
                {{0}},
                {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}},
                {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}},
                {{0, 2}},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = orangesRottingMy1(gridSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("orangesRotting My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
        gridSet = new int[][][]{
                {{0}},
                {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}},
                {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}},
                {{0, 2}},
        };
        for (int i = 0; i < gridSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = orangesRottingMy2(gridSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("orangesRotting My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
        gridSet = new int[][][]{
                {{0}},
                {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}},
                {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}},
                {{0, 2}},
        };
        for (int i = 0; i < gridSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = orangesRottingMy3(gridSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("orangesRotting My3 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
