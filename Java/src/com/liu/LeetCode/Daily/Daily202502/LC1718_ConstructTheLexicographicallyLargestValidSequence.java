package com.liu.LeetCode.Daily.Daily202502;

public class LC1718_ConstructTheLexicographicallyLargestValidSequence {

    // 因为要 lexicographically largest 字典序最大，所以第一位一定是放一个n
    // 所以第n个也是n
    // 然后从n-1开始尝试放入，每次放入需要判断是否符合要求
    // Beats 100.00%
    private static int[] constructDistancedSequenceMy1(int n) {
        int[] result = new int[2 * n - 1]; // 1个1，其他都2个
        boolean[] visited = new boolean[n]; // 记录某个数字是否已经被使用，如果是n那么就要减1，因为题目是1-n，如果使用n+1那visited[0]就一直是false
        backtrackMy1(result, visited, 0, n);
        return result;
    }

    private static boolean backtrackMy1(int[] result, boolean[] visited, int index, int n) {
        if (index == result.length) { // 已经越界
            return true;
        }
        if (result[index] != 0) {
            return backtrackMy1(result, visited, index + 1, n);
        } else { // 找字典序最大，所以从大到小
            for (int i = n; i >= 1; i--) {
                if (visited[i - 1]) { // visited是n个数据，所以要-1
                    continue;
                }
                visited[i - 1] = true;
                result[index] = i;
                if (i == 1) { // 因为只有一个1，且此时可以判断是不是已经找到答案要退出，所以特殊处理
                    if (backtrackMy1(result, visited, index + 1, n)) {
                        return true;
                    }
                } else if (index + i < result.length && result[index + i] == 0) {
                    result[index + i] = i;
                    if (backtrackMy1(result, visited, index + 1, n)) {
                        return true;
                    }
                    result[index + i] = 0; // 回溯，改回默认初始值
                }
                visited[i - 1] = false; // 回溯，改回默认初始值
                result[index] = 0; // 回溯，改回默认初始值
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                3,
                5,
                7,
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = constructDistancedSequenceMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("constructDistancedSequence My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
