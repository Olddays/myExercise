package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liu on 2017/9/30.
 */
public class LC202_HappyNumber {
    /**
     * Write an algorithm to determine if a number is "happy".
     * <p>
     * A happy number is a number defined by the following process:
     * Starting with any positive integer,
     * replace the number by the sum of the squares of its digits,
     * and repeat the process until the number equals 1 (where it will stay),
     * or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     * <p>
     * Example: 19 is a happy number
     * <p>
     * 1² + 9² = 82
     * 8² + 2² = 68
     * 6² + 8² = 100
     * 1² + 0² + 0² = 1
     * <p>
     * Credits:
     * Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
     */

    public static boolean getHappyNumberMy1(int n) {
        if (n == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1 && !set.contains(sum)) {
            int cache = sum;
            set.add(sum);
            List<Integer> list = new ArrayList<>();
            while (cache != 0) {
                list.add(cache % 10);
                cache = cache / 10;
            }
            sum = 0;
            for (int i : list) {
                sum += i * i;
            }
        }
        return sum == 1;
    }
}
