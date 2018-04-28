package com.liu.FunTestsOfProgrammer.exercise;

/**
 * Created by liu on 218/02/28.
 */
public class FT022_UncrossLine {
    /**
     * 用绳子连接纸杯制作“纸杯电话”——这应该勾起了很多人对理科
     * 实验的回忆。如果把绳子拉直,对着一边的纸杯讲话,声音就可以从另
     * 一边的纸杯传出。
     * 假设有几个小朋友以相同间隔围成圆周,要结对用纸杯电话相互通
     * 话。如果绳子交叉,很有可能会缠绕起来,所以结对的原则是不能让绳
     * 子交叉。
     * 举个例子,如果有 6 个小朋友,则只要如下图一样结对,就可以顺
     * 利用纸杯电话通话。也就是说,6 个人的时候,有 5 种结对方式。
     * .  1-2     1 2     1 2   1-2     1 2
     * .         /  \    / /            \ \
     * . 3---4  3    4  3 / 4  3   4  3 \ 4
     * .                 / /   \  /   \ \
     * .  5-6    5-6    5 6    5 6    5  6
     * <p>
     * 问题：
     * 求有 16 个小朋友的时候,一共有多少种结对方式?
     * <p>
     * Hint:
     * 为简化对交叉的判断,请先划分出范围再进行思考。
     */

    public static int getUncrossLineMy1(int number) {
        return 0;
    }

    // 这种方式需要做很多次左移操作，如果使用int或long的话会导致内存溢出
    public static int getUncrossLineMy2(int number) {
        return 0;
    }
}