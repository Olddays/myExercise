package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT004_SplitStick {
    /**
     * 假设要把长度为 n 厘米的木棒切分为 1 厘米长的小段，但是 1 根木 棒只能由 1 人切分，当木棒被切分为 3 段后，可以同时由 3 个人分别切 分木棒( 图 2 )。
     * 求最多有 m 个人时，最少要切分几次。譬如 n = 8，m = 3 时如下 图所示，切分 4 次就可以了。
     * <p>
     * 问题一:
     * 求当 n = 20，m = 3 时的最少切分次数。
     * <p>
     * 问题二:
     * 求当 n = 100，m = 5 时的最少切分次数。
     * <p>
     * hint:
     * 如果人数足够，每次都对半切分所有木棒应该是最快的。
     * 因为存在人数限制，所以诀窍在于要尽量不让人空闲下来。
     */

    public static int getSplitStickMy1(int stickLength, int number) {
        int result = 0;
        int partSize = 1;
        while (partSize < stickLength) {
            if (number >= partSize) {
                partSize *= 2;
            } else {
                partSize += number;
            }
            result += 1;
        }
        return result;
    }

    public static int getSplitStickMy2(int stickLength, int number) {
        return splitStick(stickLength, number, 1);
    }

    private static int splitStick(int stickLength, int number, int partSize) {
        if (partSize >= stickLength) {
            // 当切片数量大于等于长度的时候,说明此时已经切完了
            return 0;
        } else if (number >= partSize) {
            // 当切片员工大于目前的切片,则接下来的数量是当前的2倍,最后+1切片次数
            return splitStick(stickLength, number, partSize * 2) + 1;
        } else {
            // 当切片员工小于目前的切片,则接下来的数量是当前的员工数量,最后+1切片次数
            return splitStick(stickLength, number, partSize + number) + 1;
        }
    }
}
