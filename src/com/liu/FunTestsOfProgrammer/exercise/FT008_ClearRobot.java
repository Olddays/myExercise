package com.liu.FunTestsOfProgrammer.exercise;

import javafx.util.Pair;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT008_ClearRobot {
    /**
     * 现在有很多制造商都在卖扫地机器人，它非常有用，能为忙碌的我们分担家务负担。
     * 不过我们也很难理解为什么扫地机器人有时候会反复清扫某一个地方。
     * 假设有一款不会反复清扫同一个地方的机器人，它只能前后左右移 动。
     * 举个例子，如果第 1 次向后移动，那么连续移动 3 次时，就会有以下 9 种情况( 图 6 )。
     * 又因为第 1 次移动可以是前后左右 4 种情况，所以移动 3 次时全部路径有 9×4 = 36 种。
     * <p>
     * 问题
     * 求这个机器人移动 12 次时，有多少种移动路径?
     * Hint
     * 最初3次的移动方向都很自由，从第4次开始，有些方向就不能移动了。
     */

    public static int getClearRobotMy1(int step) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(0, 0));
        return checkRobotRoot(list, step, 0, 0);
    }

    private static int checkRobotRoot(List<Pair<Integer, Integer>> list, int step, int x, int y) {
        if (list.size() >= step + 1) {
            return 1;
        }
        int cache = 0;
        Pair<Integer, Integer> pair = new Pair<>(x - 1, y);
        if (!list.contains(pair)) {
            list.add(pair);
            cache += checkRobotRoot(list, step, x - 1, y);
            list.remove(pair);
        }
        pair = new Pair<>(x + 1, y);
        if (!list.contains(new Pair<>(x + 1, y))) {
            list.add(pair);
            cache += checkRobotRoot(list, step, x + 1, y);
            list.remove(pair);
        }
        pair = new Pair<>(x, y - 1);
        if (!list.contains(new Pair<>(x, y - 1))) {
            list.add(pair);
            cache += checkRobotRoot(list, step, x, y - 1);
            list.remove(pair);
        }
        pair = new Pair<>(x, y + 1);
        if (!list.contains(new Pair<>(x, y + 1))) {
            list.add(pair);
            cache += checkRobotRoot(list, step, x, y + 1);
            list.remove(pair);
        }
        return cache;
    }
}
