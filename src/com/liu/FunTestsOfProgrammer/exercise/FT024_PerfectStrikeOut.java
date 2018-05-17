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

    public static int getPerfectStrikeOutMy1(int length, int width) {
        return 0;
    }

    public static int getPerfectStrikeOutMy2(int length, int width) {
        return 0;
    }

}