package com.liu.LeetCode.First.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC030_SubstringWithConcatenationOfAllWords {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     * <p>
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     * <p>
     * You should return the indices: [0,9].
     * (order does not matter).
     */

    // Compile Error: cannot find symbol: class Pattern.....操 不能用正则的啊=.=
    // MD 一个字符串相关的算法题目不让用正则的啊..
    public static List<Integer> getSubstringWithConcatenationOfAllWordsMy1(String s, String[] words) {
        int length = words.length;
        List<Integer> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        String regular = "(";
        for (String word : words) {
            regular += word + "|";
        }
        regular = regular.substring(0, regular.length() - 1) + ")";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(s);
        List<Integer> endList = new ArrayList<>();
        while (matcher.find()) {
            if (result.size() > 0) {
                if (endList.get(endList.size() - 1) < matcher.start()) {
                    result.add(matcher.start());
                }
            } else {
                result.add(matcher.start());
            }
            endList.add(matcher.end());
        }
        return result;
    }

    /**
     * It's not too hard to find some resemblance between this problem and minimum-window-substring.
     * Actually the main difference is the fact that we are interested at some interval length:
     * we want intervals with fixed length K * M,
     * where K is the number of strings in the "words" array and M the length of each target string.
     * In order to apply the same idea we used for that problem,
     * all we need to do is to map each string from the "words" array to something we are able to index
     * (I prefer to use hashing for this).
     * Also, in order to speed up the algorithm, we can find all occurrences of those strings in S
     * (which is equivalent to do it on demand, but we will potentially do the same matching twice).
     * Notice that, we can simply apply these occurrences as they appear because we are assured that no word is contained by some other.
     * Finally, we use all this information to process each possibility.
     * Notice here that, the fact that all strings has the same length, implies that we have just M
     * (being M the length of each target string) possible starting points,
     * hence we end up performing M linear scans over array with length O(N/M)
     * (being N the length of S) and that makes the scanning stage of the algorithm to be linear on the length of S.
     */
    public static List<Integer> getSubstringWithConcatenationOfAllWordsAnswer1(String s, String[] words) {
        int length = words.length;
        List<Integer> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }
        int N = s.length();
        int M = words[0].length();
        if (N < M * words.length) {
            return result;
        }

        // map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<>(words.length);
        int[][] table = new int[2][words.length];
        int failures = 0;
        int index = 0;
        for (String word : words) {
            Integer mapped = mapping.get(word);
            if (mapped == null) {
                ++failures;
                mapping.put(word, index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        // find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int last = N - M + 1;
        int[] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        // fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            // reset scan variables
            int currentFailures = failures; // number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            // here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int partLength = right - left;
                        // instead of checking every window, we know exactly the length we want
                        if ((partLength / M) == words.length) {
                            result.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return result;
    }

    /**
     * My idea is pretty simple. Just build a map for the words and their relative count in L.
     * Then we traverse through S to check whether there is a match.
     */
    public static List<Integer> getSubstringWithConcatenationOfAllWordsAnswer2(String s, String[] words) {
        int stringLength = words.length;
        List<Integer> result = new ArrayList<>();
        if (stringLength == 0) {
            return result;
        }
        int wordLength = words[0].length(); // length of each word

        Map<String, Integer> wordMap = new HashMap<>(); // map for words
        for (String word : words) {
            wordMap.put(word, wordMap.containsKey(word) ? wordMap.get(word) + 1 : 1);
        }

        for (int i = 0; i <= stringLength - wordLength * words.length; i++) { // 这个减法是为了避免数组越界
            Map<String, Integer> copyMap = new HashMap<>(wordMap);
            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j * wordLength, i + j * wordLength + wordLength); // next word
                if (copyMap.containsKey(str)) { // is in remaining words
                    int count = copyMap.get(str);
                    if (count == 1) {
                        copyMap.remove(str);
                    } else {
                        copyMap.put(str, count - 1);
                    }
                    if (copyMap.isEmpty()) { // matches
                        result.add(i);
                        break;
                    }
                } else {
                    break; // not in L
                }
            }
        }
        return result;
    }
}
