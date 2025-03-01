package com.liu.LeetCode.Daily.Daily202502;

import java.util.*;

public class LC1079_LetterTilePossibilities {


    private static int numTilePossibilitiesAnswer1(String tiles) {
        char[] theArray = tiles.toCharArray();
        Arrays.sort(theArray); // sort the array for duplicate removal
        traverse(theArray, new boolean[theArray.length]);
        return count - 1;
    }

    private static int count = 0;

    private static void traverse(char[] theArray, boolean[] used) {
        count++; // count the number of sub-permutation
        for (int i = 0; i < theArray.length; i++) {
            if (used[i] || (i > 0 && theArray[i] == theArray[i - 1] && !used[i - 1])) {// duplicate removal
                continue;
            }
            used[i] = true;
            traverse(theArray, used);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] tilesList = new String[]{
                "AAB",
                "AAABBC",
                "V",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < tilesList.length; i++) {
            count = 0;
            startTime = System.currentTimeMillis();
            result = numTilePossibilitiesAnswer1(tilesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numTilePossibilities Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
