package com.liu.LeetApp.exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by baidu on 2016/11/28.
 */
public class LA003_FourSum {

    // Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
    // Find all unique quadruplets in the array which gives the sum of target.

    // Elements in a triplet (a, b, c, d) must be in non-descending order. (ie, a <= b <= c <= d)
    // The solution set must not contain duplicate triplets.

    // Difficulty: Medium

    // Error 此处只能成功找到一组结果,由于first和third之间没有建立起联系,而只有second和third建立起了联系导致.
    public static ArrayList<ArrayList<Integer>> getFourSumMy1(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 1; i < input.length - 2; i++) {
            int first = i - 1;
            int second = i + 1;
            int third = input.length - 1;
            while (first < third) {
                while (second < third) {
                    int sumCache = input[i] + input[first] + input[second] + input[third];
                    if (sumCache == target) {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[first]);
                        cacheList.add(input[i]);
                        cacheList.add(input[second]);
                        cacheList.add(input[third]);
                        result.add(cacheList);
                        second++;
                        third--;
                    } else if (sumCache < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
                first++;
            }
        }
        return result;
    }

    // Error 没有做初试判断和去重
    public static ArrayList<ArrayList<Integer>> getFourSumMy2(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 1; i < input.length - 2; i++) {
            int first = i - 1;
            int third = input.length - 1;
            while (first < third) {
                int second = i + 1;
                while (second < third) {
                    int sumCache = input[i] + input[first] + input[second] + input[third];
                    if (sumCache == target) {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[first]);
                        cacheList.add(input[i]);
                        cacheList.add(input[second]);
                        cacheList.add(input[third]);
                        result.add(cacheList);
                        second++;
                        third--;
                    } else if (sumCache < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
                first++;
                third = input.length - first;
            }
        }
        return result;
    }

    // Error 在({-1, -1, -1, 0, 0, 0, 0, 1, 1, 1}, 0)的输入情况下,缺少一个输出
    // Not Perfect 毕竟O(n^3) 一般一个for只能使用三个值,这里应该两个for嵌套
    public static ArrayList<ArrayList<Integer>> getFourSumMy3(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (input == null || input.length < 4) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 1; i < input.length - 2; i++) {
            if (i != 0 && input[i] == input[i - 1]) {
                continue;
            }
            int first = i - 1;
            int third = input.length - 1;
            while (first < third) {
                int second = i + 1;
                while (second < third) {
                    int sumCache = input[i] + input[first] + input[second] + input[third];
                    if (sumCache == target) {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[first]);
                        cacheList.add(input[i]);
                        cacheList.add(input[second]);
                        cacheList.add(input[third]);
                        result.add(cacheList);
                        second++;
                        third--;
                        while (second < third && input[second] == input[second - 1]) {
                            second++; // to skip duplicate
                        }
                        while (second < third && input[third] == input[third + 1]) {
                            third--; // to skip duplicate
                        }
                    } else if (sumCache < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
                first++;
                while (first < third && input[first] == input[first - 1]) {
                    first++; // to skip duplicate
                }
                third = input.length - first;
            }
        }
        return result;
    }

    // Error 在({-1, -1, -1, 0, 0, 0, 0, 1, 1, 1}, 0)的输入情况下,多一个输出
    // Not Perfect 毕竟O(n^3) 一般一个for只能使用三个值,这里应该两个for嵌套
    public static ArrayList<ArrayList<Integer>> getFourSumMy4(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (input == null || input.length < 4) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 1; i < input.length - 2; i++) {
            if (i > 1 && input[i] == input[i - 1]) {
                continue;
            }
            int first = i - 1;
            int third = input.length - 1;
            while (first < third) {
                int second = i + 1;
                while (second < third) {
                    int sumCache = input[i] + input[first] + input[second] + input[third];
                    if (sumCache == target) {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[first]);
                        cacheList.add(input[i]);
                        cacheList.add(input[second]);
                        cacheList.add(input[third]);
                        result.add(cacheList);
                        second++;
                        third--;
                        while (second < third && input[second] == input[second - 1]) {
                            second++; // to skip duplicate
                        }
                        while (second < third && input[third] == input[third + 1]) {
                            third--; // to skip duplicate
                        }
                    } else if (sumCache < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
                first++;
                while (first < third && input[first] == input[first - 1]) {
                    first++; // to skip duplicate
                }
                third = input.length - first;
            }
        }
        return result;
    }

    // Not Perfect 毕竟O(n^3) 一般一个for只能使用三个值,这里应该两个for嵌套,而且判断是否已存在的做法并不很优雅
    public static ArrayList<ArrayList<Integer>> getFourSumMy5(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (input == null || input.length < 4) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 1; i < input.length - 2; i++) {
            if (i > 1 && input[i] == input[i - 1]) {
                continue;
            }
            int first = i - 1;
            int third = input.length - 1;
            while (first < third) {
                int second = i + 1;
                while (second < third) {
                    int sumCache = input[i] + input[first] + input[second] + input[third];
                    if (sumCache == target && input[i] >= input[first]) {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[first]);
                        cacheList.add(input[i]);
                        cacheList.add(input[second]);
                        cacheList.add(input[third]);
                        if (!result.contains(cacheList)) {
                            result.add(cacheList);
                        }
                        second++;
                        third--;
                        while (second < third && input[second] == input[second - 1]) {
                            second++; // to skip duplicate
                        }
                        while (second < third && input[third] == input[third + 1]) {
                            third--; // to skip duplicate
                        }
                    } else if (sumCache < target) {
                        second++;
                    } else {
                        third--;
                    }
                }
                first++;
                while (first < third && input[first] == input[first - 1]) {
                    first++; // to skip duplicate
                }
                third = input.length - first;
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> getFourSumAnswer(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (input == null || input.length < 4) {
            return result;
        }
        Arrays.sort(input);
        for (int i = 0; i < input.length - 3; i++) {
            if (i != 0 && input[i] == input[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < input.length - 2; j++) {
                if (j != i + 1 && input[j] == input[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = input.length - 1;
                while (left < right) {
                    int sum = input[i] + input[j] + input[left] + input[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ArrayList<Integer> cacheList = new ArrayList<>();
                        cacheList.add(input[i]);
                        cacheList.add(input[j]);
                        cacheList.add(input[left]);
                        cacheList.add(input[right]);
                        result.add(cacheList);
                        left++;
                        right--;
                        while (left < right && input[left] == input[left - 1]) {
                            left++;
                        }
                        while (left < right && input[right] == input[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
