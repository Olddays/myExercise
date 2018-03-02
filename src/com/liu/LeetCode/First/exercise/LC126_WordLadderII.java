package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by liu on 2017/9/30.
 */
public class LC126_WordLadderII {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
     * <p>
     * Only one letter can be changed at a time
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * <p>
     * For example,
     * <p>
     * Given:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * Return
     * <p>
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * <p>
     * Note:
     * <p>
     * Return an empty list if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * <p>
     * UPDATE (2017/1/20):
     * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
     */

    // The solution contains two steps 1 Use BFS to construct a graph. 2. Use DFS to construct the paths from end to start.Both solutions got AC within 1s.
    // The first step BFS is quite important. I summarized three tricks
    // Using a MAP to store the min ladder of each word, or use a SET to store the words visited in current ladder, when the current ladder was completed, delete the visited words from unvisited. That's why I have two similar solutions.
    // Use Character iteration to find all possible paths. Do not compare one word to all the other words and check if they only differ by one character.
    // One word is allowed to be inserted into the queue only ONCE. See my comments.
    public static List<List<String>> getWordLadderIIAnswer1(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> results = new ArrayList<>();
        if (wordList.size() == 0) {
            return results;
        }

        int min = Integer.MAX_VALUE;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Map<String, Integer> ladder = new HashMap<>();
        for (String string : wordList) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        wordList.add(endWord);
        //BFS: Dijisktra search
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;//'step' indicates how many steps are needed to travel to one word.
            if (step > min) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {//Check if it is the shortest path to one word.
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        } // It is a KEY line. If one word already appeared in one ladder,
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
                        if (map.containsKey(newWord)) {//Build adjacent Graph
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(newWord, list);
                            //It is possible to write three lines in one:
                            //map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
                            //Which one is better?
                        }
                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While
        //BackTracking
        LinkedList<String> result = new LinkedList<>();
        backTraceAnswer1(results, map, endWord, beginWord, result);
        return results;
    }

    private static void backTraceAnswer1(List<List<String>> results, Map<String, List<String>> map, String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTraceAnswer1(results, map, s, start, list);
            }
        }
        list.remove(0);
    }

    public static List<List<String>> getWordLadderIIAnswer2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        List<String> list = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (wordList.size() == 0) {
            return results;
        }
        int curr = 1, next = 0;
        boolean found = false;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        unvisited.add(endWord);
        unvisited.remove(beginWord);
        //BFS
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (unvisited.contains(new_word)) {
                        //Handle queue
                        if (visited.add(new_word)) {//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }
                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else {
                            List<String> l = new LinkedList<>();
                            l.add(word);
                            map.put(new_word, l);
                        }
                        if (new_word.equals(endWord) && !found) {
                            found = true;
                        }
                    }
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr == 0) {
                if (found) break;
                curr = next;
                next = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While
        backTraceAnswer2(results, list, map, endWord, beginWord);
        return results;
    }

    private static void backTraceAnswer2(List<List<String>> results, List<String> list,
                                         Map<String, List<String>> map, String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTraceAnswer2(results, list, map, s, start);
        list.remove(0);
    }
}
