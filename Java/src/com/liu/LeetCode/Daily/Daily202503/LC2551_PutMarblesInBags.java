package com.liu.LeetCode.Daily.Daily202503;

import java.util.Arrays;

public class LC2551_PutMarblesInBags {

    // dp问题，类似背包，或者说背包的变形
    // 看起来是一个O(nk)的dp问题，但实际上应该是一个在数组中寻找k个最大值和最小值的问题
    // 因为最终的结果是最大值和最小值的差，所以我们只需要找到k个最大值和最小值即可
    // 当进行切分后，我们最后切成k份，也就是k-1个切割点，也就是i1到ik-1
    // A[0]...A[i1]
    // A[i1+1]....A[i2]
    // A[i2+1]....A[i3]
    // ....
    // A[i(k-1)+1]....A[n-1]
    // 这些数据的和就是
    // A[0] + A[i1] + A[i1+1] + A[i2] + A[i2+1] + ... + A[i(k-1)+1] +A[i(k-1)+1] + A[n-1]
    // 那么就是
    // A[0] + (A[i1] + A[i1+1]) + (A[i2] + A[i2+1]) + ... + (A[i(k-1)] +A[i(k-1)+1]) + A[n-1]
    // 那么问题就等于
    // 在如下的新数组中，找到最大的k-1个值的和，减去最小的k-1个值的和
    // A[0] + A[1], A[1] + A[2],..., A[n-1] + A[n].
    // 因为每次分割，都一定有一个分割点，这个分割点的左右两侧必然是A[i]和A[i+1]，所以我们可以把A[i]和A[i+1]合并成一个值，然后再进行分割，而最左最右不用关注因为最后计算相减的时候会消除掉
    // Beats 35.82%
    private static long putMarblesMy1(int[] weights, int k) {
        int length = weights.length;
        long[] cache = new long[length - 1];
        long result = 0;
        for (int i = 0; i < length - 1; i++) {
            cache[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(cache);
        for (int i = 0; i < k - 1; i++) {
            result += cache[length - 2 - i] - cache[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] weightsSet = new int[][]{
                {1, 3, 5, 1},
                {1, 3},
        };
        int[] kSet = new int[]{
                2,
                2,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < weightsSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = putMarblesMy1(weightsSet[i], kSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("putMarbles My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
