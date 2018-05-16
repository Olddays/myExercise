package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 218/02/28.
 */
public class FT025_FashionOfShoelaces {
    /**
     * 即便系得很紧，鞋带有时候还是免不了会松掉。运动鞋的鞋带有很多时髦的系法。
     * 下面看看这些系法里，鞋带是如何穿过一个又一个鞋带孔的。
     * 如下所示的这几种依次穿过12个鞋带孔的系法很有名(这里不考虑鞋带穿过鞋带孔时是自外而内还是自内而外)。
     * 这里指定鞋带最终打结固定的位置如下中的前两种系法所示，即固定在最上方(靠近脚腕)的鞋带孔上，并交错使用左右的鞋带孔。
     * <p>
     * 问题：
     * 求鞋带交叉点最多时的交叉点个数。譬如下图左侧的系法是5个，正中间的这种系法是9个。
     * <p>
     * Hint:
     * 如何判定交叉是一个难点，可以先用较小的数字试验，看看在什么条件下会交叉吧。
     */

    // 思路：
    // 鞋带打结的两点已经固定,剩下的就是交错选择剩下的鞋带孔。从左侧开始选择有5!(5的阶乘)种选择方法,从右侧开始也有5!种。
    // 根据选择的顺序可以得到系法,这时,如何计算某一种系法的交叉点个数很关键。
    // 可以自上而下(从脚腕到脚尖的方向)为左侧和右侧的每一个鞋带孔标记0~5的数字,通过数字大小来判断是否交叉。
    // 举个例子,从左0到右1穿过的鞋带会跟从左1到右0穿过的鞋带交叉。也就是说,数字大小变化相反时会产生交叉点。
    //
    // 本题中两侧各 6 个鞋带孔,这时候计算可以在 1 秒之内完成。
    // 但如果两侧鞋带孔个数变为 7,那么计算时间将会超过 10 秒。如果再进一步增加个数,那花费的时间就会更多。
    // 那么能不能解决这个问题呢?事实上,如果改变鞋带孔的个数,你会发现答案的变化很有规律。
    // 两侧鞋带孔的个数分别是 2, 3, 4, ...时,对应的交叉点个数分别是 1, 6, 15, 28, 45, 66, ...。
    // 取交叉点个数之间的差,则是 5, 9, 13, 17, 21, ...。
    // 这些差值是一个等差数列,前后相邻两个数之间相差 4。像这样发现规律也是很重要的思考方式哦。
    public static int getFashionOfShoelacesMy1(int holeCount) {
        if (holeCount % 2 != 0) {
            return 0;
        }
        int singleCount = holeCount / 2;
        int maxCrossCount = 0;
        List<String> permutationList = new ArrayList<>();
        int[] input = new int[singleCount - 1];
        for (int i = 0; i < singleCount - 1; i++) {
            input[i] = i + 1;
        }
        getFullPermutation(permutationList, input, 0, singleCount - 1);
        for (String leftCode : permutationList) {
            for (String rightCode : permutationList) {
                char[] leftSide = leftCode.toCharArray();
                char[] rightSide = rightCode.toCharArray();
                List<int[]> pathCache = new ArrayList<>();
                int left = 0;
                int right = rightSide[0];
                for (int i = 0; i < singleCount - 1; i++) {
                    pathCache.add(new int[]{left, right});
                    left = leftSide[i];
                    pathCache.add(new int[]{left, right});
                    right = rightSide[(i + 1) % (singleCount - 1)];
                }
                pathCache.add(new int[]{left, 0});

                int cache = 0;
                for (int i = 0; i < pathCache.size(); i++) {
                    for (int j = i + 1; j < pathCache.size(); j++) {
                        if ((pathCache.get(i)[0] - pathCache.get(j)[0])
                                * (pathCache.get(i)[1] - pathCache.get(j)[1]) < 0) {
                            cache += 1;
                        }
                    }
                }
                maxCrossCount = Math.max(maxCrossCount, cache);
            }
        }
        return maxCrossCount;
    }

    private static void getFullPermutation(List<String> resultList, int[] input, int start, int end) {
        if (start == end - 1) {
            String cache = "";
            for (int i = 0; i < end; i++) {
                cache += input[i];
            }
            if (!resultList.contains(cache)) {
                resultList.add(cache);
            }
        } else {
            for (int i = start; i < end; i++) {
                int temp = input[start];
                input[start] = input[i];
                input[i] = temp;
                getFullPermutation(resultList, input, start + 1, end);
                temp = input[start];
                input[start] = input[i];
                input[i] = temp;
            }
        }
    }
}