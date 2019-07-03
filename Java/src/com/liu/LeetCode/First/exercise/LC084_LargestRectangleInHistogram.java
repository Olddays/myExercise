package com.liu.LeetCode.First.exercise;

import java.util.Stack;

/**
 * Created by liu on 2017/9/30.
 */
public class LC084_LargestRectangleInHistogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     * <p>
     * <p>
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     * <p>
     * <p>
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     * <p>
     * For example,
     * Given heights = [2,1,5,6,2,3],
     * return 10.
     */

    // 没有考虑输入的heights.length只有1的时候
    public static int getLargestRectangleInHistogramMy1(int[] heights) {
        int result = 0;
        int length = heights.length;
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < length - 1; i++) {
            int cache = Math.min(heights[i], heights[i + 1]) * 2;
            result = Math.max(cache, result);
        }
        return result;
    }

    // 没有考虑输入为[0,9]的情况
    public static int getLargestRectangleInHistogramMy2(int[] heights) {
        int result = 0;
        int length = heights.length;
        if (length == 0) {
            return result;
        } else if (length == 1) {
            return heights[0];
        }
        for (int i = 0; i < length - 1; i++) {
            int cache = Math.min(heights[i], heights[i + 1]) * 2;
            result = Math.max(cache, result);
        }
        return result;
    }

    // 算法本身是正确的,但是时间复杂度太高,方法使用的是全排列进行遍历的方式,时间复杂度的确会比较高
    public static int getLargestRectangleInHistogramMy3(int[] heights) {
        int result = 0;
        int length = heights.length;
        if (length == 0) {
            return result;
        }
        int[][] cache = new int[length][length];
        // 暂存取值从1到length-1的情况下的数据情况,最后的列表应该是从左上到右下的斜对角线分割的形式,且对角线下方全部为0
        System.arraycopy(heights, 0, cache[0], 0, length);
        for (int i = 1; i < length; i++) { // 初始化第i行的数据
            for (int j = i; j < length; j++) {
                int minCache = Integer.MAX_VALUE;
                for (int k = j; k >= j - i; k--) {
                    minCache = Math.min(minCache, heights[k]);
                }
                cache[i][j] = minCache;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                result = Math.max(result, cache[i][j] * (i + 1));
            }
        }
        for (int[] root : cache) {
            for (int n : root) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return result;
    }

    // 此解决方案使用了栈的方式来处理
    // Two key points that I found helpful while understanding the solution:
    //  Do push all heights including 0 height.
    //  i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >= height[tp], because the index on top of the stack right now is the first index left of tp with height smaller than tp's height.
    public static int getLargestRectangleInHistogramAnswer1(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int height = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || height >= heights[s.peek()]) {
                // 判断partMax是否比之前的partMax大,如果大则压栈
                s.push(i);
            } else {
                int tp = s.pop();
                // 对于i - 1 - s.peek(),其中i-1不用解释,就是说当前往前走一个,s.peek()是指往前走第一个与当前位置不一样高的的位置,也就是i-1-s.peek()是指我们针对当前高度能有多少的长度,而由于我们保证了接下来的高度肯定大于当前高度,所以后续位置不用考虑
                // 当前height的局部最大值必然是当前高度与target的乘积,但当s是空时说明dp-1的高度必然大于等于dp,此时可以直接用height[dp]*i来表示局部最大值
                int partMax = heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, partMax);
                i--;
            }
        }
        return maxArea;
    }

    public static int getLargestRectangleInHistogramAnswer2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        // The main trick is how to effectively calculate lessFromRight and lessFromLeft arrays. The trivial solution is to use O(n^2) solution and for each i element first find his left/right heighbour in the second inner loop just iterating back or forward:
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            // The only line change shifts this algorithm from O(n^2) to O(n) complexity: we don't need to rescan each item to the left - we can reuse results of previous calculations and "jump" through indices in quick manner:
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        // For any bar i the maximum rectangle is of width r - l - 1 where r - is the last coordinate of the bar to the right with height h[r] >= h[i] and l - is the last coordinate of the bar to the left which height h[l] >= h[i]
        // So if for any i coordinate we know his utmost higher (or of the same height) neighbors to the right and to the left, we can easily find the largest rectangle:
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}
