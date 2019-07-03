package com.liu.LeetCode.First.test;


import static com.liu.LeetCode.First.exercise.LC001_TwoSum.getTwoSumMy1;

/**
 * Created by liu on 2017/9/6.
 */
public class LC001_TwoSumTest {

    // 思路:
    // 首先,我们明确最终结果是两个数字的和,那么就是要判断是哪两个数字,即:
    //      已知的关系为: a + b = target; a,b ∈ [输入集合]
    // 那么需要做的就是遍历集合,简单做法:
    //      遍历第一遍记录每个值与target的差值,差值生成一个新的数组命名为distance,时间复杂度为log(n),
    //  第二遍轮询遍历查找distance和input的相等项目,时间复杂度为log(n²)
    //      最终时间复杂度为log(n²)
    // 简化此方案:
    //      返回数据为满足条件的两个数字在输入集合中的位置,那么可以使用HashMap将input存储为这样的键值对{input item, input item's location},
    //  即{输入的数值, 数值的位置},此时第一遍遍历进行HashMap的构造,第二遍遍历只需要判断HashMap中是否存在target - input item的值即可
    //      最终时间复杂度为log(2n)
    // 进一步简化:
    //      在简化方案的基础上,target - input item这个判断其实可以在初始构造HashMap的时候来进行.
    //      最终时间复杂度为log(n)

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(nums, target);
        endTime = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            System.out.println("getTwoSum My 1 result" + i + " " + result[i] + " during time " + (endTime - startTime));
        }
    }

    private static int[] testMy1(int[] coins, int target) {
        return getTwoSumMy1(coins, target);
    }

}
