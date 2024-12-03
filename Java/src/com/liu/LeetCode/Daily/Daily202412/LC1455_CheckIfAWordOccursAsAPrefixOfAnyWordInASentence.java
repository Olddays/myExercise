package com.liu.LeetCode.Daily.Daily202412;

public class LC1455_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {

    private static int isPrefixOfWordMy1(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] sentenceList = new String[]{
                "i love eating burger",
                "this problem is an easy problem",
                "i am tired",
        };
        String[] searchWordList = new String[]{
                "burg",
                "pro",
                "you",
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < sentenceList.length; i++) {
            startTime = System.currentTimeMillis();
            result = isPrefixOfWordMy1(sentenceList[i], searchWordList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("isPrefixOfWord My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
