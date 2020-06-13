package com.liu.LeetCode.SeasonMatch20200418.exercise;

import java.util.ArrayList;
import java.util.List;

public class SM04_SmallestJumpTimes {
    public static int minJumpMy1(int[] jump) {
        int result = 0;
        int length = jump.length;
        if (length == 0) {
            return result;
        }
        int max = 0;
        int local = 0;

        while (local < length) {
            int step = jump[local];
            if (local + step > length) {
                result += 1;
                local += step;
            } else {
                for (int i = 1; i < step; i++) {
                    max = Math.max(max, jump[i]);
                }
                int next = jump[step];
                if (max > next) {
                    result += 2;
                    local += max;
                } else {
                    result += 1;
                    local += step;
                }
            }
            max = 0;
        }
        return result;
    }

    public static int minJumpMy2(int[] jump) {
        int length = jump.length;
        if (length == 0) {
            return 0;
        }
        List<Integer> stepRecord = new ArrayList<>();
        checkNextStep(jump, length, 0, 0, stepRecord);
        int min = length;
        for (int i : stepRecord) {
            min = Math.min(i, min);
        }
        return min;
    }

    private static void checkNextStep(int[] jump, int length, int local, int result, List<Integer> stepRecord) {
        if (local < length) {
            int step = jump[local];
            int max = 0;
            for (int i = 1; i < step; i++) {
                max = Math.max(max, jump[i]);
            }
            int next = jump[step];
            if (max > next) {
                checkNextStep(jump, length, local + max, result + 2, stepRecord);
            } else {
                checkNextStep(jump, length, local + step, result + 1, stepRecord);
            }
        } else {
            stepRecord.add(result);
        }
    }

    private static void checkNextStep2(int[] jump, int length, int local, int result, List<Integer> stepRecord) {
        if (local < length) {
            int step = jump[local];
            checkNextStep2(jump, length, local + step, result + 1, stepRecord);
            for (int i = local + 1; i < local + step; i++) {
                checkNextStep2(jump, length, i, result + 2, stepRecord);
            }
        } else {
            stepRecord.add(result);
        }
    }
}
