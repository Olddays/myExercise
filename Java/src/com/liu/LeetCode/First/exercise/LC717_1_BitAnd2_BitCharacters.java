package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC717_1_BitAnd2_BitCharacters {
    /**
     * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
     * <p>
     * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
     * <p>
     * Example 2:
     * <p>
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
     * <p>
     * Note:
     * 1 <= len(bits) <= 1000.
     * bits[i] is always 0 or 1.
     */

    public static boolean get1_BitAnd2_BitCharactersAnswer1(int[] bits) {
        int length = bits.length;
        if (length == 0) {
            return false;
        }
        int i = 0;
        while (i < length - 1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }
        return i == length - 1;
    }

    /**
     * We don't need to traverse the whole array, just check the last part of it.
     * if there is only one symbol in array the answer is always true (as last element is 0)
     * if there are two 0s at the end again the answer is true no matter what the rest symbols are( ...1100, ...1000,)
     * if there is 1 right before the last element(...10), the outcome depends on the count of sequential 1, i.e.
     * a) if there is odd amount of 1(10, ...01110, etc) the answer is false as there is a single 1 without pair
     * b) if it's even (110, ...011110, etc) the answer is true, as 0 at the end doesn't have anything to pair with
     */
    public static boolean get1_BitAnd2_BitCharactersAnswer2(int[] bits) {
        int ones = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) { //starting from one but last, as last one is always 0
            ones++;
        }
        return ones % 2 <= 0;
    }
}
