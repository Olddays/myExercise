package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC3306_CountOfSubstringsContainingEveryVowelAndKConsonantsII {

    // 移动框体
    // Error，题目理解错误并不是说必须得5+k个字母，而是包含关系，所以也许应该用dp或者双指针
    private static long countOfSubstringsMyError1(String word, int k) {
        int length = word.length();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (char vowel : vowels) {
            vowelMap.put(vowel, 0);
        }
        int consonantCount = 0;
        long count = 0;
        for (int i = 0; i < 5 + k; i++) {
            char letter = word.charAt(i);
            if (vowelMap.containsKey(letter)) {
                vowelMap.put(letter, vowelMap.get(letter) + 1);
            } else {
                consonantCount++;
            }
        }
        if (checkSubstring(vowelMap, consonantCount, k)) {
            count++;
        }
        for (int i = 5 + k; i < length; i++) {
            char preLetter = word.charAt(i - 5 - k);
            char letter = word.charAt(i);
            if (vowelMap.containsKey(preLetter)) {
                vowelMap.put(preLetter, vowelMap.get(preLetter) - 1);
            } else {
                consonantCount--;
            } // 去掉后一个
            if (vowelMap.containsKey(letter)) {
                vowelMap.put(letter, vowelMap.get(letter) + 1);
            } else {
                consonantCount++;
            }
            if (checkSubstring(vowelMap, consonantCount, k)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkSubstring(Map<Character, Integer> vowelMap, int consonantCount, int k) {
        if (consonantCount != k) {
            return false;
        }
        for (char vowel : vowelMap.keySet()) {
            if (vowelMap.get(vowel) < 1) {
                return false;
            }
        }
        return true;
    }

    // 双指针
    // 还是有问题，无法处理包含的情况，如iqeaouqi，K为2
    private static long countOfSubstringsMyError2(String word, int k) {
        int length = word.length();
        int count = 0;

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (char vowel : vowels) {
            vowelMap.put(vowel, 0);
        }
        int consonantCount = 0;

        int left = 0;
        // int right = 5 + k; // 左闭右开区间，确保右侧是小于而非小于等于
        for (int i = 0; i < length; i++) {
            // 先一直往右遍历并且往map和consonantCount中添加内容，直到consonantCount>=k，核心是比较consonantCount和k的关系
            char letter = word.charAt(i);
            if (vowelMap.containsKey(letter)) {
                vowelMap.put(letter, vowelMap.get(letter) + 1);
            } else {
                consonantCount++;
            }
            if ((consonantCount == k)) { // 等于k时，就可以进行判断了
                boolean match = true;
                for (char vowel : vowelMap.keySet()) {
                    if (vowelMap.get(vowel) < 1) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            }
            if (consonantCount > k) {
                // 当辅音字母等于k时，left往前走，并且弹出直到下一个辅音出现
                char preLetter = word.charAt(left++);
                while (left < i && vowelMap.containsKey(preLetter)) {
                    int val = vowelMap.get(preLetter) - 1;
                    if (val == 0) {
                        break;
                    }
                    vowelMap.put(preLetter, val);
                    preLetter = word.charAt(left++);
                }
                if (!vowelMap.containsKey(preLetter) && left < i - 1) {
                    consonantCount--;
                }
            }
        }
        return count;
    }

    // 问：某班有 10 个人至少 20 岁，3 个人至少 21 岁，那么恰好 20 岁的人有多少个？
    //答：「至少 20 岁」可以分成「恰好 20 岁」和「至少 21 岁」，所以「至少 20 岁」的人数减去「至少 21 岁」的人数，就是「恰好 20 岁」的人数，即 10−3=7。
    //根据这个思路，本题等价于如下两个问题：
    //
    //每个元音字母至少出现一次，并且至少包含 k 个辅音字母的子串个数。记作 fk
    //每个元音字母至少出现一次，并且至少包含 k+1 个辅音字母的子串个数。记作 fk+1
    //二者相减，所表达的含义就是恰好包含 k 个辅音字母了，所以答案为 fk − fk+1
    // Beats 17.09%
    private static long countOfSubstringsMy1(String word, int k) {
        char[] chars = word.toCharArray();
        return countOfSubstringsMy1Helper(chars, k) - countOfSubstringsMy1Helper(chars, k + 1);
    }

    private static long countOfSubstringsMy1Helper(char[] word, int k) {
        long ans = 0;
        int[] vowels = new int[26]; // 每种元音的个数
        int consonantCount = 0; // 辅音个数
        int left = 0;
        for (char c : word) {
            if ("aeiou".indexOf(c) >= 0) {
                vowels[c - 'a']++;
            } else {
                consonantCount++;
            }
            while (countVowels(vowels) == 5 && consonantCount >= k) {
                char out = word[left];
                if ("aeiou".indexOf(out) >= 0) {
                    vowels[out - 'a']--;
                } else {
                    consonantCount--;
                }
                left++;
            }
            // 滑动窗口的内层循环结束时，右端点固定在 right，左端点在 0,1,2,⋯,left−1 的所有子串都是合法的，这一共有 left 个
            // 核心是因为要找大于k
            ans += left;
        }
        return ans;
    }

    private static int countVowels(int[] vowels) {
        int result = 0;
        for (int num : vowels) {
            if (num > 0) {
                result++;
            }
        }
        return result;
    }

    private static long countOfSubstringsAnswer1(String word, int k) {
        String vowels = "aeiou";
        int leftPointer = 0, midPointer = 0, distinctVowelCount = 0;
        int[] vowelCount = new int[6]; // 可以利用vowels = "aeiou"，把数组从26个精简成5个
        int[] countedVowels = new int[6];
        long result = 0;

        for (int i = 0; i < word.length(); i++) {
            int vowelIndex = vowels.indexOf(word.charAt(i)) + 1;
            vowelCount[vowelIndex]++;
            distinctVowelCount += (vowelCount[vowelIndex] == 1 && vowelIndex > 0) ? 1 : 0;

            while (vowelCount[0] > k) {
                int leftVowelIndex = vowels.indexOf(word.charAt(leftPointer)) + 1;
                vowelCount[leftVowelIndex]--;
                distinctVowelCount -= (vowelCount[leftVowelIndex] == 0 && leftVowelIndex > 0) ? 1 : 0;
                leftPointer++;
            }

            if (distinctVowelCount == 5 && vowelCount[0] == k) {
                if (midPointer < leftPointer) {
                    midPointer = leftPointer;
                    Arrays.fill(countedVowels, 0);
                }
                while (true) {
                    int midVowelIndex = vowels.indexOf(word.charAt(midPointer)) + 1;
                    if (midVowelIndex == 0 || vowelCount[midVowelIndex] - countedVowels[midVowelIndex] == 1) break;
                    countedVowels[midVowelIndex]++;
                    midPointer++;
                }
                result += midPointer - leftPointer + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] wordList = new String[]{
                "iqeaouqi",
                "ieaouqqieaouqq",
                "aeioqq",
                "aeiou",
        };
        int[] kList = new int[]{
                2,
                1,
                1,
                0,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < wordList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countOfSubstringsMy1(wordList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countOfSubstrings My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < wordList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countOfSubstringsAnswer1(wordList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countOfSubstrings Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
