package com.liu.LeetCode.Daily.Daily202412;

public class LC2109_AddingSpacesToAString {

    // 最直观的想法，遍历string，记录位置，添加空格
    // 时间复杂度O(n)，太久了，Time Limit Exceeded
    private static String addSpacesMy1(String s, int[] spaces) {
        int spaceIndex = 0;
        char[] sChars = s.toCharArray();
        String result = "";
        for (int i = 0; i < sChars.length; i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                result += " ";
                spaceIndex++;
            }
            result += sChars[i];
        }
        return result;
    }

    private static String addSpacesAnswer1(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        sb.append(s, 0, spaces[0]);
        int i = 1;
        while (i < spaces.length) {
            sb.append(" ");
            sb.append(s, spaces[i - 1], spaces[i]);
            i++;
        }
        sb.append(" ");
        sb.append(s.substring(spaces[i - 1]));

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] sList = new String[]{
                "LeetcodeHelpsMeLearn",
                "icodeinpython",
                "spacing",
        };
        int[][] spacesList = new int[][]{
                {8, 13, 15},
                {1, 5, 7, 9},
                {0, 1, 2, 3, 4, 5, 6},
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = addSpacesMy1(sList[i], spacesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("addSpaces My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < sList.length; i++) {
            startTime = System.currentTimeMillis();
            result = addSpacesAnswer1(sList[i], spacesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("addSpaces Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
