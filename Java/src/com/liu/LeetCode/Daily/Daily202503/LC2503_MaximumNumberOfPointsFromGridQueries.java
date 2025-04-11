package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2503_MaximumNumberOfPointsFromGridQueries {

    // Time Limit Exceeded
    private static int[] maxPointsMyError1(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int length = queries.length;
        int[] result = new int[length];
        int[][] directions = new int[][]{
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] cache = queue.poll();
                int i = cache[0];
                int j = cache[1];
                if (grid[i][j] < query) {
                    result[k]++;
                    for (int[] direction : directions) {
                        int[] next = new int[]{i + direction[0], j + direction[1]};
                        if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && !visited[next[0]][next[1]]) {
                            visited[next[0]][next[1]] = true;
                            queue.offer(next);
                        }
                    }
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return result;
    }

    // 优化方法是，将queries排序，然后从最小的开始遍历，这样可以避免重复遍历，并且用一个map来记录原本的位置
    private static int[] maxPointsMy1(int[][] grid, int[] queries) {
        int cols = grid.length;
        int rows = grid[0].length;
        int n = queries.length;
        List<int[]> sortedQueries = new ArrayList<>(); // 得用list，map无法处理value一样的情况
        for (int i = 0; i < n; i++) {
            sortedQueries.add(new int[]{queries[i], i});
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a[0]));
        int[] resultCache = new int[n];
        int[][] directions = new int[][]{
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        // 这里要用小顶堆，因为我们要从最小的开始遍历，这样可以避免无法遍历到合适的数据，因为我们是从最小的开始遍历的
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0}); // val，x，y
        boolean[][] visited = new boolean[cols][rows];
        visited[0][0] = true;
        int queryIndex = 0;
        int[] query = sortedQueries.get(queryIndex);
        while (!minHeap.isEmpty()) {
            int[] cache = minHeap.poll();
            int val = cache[0];
            int i = cache[1];
            int j = cache[2];
            while (query[0] <= val && queryIndex < n - 1) {
                int last = query[1];
                queryIndex++;
                query = sortedQueries.get(queryIndex);
                resultCache[query[1]] = resultCache[last];
            }
            if (query[0] <= val) {
                break; // 最后一个query
            }
            resultCache[query[1]]++;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x >= 0 && x < cols && y >= 0 && y < rows && !visited[x][y]) {
                    visited[x][y] = true;
                    minHeap.offer(new int[]{grid[x][y], x, y});
                }
            }
        }
        return resultCache;
    }

    // Beats 25.19%
    private static int[] maxPointsAnswer1(int[][] grid, int[] queries) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int n = queries.length;
        int[] result = new int[n];
        int[][] visited = new int[rows][cols];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> sortedQueries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sortedQueries.add(new int[]{queries[i], i});
        }
        sortedQueries.sort(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = 1;
        int points = 0;

        for (int[] q : sortedQueries) {
            int queryVal = q[0], queryIdx = q[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryVal) {
                int[] top = minHeap.poll();
                int row = top[1], col = top[2];
                points++;

                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = 1;
                    }
                }
            }
            result[queryIdx] = points;
        }
        return result;
    }

    // Directions for movement (down, up, right, left)
    public static final int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    // 96.95%
    private static int[] maxPointsAnswer2(int[][] grid, int[] queries) {
        int queryCount = queries.length;
        int[] result = new int[queryCount];
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int totalCells = rowCount * colCount;
        // Stores the minimum query value needed to reach `i` points.
        int[] thresholdForMaxPoints = new int[totalCells + 1];

        // `minValueToReach[i][j]` keeps track of the maximum value encountered
        // to reach cell (i, j), including itself.
        int[][] minValueToReach = new int[rowCount][colCount];

        // Initialize the minValueToReach array with a high value.
        for (int[] row : minValueToReach) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // Start from the top-left cell.
        minValueToReach[0][0] = grid[0][0]; //max encountered value along the path

        // Min-heap for processing cells in increasing order of their maximum
        // encountered value.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                Integer.compare(a[2], b[2])
        );
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        int visitedCells = 0;

        // Dijkstra's algorithm to compute minValueToReach for each cell
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            // Store the value required to reach `visitedCells` points.
            thresholdForMaxPoints[++visitedCells] = current[2];
            // Explore all possible directions.
            for (int[] direction : DIRECTIONS) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];

                // Check if the new position is within bounds and not visited
                // before.
                if (
                        newRow >= 0 &&
                                newRow < rowCount &&
                                newCol >= 0 &&
                                newCol < colCount &&
                                minValueToReach[newRow][newCol] == Integer.MAX_VALUE
                ) {
                    // The max value encountered on the path to this cell.
                    minValueToReach[newRow][newCol] = Math.max(
                            current[2],
                            grid[newRow][newCol]
                    );

                    // Add the cell to the heap for further exploration.
                    minHeap.offer(
                            new int[]{
                                    newRow,
                                    newCol,
                                    minValueToReach[newRow][newCol],
                            }
                    );
                }
            }
        }

        // Use binary search to determine the maximum number of points that can
        // be collected for each query.
        for (int i = 0; i < queryCount; i++) {
            int threshold = queries[i];
            int left = 0, right = totalCells;

            // Find the rightmost number of points we can collect before
            // exceeding the query threshold.
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (thresholdForMaxPoints[mid] < threshold) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            // Return `left`.
            result[i] = left;
        }

        return result;
    }
    // tc= klogk +n.mlog(m.n)
    // The algorithm first sorts the k queries, which takes O(klogk) time. Then, for each query, it processes cells using a min-heap. In the worst case, all n⋅m cells are processed and pushed into the heap. Each heap operation (push or pop) takes O(log(n⋅m)) time. Therefore, processing all cells takes O(n⋅mlog(n⋅m)).
    // sc= n.m+ k
    // >>> is the unsigned right shift operator.
    // >>> 1 divides by 2, but avoids potential integer overflow.
    // Since left + right + 1 is always positive here, >>> 1 behaves identically to / 2 but is safer.
    //  int mid = (left + right + 1) >>> 1;
    // +1 ensures we round up when left + right is odd, avoiding infinite loops.
    // >>> 1 safely divides by 2, preventing signed integer overflow.
    //  This binary search is used for finding the largest index where the value is still less than threshold.
    // suppose grid as weighted graph use dikjastra to find minquery value to reach k cells or gain k points, but dikstra is slightly updated , we will use max encountered value in path for neighbours,

    public static void main(String[] args) {
        int[][][] gridList = new int[][][]{
                {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}},
                {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}},
                {{5, 2, 1}, {1, 1, 2}},
        };
        int[][] queriesList = new int[][]{
                {5, 6, 6},
                {5, 6, 2},
                {3},
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < gridList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maxPointsMy1(gridList[i], queriesList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("maxPoints My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
