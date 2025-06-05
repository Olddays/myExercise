package com.liu.LeetCode.Daily.Daliy202506;

import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC3403_FindTheLexicographicallyLargestStringFromTheBoxI {

    // 切成numFriends段，并且找到其中字典序最大（开头字母最大且最长）的串
    // 首先，最长串是word.length-numFriends+1
    // 其次，最大字母应该是z
    // Beats 5.56%
    private static String answerStringMy1(String word, int numFriends) {
        if (numFriends <= 1) {
            return word;
        }
        int length = word.length();
        int biggestChar = 0;
        for (char c : word.toCharArray()) {
            biggestChar = Math.max(biggestChar, c);
        }
        List<Integer> biggestCharLocations = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            if (biggestChar == (int) c) {
                biggestCharLocations.add(i);
            }
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        for (int location : biggestCharLocations) {
            int left;
            int right;
            if (location < numFriends - 1) { // 此时前面的不够分，需要将最后面的numFriends-location个字符补上、
                left = location;
                right = left + length - numFriends + 1;
            } else if (location >= length - numFriends) { // 此时后面的不够分，长度最大是length-1
                left = location;
                right = length;
            } else { // 此时前后空间都够，那就选择最大长度，但是最大长度可能越界，此时使用length
                left = location;
                right = Math.min(location + (length - numFriends + 1), length);
            }
            String cache = sb.substring(left, right);
            boolean isBetter = false;
            int i;
            for (i = 0; i < Math.min(cache.length(), result.length()); i++) {
                if (cache.charAt(i) > result.charAt(i)) {
                    isBetter = true;
                    break;
                } else if (cache.charAt(i) < result.charAt(i)) {
                    break;
                }
            }
            if (isBetter || cache.length() > result.length()) {
                result = cache;
            }
        }
        return result;
    }

    private static String answerStringAnswer1(String word, int numFriends) {
        final int n = word.length();

        final int maxL = n - (numFriends - 1);

        if(maxL == n) return word;

        final ArrayList<Integer>[] starts = new ArrayList[26];
        for(int i = 0; i < n; i++){
            final int ind = word.charAt(i) - 'a';
            if(starts[ind] == null)
                starts[ind] = new ArrayList<>();
            starts[ind].add(i);
        }

        for(int i = 25; i >= 0; i--){
            if(starts[i] == null) continue;
            if(starts[i].size() == 1){
                return word.substring(starts[i].get(0), Math.min(starts[i].get(0) + maxL, n) );
            } else {
                final ArrayList<Integer> candidates = starts[i];
                int maxInd = 0;
                String max = word.substring(candidates.get(maxInd), Math.min(candidates.get(maxInd) + maxL, n));
                for(int j = 0; j < candidates.size(); ++j){
                    final String curr= word.substring(candidates.get(j), Math.min(candidates.get(j) + maxL, n));
                    if(max.compareTo(curr) < 0)
                        max = curr;

                }
                return max;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] wordList = new String[]{
                "jcooek",
                "nbjnc",
                "cfhgf",
                "bif",
                "aann",
                "jmf",
                "gh",
                "dbca",
                "gggg",
        };
        int[] numFriendsList = new int[]{
                4,
                2,
                2,
                2,
                2,
                3,
                1,
                2,
                4,
        };
        String[] resultList = new String[]{
                "ooe",
                "nc",
                "hgf",
                "if",
                "nn",
                "m",
                "gh",
                "dbc",
                "g",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordList.length; i++) {
            startTime = System.currentTimeMillis();
            result = answerStringMy1(wordList[i], numFriendsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("answerString My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < wordList.length; i++) {
            startTime = System.currentTimeMillis();
            result = answerStringAnswer1(wordList[i], numFriendsList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("answerString Answer1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
