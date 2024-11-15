package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT024_PerfectStrikeOut {
    /**
     * 对喜爱棒球的少年而言，“三振出局”下图是一定要试一次的。这是一个在本垒上放置9个靶子，击打投手投来的球，命中靶子的游戏。
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 据说这可以磨练球手的控制力。 现在来思考一下这9个靶子的击打顺序。
     * 假设除了高亮的5号靶子以外，如果1个靶子有相邻的靶子，则可以一次性把这2个靶子都击落。
     * 譬如，如下图所示，假设1号、6号、9号已经被击落了，那么接下来，对于“2和3”“4和7”“7和8”这3组靶子，我们就可以分别一次性击落了。
     * 0 2 3
     * 4 5 0
     * 7 8 0
     * <p>
     * 问题
     * 求9个靶子的击落顺序有多少种？这里假设每次投手投球后，击球手都可以击中一个靶子。
     * <p>
     * Hint：
     * 能一次击落2个靶子，已经击落的靶子下次就不能用了，譬如1号被击落后，与1号靶子相邻的地方就不能再一次击落2个了。
     */

    // 问题的关键在于，已经击落的靶子就不能再次击中。
    // 1 号被击落后，“1 和 2”“ 1 和 4”就不能再适用“一次性击落”这种情况了。
    // 反过来说，如果一次性击落“1 和 2”，则 1 号和2 号靶子就都不能再使用了。
    // 为实现这样的思路，这里用数组来表示击打方法。
    // 另外，无论是按照1 号 ~3 号的顺序击球，还是按照3 号 ~1 号的顺序击球，这之后的模式都是一样的。
    // 因此可以把已遍历的靶子内存化，从而优化处理速度。
    public static int getPerfectStrikeOutMy1(int length, int width) {
        int num = 1;
        int[][] cache = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                cache[i][j] = num++;
            }
        }
        List<int[]> doubleShot = getDoubleShotList(cache, length, width);
        doubleShot.set(0, new int[]{cache[length / 2][width / 2]});
        for (int i = 1; i <= length * width; i++) {
            if (i == (length * width + 1) / 2) {
                continue;
            }
            doubleShot.add(new int[]{i});
        }
        List<String> memory = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        countPossibleCombine(result, doubleShot, memory, 0, length * width);
        return result.size();
    }

    private static void countPossibleCombine(List<List<String>> result, List<int[]> doubleShot, List<String> memory,
                                             int start, int size) {
        if (memory.size() == size) {
            result.add(new ArrayList<>(memory));
        } else {
            for (int i = start; i < doubleShot.size(); i++) {
                boolean hasNum = false;
                for (int num : doubleShot.get(i)) {
                    if (memory.contains(String.valueOf(num))) {
                        hasNum = true;
                        break;
                    }
                }
                if (!hasNum) {
                    for (int num : doubleShot.get(i)) {
                        memory.add(String.valueOf(num));
                    }
                    countPossibleCombine(result, doubleShot, memory, start + 1, size);
                    for (int num : doubleShot.get(i)) {
                        memory.remove(String.valueOf(num));
                    }
                } else {
                    countPossibleCombine(result, doubleShot, memory, start + 1, size);
                }
            }
        }
    }

    private static List<int[]> getDoubleShotList(int[][] cache, int length, int width) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i < length - 1 && j < width - 1) {
                    if (i == length / 2 && j == width / 2) {
                        continue;
                    }
                    if (i + 1 != length / 2 || j != width / 2) {
                        int[] pair = {cache[i][j], cache[i + 1][j]};
                        result.add(pair);
                    }
                    if (i != length / 2 || j + 1 != width / 2) {
                        int[] pair = {cache[i][j], cache[i][j + 1]};
                        result.add(pair);
                    }
                } else if (i == length - 1 && j < width - 1) {
                    int[] pair = {cache[i][j], cache[i][j + 1]};
                    result.add(pair);
                } else if (i < length - 1 && j == width - 1) {
                    int[] pair = {cache[i][j], cache[i + 1][j]};
                    result.add(pair);
                }
            }
        }
        return result;
    }

}