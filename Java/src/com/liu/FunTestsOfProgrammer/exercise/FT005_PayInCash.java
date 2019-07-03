package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT005_PayInCash {
    /**
     * 这个机器可以用纸币兑换到 10 日元、50 日元、100 日元和 500 日 元硬币的组合，且每种硬币的数量都足够多(因为公交接受的最小额度 为 10 日元，所以不提供 1 日元和 5 日元的硬币)。
     * 兑换时，允许机器兑换出本次支付时用不到的硬币。此外，因为在 乘坐公交时，如果兑换出了大量的零钱会比较不便，所以只允许机器最 多兑换出 15 枚硬币。譬如用 1000 日元纸币兑换时，就不能兑换出
     * “100 枚 10 日元硬币”的组合( 图 5 )。
     * <p>
     * 求兑换 1000 日元纸币时会出现多少种组合?注意，不计硬币兑出的先后顺序。
     */

    /**
     * 用函数式语言学习递归
     * 虽然用过程式语言也能学习递归，但哪怕掌握一点点函数式语言， 就能对理解递归有所裨益。在函数式语言里，用递归实现循环功能的 做法非常普遍。也就是说，用函数式语言编程基本上离不开递归。
     * LISP、Scheme、Haskell 等是代表性的函数式语言，此外使用 Scala、 Python 等也可以学习到函数式语言的特性。可以尝试把其他语言里的 循环用函数式语言的方式(不使用循环)来实现。
     * 熟悉了这种写法后，你会发现，用递归来实现循环应该就不困难 了。不过，反过来可能又会觉得把递归的写法转换成循环会比较难，所 以请务必多做一些这样的写法转换训练。
     */

    private static int[] OUTPUT_TYPE = {10, 50, 100, 500};

    public static List<List<Integer>> getPayInCashMy1(int number, int maxCount) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= Math.min(number / OUTPUT_TYPE[3], maxCount); i++) {
            for (int j = 0; j <= Math.min(number / OUTPUT_TYPE[2], maxCount); j++) {
                for (int k = 0; k <= Math.min(number / OUTPUT_TYPE[1], maxCount); k++) {
                    for (int l = 0; l <= Math.min(number / OUTPUT_TYPE[0], maxCount); l++) {
                        if (i + j + k + l <= maxCount && i * OUTPUT_TYPE[3] + j * OUTPUT_TYPE[2]
                                + k * OUTPUT_TYPE[1] + l * OUTPUT_TYPE[0] == number) {
                            List<Integer> list = new ArrayList<>();
                            list.add(i);
                            list.add(j);
                            list.add(k);
                            list.add(l);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }
}
