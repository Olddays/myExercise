package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT019_SixDegreesOfSeparation {
    /**
     * “六度空间理论”非常有名。大概的意思是1个人只需要通过6个中间人就可以和世界上任何1个人产生间接联系。
     * 本题将试着找出数字的好友(这里并不考虑亲密指数)。
     * 假设拥有同样约数(不包括1)的数字互为“好友”,也就是说,如果两个数字的最大公约数不是1,那么称这两个数互为好友。
     * 从 1~N 中任意选取一个“合数”,求从它开始,要经历几层好友,
     * 才能和其他所有的数产生联系(所谓的“合数”是指“有除1以及自身以外的约数的自然数”)。
     * 举个例子,N = 10 时,1~10 的合数是 4、6、8、9、10 这 5 个。
     * 如果选取的是 10,那么 10 的好友数字就是公约数为 2 的 4、6、8这 3 个。
     * 而 9 是 6 的好友数字(公约数为 3),所以 10 只需要经过 2 层就可以和 9 产生联系( 图 5 )。
     * 如果选取的是 6,则只需经过 1 层就可以联系到 4、8、9、10 这些数字。
     * 因此 N = 10 时,无论最初选取的合数是什么,最多经过 2 层就可以与其他所有数产生联系。
     * <p>
     * 问题：
     * 求从 1~N 中选取 7 个合数时,最多经过 6 层就可以与其他所有数产生联系的最小的 N。
     * <p>
     * 思路：
     * 拥有共同约数的数字互为“好友”,那么就需要求最大公约数非 1 的情况。
     * 从 1~N 中选取 7 个合数,且“最多经过 6 层”,那么可以得知,我们要找的是“由 2 个数相乘得到的数字”的组合。
     * 这样的话,乘法运算中的这 2 个数就会成为公约数。举个例子,选出 a~h 这些数。
     * 简单地说就是,当 7 个数字分别是以下的形式时,经过 6 层就能与其他所有数产生联系。
     * a × b, b × c, c × d, d × e, e × f, f × g, g × h
     * ※这里 a~h 这些数字必须“互质”。
     */

    // 我们可以认为7个数字分别构成对应形式的时候要有6-9个互质的子元素存在，目前求的是最小情况，则使用6个的情况
    // 即：a × a, a × b, b × c, c × d, d × e, e × f, f × f
    public static int getSixDegreesOfSeparationMy1(int compositeNumCount, int layer) {
        if (compositeNumCount <= layer) {
            return 0;
        }
        List<Integer> primeNumList = new ArrayList<>();
        int target = 1;
        while (primeNumList.size() < layer - 1) {
            if (checkPrimeNum(target)) {
                primeNumList.add(target);
            }
            target++;
        }
        return primeNumList.get(layer - 2) * primeNumList.get(layer - 2);
    }

    private static boolean checkPrimeNum(int target) {
        for (int i = 2; i < target; i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}