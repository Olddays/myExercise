package com.liu.FunTestsOfProgrammer.exercise;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT021_XorTriangle {
    /**
     * 著名的“帕斯卡三角形”的计算法则是“某个数值是其左上角的数和右上角的数之和”。
     * 这里我们用异或运算代替单纯的和运算，从第一层开始计算，最终可以得到如下所示的三角形。
     * <p>
     * 第1层                1
     * 第2层               1 1
     * 第3层              1 0 1
     * 第4层             1 1 1 1
     * 第5层            1 0 0 0 1
     * 第6层           1 1 0 0 1 1
     * 第7层          1 0 1 0 1 0 1
     * 第8层         1 1 1 1 1 1 1 1
     * 第9层        1 0 0 0 0 0 0 0 1
     * 第10层      1 1 0 0 0 0 0 0 1 1
     * 第11层     1 0 1 0 0 0 0 0 1 0 1
     * 第12层    1 1 1 1 0 0 0 0 1 1 1 1
     * <p>
     * 问题：
     * 自上而下计算时，第 2014 个 0 会出现在哪一层？
     * ※ 第 1 个 0 在第 3 层，第 2、3、4 个 0 都在第 5 层。
     * <p>
     * Hint：
     * 两个真值的异或（XOR：exclusive or）运算规则是“当且仅当只 有一个为1时，结果为1，其余情况为0”
     * <p>
     * 异或运算表：
     * A    B   A XOR B
     * 0    0     0
     * 0    1     1
     * 1    0     1
     * 1    1     0
     */

    public static int getXorTriangleMy1(int index, int target) {
        if (target != 0 && target != 1) {
            return 0;
        }
        int targetCount = 0;
        int lineCount = 1;
        List<Integer> lastLine = new ArrayList<>();
        lastLine.add(1);
        if (target == 1) {
            targetCount++;
        }
        if (targetCount >= index) {
            return lineCount;
        }
        while (true) {
            lineCount++;
            List<Integer> lineCache = new ArrayList<>();
            int size = lastLine.size();
            lineCache.add(1);
            for (int i = 0; i < size - 1; i++) {
                int cache;
                if (lastLine.get(i).equals(lastLine.get(i + 1))) {
                    cache = 0;
                } else {
                    cache = 1;
                }
                lineCache.add(cache);
            }
            lineCache.add(1);
            for (int i : lineCache) {
                if (i == target) {
                    targetCount++;
                }
            }
            lastLine = lineCache;
            if (targetCount >= index) {
                return lineCount;
            }
        }
    }

    // 这种方式需要做很多次左移操作，如果使用int或long的话会导致内存溢出，所以最后使用了BigInteger
    public static int getXorTriangleMy2(int index, int target) {
        if (target != 0 && target != 1) {
            return 0;
        }
        int targetCount = 0;
        int lineCount = 1;
        BigInteger lineNum = new BigInteger("1");
        if (target == 1) {
            targetCount++;
        }
        while (targetCount < index) {
            lineNum = lineNum.xor(lineNum.shiftLeft(1));
            char[] cacheSet = lineNum.toString(2).toCharArray();
            for (char c : cacheSet) {
                if (c - '0' == target) {
                    targetCount++;
                }
            }
            lineCount++;
        }
        return lineCount;
    }
}