package com.liu.LeetCode.CodeCaprice.Array;

public class LC027_RemoveElement {
    // 重点是数组的删除元素操作，是需要将后续的内容前移的
    // 因为数组的内存是连续的
    // 比较好的解决方法是双指针（快慢指针），用快指针更新慢指针

    private static int removeElementMy1(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int fast = i + 1;
                while (fast < nums.length) {
                    if (nums[fast] != val) {
                        nums[i] = nums[fast];
                        i++;
                    }
                    fast++;
                }
                return i;
            }
        }
        return nums.length;
    }

    // 更规范的快慢指针写法
    private static int removeElementMy2(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[][] numsList = new int[][]{
                {3, 2, 2, 3},
                {0, 1, 2, 2, 3, 0, 4, 2},
                {2},
        };
        int[] valList = new int[]{
                3,
                2,
                3,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeElementMy1(numsList[i], valList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeElement My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        numsList = new int[][]{
                {3, 2, 2, 3},
                {0, 1, 2, 2, 3, 0, 4, 2},
                {2},
        };
        for (int i = 0; i < numsList.length; i++) {
            startTime = System.currentTimeMillis();
            result = removeElementMy2(numsList[i], valList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("removeElement My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
