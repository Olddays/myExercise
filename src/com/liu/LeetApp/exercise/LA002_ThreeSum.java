package com.liu.LeetApp.exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by baidu on 2016/11/27.
 */
public class LA002_ThreeSum {

    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero

    // Elements in a triplet (a, b, c) must be in non-descending order. (ie, a <= b <= c)
    // The solution set must not contain duplicate triplets.

    // Difficulty: Medium

    // Error 忘记关注sumCache等于0时候的left和right的变化导致死循环
    public static ArrayList<ArrayList<Integer>> getThreeSumMy1(int[] input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < input.length - 2; i++) {
            int left = i + 1;
            int right = input.length - 1;
            while (left < right && right < input.length) {
                int sumCache = input[i] + input[left] + input[right];
                if (sumCache == 0) {
                    ArrayList<Integer> cacheList = new ArrayList<>();
                    cacheList.add(input[i]);
                    cacheList.add(input[left]);
                    cacheList.add(input[right]);
                    result.add(cacheList);
                } else if (sumCache < 0) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        return result;
    }

    // Error 当sumCache大于0的时候right自加导致除了第一次以外的每次循环都会自加然后right等于input的length,引起后续数据无法判断
    public static ArrayList<ArrayList<Integer>> getThreeSumMy2(int[] input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < input.length - 2; i++) {
            int left = i + 1;
            int right = input.length - 1;
            while (left < right && right < input.length) {
                int sumCache = input[i] + input[left] + input[right];
                if (sumCache == 0) {
                    ArrayList<Integer> cacheList = new ArrayList<>();
                    cacheList.add(input[i]);
                    cacheList.add(input[left]);
                    cacheList.add(input[right]);
                    result.add(cacheList);
                    left++;
                    right++;
                } else if (sumCache < 0) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        return result;
    }

    // Error 没有进行去重和首次输入数据的验证
    public static ArrayList<ArrayList<Integer>> getThreeSumMy3(int[] input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 1; i < input.length - 1; i++) {
            int left = i - 1;
            int right = input.length - 1;
            while (left < right && right < input.length && left >= 0) {
                int sumCache = input[i] + input[left] + input[right];
                if (sumCache == 0) {
                    ArrayList<Integer> cacheList = new ArrayList<>();
                    cacheList.add(input[left]);
                    cacheList.add(input[i]);
                    cacheList.add(input[right]);
                    result.add(cacheList);
                    left++;
                    right--;
                } else if (sumCache < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> getThreeSumAnswer(int[] input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (input == null || input.length < 3) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (i != 0 && input[i] == input[i - 1]) {
                continue; // to skip duplicate number; e.g [0, 0, 0, 0]
            }
            int left = i + 1;
            int right = input.length - 1;
            while (left < right) {
                int sumCache = input[left] + input[right] + input[i];
                if (sumCache == 0) {
                    ArrayList<Integer> cacheList = new ArrayList<>();
                    cacheList.add(input[i]);
                    cacheList.add(input[left]);
                    cacheList.add(input[right]);
                    result.add(cacheList);
                    left++;
                    right--;
                    while (left < right && input[left] == input[left - 1]) {
                        left++; // to skip duplicate
                    }
                    while (left < right && input[right] == input[right + 1]) {
                        right--; // to skip duplicate
                    }
                } else if (sumCache < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}
