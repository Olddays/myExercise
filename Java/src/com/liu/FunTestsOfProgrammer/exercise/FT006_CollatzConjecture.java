package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2018/02/28.
 */
public class FT006_CollatzConjecture {
    /**
     * “考拉兹猜想”是一个数学上的未解之谜。
     * 对自然数 n 循环执行如下操作。 ·n 是偶数时，用 n 除以 2
     * ·n 是奇数时，用 n 乘以 3 后加 1
     * 如此循环操作的话，无论初始值是什么数字，最终都会得到 1(会进入 1 → 4 → 2 → 1 这个循环)。
     * <p>
     * 这里我们稍微修改一下这个猜想的内容，即假设初始值为偶数时， 也用 n 乘以 3 后加 1，但只是在第一次这样操作，后面的循环操作不变。 而我们要考虑的则是在这个条件下最终又能回到初始值的数。
     * 譬如，以 2 为初始值，则计算过程如下。 2 → 7 → 22 → 11 → 34 → 17 → 52 → 26 → 13 → 40 → 20 → 10 → 5 →  16 → 8 → 4 → 2
     * 同样，如果初始值为 4，则计算过程如下。 4 → 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4
     * 但如果初始值为 6，则计算过程如下，并不能回到初始值 6。 6 → 19 → 58 → 29 → 88 → 44 → 22 → 11 → 34 → 17 → 52 → 26 → 13  → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 → 4 → ...
     * <p>
     * 问题
     * 求在小于 10000 的偶数中，像上述的 2 或者 4 这样“能回到初始值的数”有 多少个。
     * Hint
     * 如果计算得到了1或者初始值，就可以结束循环了。
     */

    public static int getCollatzConjectureMy1(int maxCount) {
        int result = 0;
        for (int i = 0; i <= maxCount; i += 2) {
            int cache = i * 3 + 1;
            while (cache != i && cache != 1) {
                if (cache % 2 == 1) {
                    cache = cache * 3 + 1;
                } else {
                    cache = cache / 2;
                }
            }
            if (cache == i) {
                result++;
            }
        }
        return result;
    }
}
