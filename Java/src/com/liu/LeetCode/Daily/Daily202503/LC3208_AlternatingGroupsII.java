package com.liu.LeetCode.Daily.Daily202503;

public class LC3208_AlternatingGroupsII {

    // 移动窗口
    // Time Limit Exceeded
    private static int numberOfAlternatingGroupsMyError1(int[] colors, int k) {
        int length = colors.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int right = (i + k - 1) % length;
            boolean isAlternating = true;
            if (i < right) {
                for (int j = i; j < right; j++) {
                    if (colors[j] == colors[j + 1]) {
                        isAlternating = false;
                        break;
                    }
                }
            } else {
                for (int j = i; j < length - 1; j++) {
                    if (colors[j] == colors[j + 1]) {
                        isAlternating = false;
                        break;
                    }
                }
                if (isAlternating) {
                    int pre = colors[length - 1];
                    for (int j = 0; j <= right; j++) {
                        if (pre == colors[j]) {
                            isAlternating = false;
                            break;
                        }
                        pre = colors[j];
                    }
                }
            }
            if (isAlternating) {
                count++;
            }
        }
        return count;
    }

    // 优化滑动窗口
    // Beats 98.04%
    private static int numberOfAlternatingGroupsMy1(int[] colors, int k) {
        int n = colors.length;
        int[] temp = new int[n + k - 1]; // 解决循环问题
        System.arraycopy(colors, 0, temp, 0, n);
        System.arraycopy(colors, 0, temp, n, k - 1);

        int count = 0;
        int left = 0;

        for (int right = 0; right < temp.length; right++) {
            if (right > 0 && temp[right] == temp[right - 1]) {
                left = right; // 连续往前走
            }

            if (right - left + 1 >= k) { // 一直不连续超过了k就计数
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] colorsList = new int[][]{
                {0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1},
        };
        int[] kList = new int[]{
                3,
                6,
                4,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < colorsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numberOfAlternatingGroupsMy1(colorsList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numberOfAlternatingGroups My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
