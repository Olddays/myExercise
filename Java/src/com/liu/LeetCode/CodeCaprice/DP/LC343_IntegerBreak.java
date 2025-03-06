package com.liu.LeetCode.CodeCaprice.DP;

public class LC343_IntegerBreak {

    // m个数字尽可能相等结果才尽可能大
    // dp[i]就是n为i时的最大乘积
    // dp关系，以10为例，dp[10] = max(dp[1] * dp[9], dp[2] * dp[8], ..., dp[5] * dp[5])
    // 因为，10可以拆成2和8，那就和2、8的状态有关，8可以拆成2和6，那就和2、6的状态有关，6可以拆成2和4，那就和2、4的状态有关，4可以拆成2和2，那就和2、2的状态有关
    // 那么dp[10]=dp[3]*dp[7]=dp[3]*dp[3]*dp[4]
    // Beats 41.03%
    private static int integerBreakMy1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0; // dp0和dp1无意义
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    // 寻找合适的数据的方式是错误的
    private static int integerBreakMy2(int n) {
        double s = Math.sqrt(n);
        int count = (int) s;
        if (s - count > 0.5) {
            count++;
        }
        int sum = 0;
        int result = 1;
        for (int i = 0; i < count - 1; i++) {
            sum += count;
            result = count * result;
        }
        result = (n - sum) * result;
        return result;
    }

    // 3*(pi-3) > pi which happens if pi > 4.5.
    // 在n大于5的情况下，3要比2大，所以尽量多的拆成3，因为最终都只会拆成一系列的2和3
    // 也就是 n = a3 + b2 所以 P = (3^a) * (2^b) 是最大34
    private static int integerBreakAnswer1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                4,
                10,
                2,
                3,
                45,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = integerBreakMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("integerBreak My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = integerBreakMy2(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("integerBreak My2 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = integerBreakAnswer1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("integerBreak Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
