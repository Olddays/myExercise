package com.liu.LeetCode.First.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 2017/9/30.
 */
public class LC621_TaskScheduler {
    /**
     * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
     * <p>
     * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
     * <p>
     * You need to return the least number of intervals the CPU will take to finish all the given tasks.
     * <p>
     * Example 1:
     * <p>
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     * <p>
     * Note:
     * <p>
     * The number of tasks is in the range [1, 10000].
     * The integer n is in the range [0, 100].
     */

    // 最后的计算部分不能处理{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D' ,'D'}, 2的输入形式
    public static int getTaskSchedulerMy1(char[] tasks, int n) {
        int length = tasks.length;
        int result = 0;
        if (length == 0) {
            return result;
        }
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> cacheMap = new HashMap<>();
        for (char c : tasks) {
            cacheMap.put(c, cacheMap.getOrDefault(c, 0) + 1);
        }
        int size = cacheMap.size();
        int max = 0;
        int[] cache = new int[size];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : cacheMap.entrySet()) {
            cache[i++] = entry.getValue();
            max = Math.max(entry.getValue(), max);
        }
        Arrays.sort(cache);
        int target = 0;
        if (n + 1 < size) {
            target = cache[size - (n + 1)];
        }
        result += (max - target) * (n + 1);
        int index = 0;
        for (i = 0; i < size - (n + 1); i++) {
            result += (cache[i] - index) * (cache.length - i);
            index += cache[i];
        }
        return result;
    }

    public static int getTaskSchedulerMy2(char[] tasks, int n) {
        int length = tasks.length;
        if (length == 0) {
            return 0;
        }
        Map<Character, Integer> cacheMap = new HashMap<>();
        for (char c : tasks) {
            cacheMap.put(c, cacheMap.getOrDefault(c, 0) + 1);
        }
        int size = cacheMap.size();
        int max = 0;
        int[] cache = new int[size];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : cacheMap.entrySet()) {
            cache[i++] = entry.getValue();
            max = Math.max(entry.getValue(), max);
        }
        Arrays.sort(cache);
        int exPart = 0;
        for (i = 0; i < size; i++) {
            if (cache[i] == max) {
                exPart++;
            }
        }
        return Math.max((max - 1) * (n + 1) + exPart, length);
    }

    /**
     * First consider the most frequent characters, we can determine their relative positions first and use them as a frame to insert the remaining less frequent characters. Here is a proof by construction:
     * <p>
     * Let F be the set of most frequent chars with frequency k.
     * We can create k chunks, each chunk is identical and is a string consists of chars in F in a specific fixed order.
     * Let the heads of these chunks to be H_i; then H_2 should be at least n chars away from H_1, and so on so forth; then we insert the less frequent chars into the gaps between these chunks sequentially one by one ordered by frequency in a decreasing order and try to fill the k-1 gaps as full or evenly as possible each time you insert a character. In summary, append the less frequent characters to the end of each chunk of the first k-1 chunks sequentially and round and round, then join the chunks and keep their heads' relative distance from each other to be at least n.
     * <p>
     * Examples:
     * <p>
     * AAAABBBEEFFGG 3
     * <p>
     * here X represents a space gap:
     * <p>
     * Frame: "AXXXAXXXAXXXA"
     * insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
     * insert 'E': "ABEXABEXABXXA"
     * insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
     * insert 'G': "ABEFABEGABFGA"
     * <p>
     * AACCCBEEE 2
     * <p>
     * 3 identical chunks "CE", "CE CE CE" <-- this is a frame
     * insert 'A' among the gaps of chunks since it has higher frequency than 'B' ---> "CEACEACE"
     * insert 'B' ---> "CEABCEACE" <----- result is tasks.length;
     * <p>
     * AACCCDDEEE 3
     * <p>
     * 3 identical chunks "CE", "CE CE CE" <--- this is a frame.
     * Begin to insert 'A'->"CEA CEA CE"
     * Begin to insert 'B'->"CEABCEABCE" <---- result is tasks.length;
     * <p>
     * ACCCEEE 2
     * <p>
     * 3 identical chunks "CE", "CE CE CE" <-- this is a frame
     * Begin to insert 'A' --> "CEACE CE" <-- result is (c[25] - 1) * (n + 1) + 25 -i = 2 * 3 + 2 = 8
     */
    // (c[25] - 1) * (n + 1) + 25 - i  is frame size
    // when inserting chars, the frame might be "burst", then tasks.length takes precedence
    // when 25 - i > n, the frame is already full at construction, the following is still valid.
    public static int getTaskSchedulerAnswer1(char[] tasks, int n) {
        int length = tasks.length;
        if (length == 0) {
            return 0;
        }
        int[] cache = new int[26];
        for (char t : tasks) {
            int i = t - 'A';
            cache[i]++;
        }
        Arrays.sort(cache);
        int i = 25;
        while (i >= 0 && cache[i] == cache[25]) {
            i--;
        }
        return Math.max(tasks.length, (cache[25] - 1) * (n + 1) + 25 - i);
    }
}
