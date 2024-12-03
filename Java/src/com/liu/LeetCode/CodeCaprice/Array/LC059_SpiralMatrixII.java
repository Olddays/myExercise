package com.liu.LeetCode.CodeCaprice.Array;

public class LC059_SpiralMatrixII {

    // 关键就是四个角的边界处理
    // 要注意遵守循环不变量，要坚持一致的规则来处理每一条边
    // 此处使用左闭右开区间，每一条边遍历的时候，处理第一个节点，不处理最后一个
    // 最后一个节点作为下一个边的起点处理
    private static int[][] generateMatrixMy1(int n) {
        int[][] result = new int[n][n];
        int inputNum = 1;
        // 转n/2圈
        for (int round = 0; round < n / 2; round++) {
            int x = round;
            int y = round;
            // 上
            for (int j = y; j < n - 1 - round; j++) {
                result[x][j] = inputNum;
                inputNum++;
                y = j;
            }
            y++;
            // 右
            for (int i = x; i < n - 1 - round; i++) {
                result[i][y] = inputNum;
                inputNum++;
                x = i;
            }
            x++;
            // 下
            for (int j = y; j > round; j--) {
                result[x][j] = inputNum;
                inputNum++;
                y = j;
            }
            y--;
            // 左
            for (int i = x; i > round; i--) {
                result[i][y] = inputNum;
                inputNum++;
            }
        }
        // 如果n时奇数，最中间的节点还需要处理一下
        if (n % 2 == 1) {
            result[n / 2][n / 2] = inputNum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                4,
                3,
                2,
                1,
        };
        int[][] result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = generateMatrixMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("generateMatrix My1 result" + i + " ");
            for (int[] line : result) {
                for (int num : line) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
