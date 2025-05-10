package com.liu.LeetCode.Daily.Daily202504;

public class LC038_CountAndSay {

    // 看起来是个dp，因为countAndSay(n) is the run-length encoding of countAndSay(n - 1)
    // Beats 52.85%
    private static String countAndSayMy1(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char lastChar = dp[i - 1].charAt(0);
            for (char c : dp[i - 1].toCharArray()) {
                if (c == lastChar) {
                    count++;
                } else {
                    sb.append(count).append(lastChar);
                    lastChar = c;
                    count = 1;
                }
            }
            sb.append(count).append(lastChar);
            dp[i] = sb.toString();
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nList = new int[]{
                4,
                1,
        };
        String[] resultList = new String[]{
                "1211",
                "1",
        };
        String result;
        long startTime;
        long endTime;

        for (int i = 0; i < nList.length; i++) {
            startTime = System.currentTimeMillis();
            result = countAndSayMy1(nList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("countAndSay My1 result" + i + " " + result + " result check " + (result.equals(resultList[i]))
                    + " during time " + (endTime - startTime));
        }
    }
}
