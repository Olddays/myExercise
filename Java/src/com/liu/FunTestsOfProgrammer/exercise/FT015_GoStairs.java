package com.liu.FunTestsOfProgrammer.exercise;

/**
 * Created by liu on 218/02/28.
 */
public class FT015_GoStairs {
    /**
     * A 上楼梯时，B 从同一楼梯往下走。每次不一定只走1级，最多可以一次跳过 3 级（即直接前进 4 级）。
     * 但无论走多少级，1次移动所需时间不变。两人同时开始走，求共有多少种“两人最终同时停在同一级” 的情况
     * （假设楼梯宽度足够，可以相互错开，不会撞上。另外，同时到达同一级时视为结束）。
     * 举个例子，如图1所示，有4级楼梯的时候，结果如表3所示，共有4种情况（假设每级楼梯上写着0~4这几个数字）。
     * <p>
     * 表3 有4级楼梯时
     * ID A B 移动方法
     * (1) 0→1→2 4→3→2 A和B都一次走1级楼梯
     * (2) 0→1 4→1 A移动1级，B跳过2级
     * (3) 0→2 4→2 A和B都跳过1级
     * (4) 0→3 4→3 A跳过2级，B跳过1级
     * <p>
     * 问题：
     * 求当存在 10 级楼梯，且移动规则相同时，有多少种两人最终同时停在同一级的情况？
     */

    public static int getGoStairsMy1(int stairSize, int[] usableSteps) {
        return checkUsableStep(0, 0, stairSize, usableSteps);
    }

    private static int checkUsableStep(int count, int left, int right, int[] usableSteps) {
        if (left == right) {
            return count + 1;
        } else if (left > right) {
            return count;
        } else {
            for (int leftStep : usableSteps) {
                left += leftStep;
                for (int rightStep : usableSteps) {
                    right -= rightStep;
                    count = checkUsableStep(count, left, right, usableSteps);
                    right += rightStep;
                }
                left -= leftStep;
            }
        }
        return count;
    }

    // 两人同时到达某一个台阶，可以等价为“一个人经过偶数次移动到达相反的位置”
    // 此时可以使用单数组的动态规划来处理
    public static int getGoStairsMy2(int stairSize, int[] usableSteps) {
        int[] dynamicCache = new int[stairSize + 1];
        dynamicCache[stairSize] = 1;
        int result = 0;
        for (int i = 0; i < stairSize; i++) {
            for (int j = 0; j < stairSize + 1; j++) {
                for (int step : usableSteps) {
                    if (step > j) {
                        break;
                    }
                    dynamicCache[j - step] += dynamicCache[j];
                }
                dynamicCache[j] = 0;
            }
            if (i % 2 == 1) {
                result += dynamicCache[0];
            }
        }
        return result;
    }
}
