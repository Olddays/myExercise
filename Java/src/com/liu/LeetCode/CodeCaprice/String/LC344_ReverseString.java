package com.liu.LeetCode.CodeCaprice.String;

public class LC344_ReverseString {

    private static void reverseStringMy1(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[][] sSet = new char[][]{
                {'h', 'e', 'l', 'l', 'o'},
                {'H', 'a', 'n', 'n', 'a', 'h'},
        };
        long startTime;
        long endTime;

        for (int i = 0; i < sSet.length; i++) {
            startTime = System.currentTimeMillis();
            reverseStringMy1(sSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("reverseString My1 result" + i + " ");
            for (char c : sSet[i]) {
                System.out.print(c + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
