package com.liu.LeetCode.Daily.Daliy202506;

import com.liu.LeetCode.common.tools.Utils;

public class LC2929_DistributeCandiesAmongChildrenII {

    // 每个孩子可能拿到0到limit个糖，核心是这些糖加起来是n
    private static long distributeCandiesMy1(int n, int limit) {
        long result = 0;
        for (long x = Math.max(0, n - 2L * limit); x <= Math.min(n, limit); x++) {
            long y_st = Math.max(0, n - limit - x);
            long y_en = Math.min(n - x, limit);

            if (y_st <= y_en) {
                result += (y_en - y_st + 1);
            }
        }
        return result;
    }

    private static long distributeCandiesMy2(int n, int limit) {
        long total = (long) (n + 2) * (n + 1) / 2; // 针对x+y+z=n的情况下，最多有这么多种可能性
        long x1 = n - limit - 1; // 假设x = limit + 1 + a，那么在a y z的组合中a+y+z = n-limit-1，那么y和z的组合数就是C（n - limit - 1 + 2，2）
        long t1 = 0;
        if (x1 >= 0) { // t1也就是在y+z = n-limit+1的 y和z的组合数
            t1 = (x1 + 2) * (x1 + 1) / 2; // 也就是计算当仅有一个孩子超过limit的情况，所以有三个最后要乘3
        }
        long x2 = n - (long) 2 * limit - 2; // 假设x = limit + 1 + a，且 y = limit + 1 + b，那么在a b z的组合中a+b+z = n-2limit-2
        long t2 = 0;
        if (x2 >= 0) {
            t2 = (x2 + 2) * (x2 + 1) / 2; // 也就是计算当有两个孩子超过limit的情况，所以有三个情况最后要乘3，加回来，是因为t1已经包含了t2
            // 具体来说，t1包含了两次t2，因为当ab都超出时，在t1的视角下会计算一次a再计算一次b
        }
        long x3 = n - (long) 3 * limit - 3;
        long t3 = 0;
        if (x3 >= 0) {
            t3 = (x3 + 2) * (x3 + 1) / 2; // 也就是计算三个孩子都超过，那么此时就一种情况
        }
        return total - 3 * t1 + 3 * t2 - t3;
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                5,
                3,
        };
        int[] limitList = new int[]{
                2,
                3,
        };
        long[] resultList = new long[]{
                3,
                10,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = distributeCandiesMy1(nList[i], limitList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("distributeCandies My1 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = distributeCandiesMy2(nList[i], limitList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("distributeCandies My2 result" + i + " " + result + " result check " + Utils.compareResult(result, resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
