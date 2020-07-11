package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/22.
 */
public class TD20_PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }
}
