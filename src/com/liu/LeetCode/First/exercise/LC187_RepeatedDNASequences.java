package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC187_RepeatedDNASequences {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
     * <p>
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     * <p>
     * For example,
     * <p>
     * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
     * <p>
     * Return:
     * ["AAAAACCCCC", "CCCCCAAAAA"].
     */

    public static List<String> getRepeatedDNASequencesMy1(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        if (length <= 10) {
            return result;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= length - 10; i++) {
            String cache = s.substring(i, i + 10);
            if (set.contains(cache)) {
                if (!result.contains(cache)) {
                    result.add(cache);
                }
            } else {
                set.add(cache);
            }
        }
        return result;
    }
}
