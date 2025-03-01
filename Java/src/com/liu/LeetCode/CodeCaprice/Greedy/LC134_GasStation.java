package com.liu.LeetCode.CodeCaprice.Greedy;

public class LC134_GasStation {

    // Greedy
    // 尽可能从cost最大或gas最大的点开始
    // error，无法处理{5, 8, 2, 8},{6, 5, 6, 6}的情况
    private static int canCompleteCircuitMy1(int[] gas, int[] cost) {
        int length = gas.length;
        int gasSum = 0;
        int costSum = 0;
        int maxGas = 0;
        int maxGasIdx = 0;
        int maxCost = 0;
        int maxCostIdx = 0;
        for (int i = 0; i < length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            if (gas[i] > maxGas) {
                maxGas = gas[i];
                maxGasIdx = i;
            }
            if (cost[i] > maxCost) {
                maxCost = cost[i];
                maxCostIdx = i;
            }
        }
        if (gasSum < costSum) { // 构不成一个圈
            return -1;
        }
        if (maxGas > maxCost) { // 最大的gas点
            return maxGasIdx;
        }
        return (maxCostIdx + 1) % length; // 最大的cost点的下一个点
    }

    // Beats 97.55%
    // Greedy，核心是要找到最关心的变化值，也就是余量
    private static int canCompleteCircuitMy2(int[] gas, int[] cost) {
        int length = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) { // 构不成一个圈
            return -1;
        }
        int result = 0;
        int left = 0;
        for (int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            if (left < 0) {
                left = 0;
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] gasList = new int[][]{
                {3, 1, 1},
                {5, 8, 2, 8},
                {1, 2, 3, 4, 5},
                {2, 3, 4},
        };
        int[][] costList = new int[][]{
                {1, 2, 2},
                {6, 5, 6, 6},
                {3, 4, 5, 1, 2},
                {3, 4, 3},
        };
        long startTime;
        int result;
        long endTime;

        for (int i = 0; i < gasList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canCompleteCircuitMy1(gasList[i], costList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canCompleteCircuit My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < gasList.length; i++) {
            startTime = System.currentTimeMillis();
            result = canCompleteCircuitMy2(gasList[i], costList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canCompleteCircuit My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
