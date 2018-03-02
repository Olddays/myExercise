package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/30.
 */
public class LC076_MinimumWindowSubstring {
    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     * <p>
     * For example,
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * <p>
     * Minimum window is "BANC".
     * <p>
     * Note:
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * <p>
     * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */

    /**
     * https://leetcode.com/problems/minimum-window-substring/discuss/
     * <p>
     * I will first give the solution then show you the magic template.
     * The code of solving this problem is below. It might be the shortest among all solutions provided in Discuss.
     * <p>
     * Here comes the template.
     * <p>
     * For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions.
     * A general way is to use a hashmap assisted with two pointers. The template is given below.
     * int findSubstring(string s){
     * vector<int> map(128,0);
     * int counter; // check whether the substring is valid
     * int begin=0, end=0; //two pointers, one point to tail and one  head
     * int d; //the length of substring
     * <p>
     * for() {
     * // initialize the hash map here/
     * }
     * <p>
     * while(end<s.size()){
     * <p>
     * if(map[s[end++]]-- ?){
     * // modify counter here/
     * }
     * <p>
     * while(// counter condition/ ){
     * <p>
     * // update d here if finding minimum/
     * <p>
     * //increase begin to make it invalid/valid again/
     * <p>
     * if(map[s[begin++]]++ ?){ //modify counter here/ }
     * }
     * <p>
     * // update d here if finding maximum/
     * }
     * return d;
     * }
     * <p>
     * One thing needs to be mentioned is that when asked to find maximum substring, we should update maximum after the inner while loop to guarantee that the substring is valid. On the other hand, when asked to find minimum substring, we should update minimum inside the inner while loop.
     * <p>
     * The code of solving Longest Substring with At Most Two Distinct Characters is below:
     * int lengthOfLongestSubstringTwoDistinct(string s) {
     * vector<int> map(128, 0);
     * int counter=0, begin=0, end=0, d=0;
     * while(end<s.size()){
     * if(map[s[end++]]++==0) counter++;
     * while(counter>2) if(map[s[begin++]]--==1) counter--;
     * d=max(d, end-begin);
     * }
     * return d;
     * }
     * The code of solving Longest Substring Without Repeating Characters is below:
     * <p>
     * Update 01.04.2016, thanks @weiyi3 for advise.
     * <p>
     * int lengthOfLongestSubstring(string s) {
     * vector<int> map(128,0);
     * int counter=0, begin=0, end=0, d=0;
     * while(end<s.size()){
     * if(map[s[end++]]++>0) counter++;
     * while(counter>0) if(map[s[begin++]]-->1) counter--;
     * d=max(d, end-begin); //while valid, update d
     * }
     * return d;
     * }
     * <p>
     * I think this post deserves some upvotes! : )
     */
    public static String getMinimumWindowSubstringAnswer1(String s, String t) {
        int[] map = new int[128];
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        for (char c : targetChars) {
            map[c]++;
        }
        int counter = targetChars.length;
        int begin = 0;
        int end = 0;
        int distance = Integer.MAX_VALUE;
        int head = 0;
        while (end < stringChars.length) {
            if (map[stringChars[end++]]-- > 0) {
                counter--; //in t
            }
            while (counter == 0) { //valid
                if (end - begin < distance) {
                    distance = end - (head = begin);
                }
                if (map[stringChars[begin++]]++ == 0) {
                    counter++;  //make it invalid
                }
            }
        }
        return distance == Integer.MAX_VALUE ? "" : s.substring(head, head + distance);
    }

    /**
     * The current window is s[i:j] and the result window is s[I:J].
     * In need[c] I store how many times I need character c (can be negative)
     * and missing tells how many characters are still missing. In the loop,
     * first add the new character to the window. Then, if nothing is missing,
     * remove as much as possible from the window start and then update the result.
     */
    public static String getMinimumWindowSubstringAnswer2(String s, String t) {
        int missing = t.length();
        char[] stringChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        int[] need = new int[128];
        for (char c : targetChars) {
            need[c]++;
        }
        int i = 0;
        int start = 0;
        int end = 0;
        boolean found = false;
        for (int j = 0; j < stringChars.length; j++) {
            char c = stringChars[j];
            if (need[c] > 0) {
                missing--;
            }
            need[c]--;
            if (missing == 0) {
                while (i < j && need[stringChars[i]] < 0) {
                    need[stringChars[i]]++;
                    i++;
                }
                if (end == 0 || j - i < end - start) {
                    found = true;
                    start = i;
                    end = j + 1;
                }
            }
        }
        if (found) {
            return s.substring(start, end);
        } else {
            return "";
        }
    }
}
