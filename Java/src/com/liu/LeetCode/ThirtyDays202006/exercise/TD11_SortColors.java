package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/11.
 */
public class TD11_SortColors {
    public static void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int num : nums) {
            if (num == 0) {
                colorCount[0]++;
            } else if (num == 1) {
                colorCount[1]++;
            } else if (num == 2) {
                colorCount[2]++;
            }
        }
        int num = 0;
        for (int i = 0; i < colorCount.length; i++) {
            for (int j = 0; j < colorCount[i]; j++) {
                nums[num++] = i;
            }
        }
    }
}
