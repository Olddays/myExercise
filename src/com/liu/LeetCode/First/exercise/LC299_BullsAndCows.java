package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC299_BullsAndCows {
    /**
     * You are playing the following Bulls and Cows game with your friend:
     * You write down a number and ask your friend to guess what the number is.
     * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess
     * match your secret number exactly in both digit and position (called "bulls") and how many digits match
     * the secret number but locate in the wrong position (called "cows").
     * Your friend will use successive guesses and hints to eventually derive the secret number.
     * <p>
     * For example:
     * <p>
     * Secret number:  "1807"
     * Friend's guess: "7810"
     * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
     * Write a function to return a hint according to the secret number and friend's guess,
     * use A to indicate the bulls and B to indicate the cows. In the above example,
     * your function should return "1A3B".
     * <p>
     * Please note that both secret number and friend's guess may contain duplicate digits, for example:
     * <p>
     * Secret number:  "1123"
     * Friend's guess: "0111"
     * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
     * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
     * <p>
     * Credits:
     * Special thanks to @jeantimex for adding this problem and creating all test cases.
     */

    // 无法处理 "1122","3456" 这种输入, cache会变为[0,2,2,-1,-1,-1,-1,0,0,0,0],此时cowSize不应该--,而应该cowSize-=i
    public static String getBullsAndCowsMy1(String secret, String guess) {
        int secretLength = secret.length();
        int guessLength = guess.length();
        if (secretLength != guessLength || secretLength * guessLength == 0) {
            return "";
        }
        int bullSize = 0;
        for (int i = 0; i < secretLength; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullSize++;
            }
        }
        int cowSize = guessLength - bullSize;
        int[] cache = new int[10];
        for (int i = 0; i < secretLength; i++) {
            cache[secret.charAt(i) - '0']++;
            cache[guess.charAt(i) - '0']--;
        }
        for (int i : cache) {
            if (i > 0) { // 仅需要计算大于0的部分,即secret中guess没有match到的部分
                cowSize--;
            }
        }
        return bullSize + "A" + cowSize + "B";
    }

    public static String getBullsAndCowsMy2(String secret, String guess) {
        int secretLength = secret.length();
        int guessLength = guess.length();
        if (secretLength != guessLength || secretLength * guessLength == 0) {
            return "";
        }
        int bullSize = 0;
        for (int i = 0; i < secretLength; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullSize++;
            }
        }
        int cowSize = guessLength - bullSize;
        int[] cache = new int[10];
        for (int i = 0; i < secretLength; i++) {
            cache[secret.charAt(i) - '0']++;
            cache[guess.charAt(i) - '0']--;
        }
        for (int i : cache) {
            if (i > 0) { // 仅需要计算大于0的部分,即secret中guess没有match到的部分
                cowSize -= i;
            }
        }
        return bullSize + "A" + cowSize + "B";
    }

    /**
     * The idea is to iterate over the numbers in secret and in guess and count all bulls right away.
     * For cows maintain an array that stores count of the number appearances in secret and in guess.
     * Increment cows when either number from secret was already seen in guest or vice versa.
     */
    public static String getBullsAndCowsAnswer1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    /**
     * A slightly more concise version:
     */
    public static String getBullsAndCowsAnswer2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
