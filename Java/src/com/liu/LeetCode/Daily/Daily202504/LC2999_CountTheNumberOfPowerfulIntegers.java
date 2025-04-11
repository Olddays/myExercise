package com.liu.LeetCode.Daily.Daily202504;

public class LC2999_CountTheNumberOfPowerfulIntegers {
    // 逻辑本身比较清晰，重点是如何加快比较的速度
    // 因为limit的存在，不能直接相减，要分别计算再相减
    private static long numberOfPowerfulIntMyError1(long start, long finish, int limit, String s) {
        long sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            int cache = s.charAt(i) - '0';
            if (cache > limit) {
                return 0;
            }
        }
        long sNum = Integer.parseInt(s);
        if (finish < sNum) {
            return 0;
        }
        int result = 0;
        if (start <= sNum) {
            start = sNum;
            result++;
        }
        long permutation = (long) Math.pow(10, sLength);
        long cache = (finish - start) / permutation;
        int pow = 0;
        while (cache > 0) {
            long num = cache % 10;
            cache = cache / 10;
            result += Math.min(limit, num) * (long) Math.pow(limit + 1, pow); // +1是因为算上0
            pow++;
        }
        return result;
    }

    // 边界问题无法处理，核心是通过permutation把后续的内容都省略了
    private static long numberOfPowerfulIntMyError2(long start, long finish, int limit, String s) {
        long sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            int cache = s.charAt(i) - '0';
            if (cache > limit) {
                return 0;
            }
        }
        long sNum = Integer.parseInt(s);
        if (finish < sNum) {
            return 0;
        }
        int result = 0;
        long permutation = (long) Math.pow(10, sLength);
        long cache = finish / permutation;
        int pow = 0;
        while (cache > 0) {
            long num = cache % 10;
            cache = cache / 10;
            result += Math.min(limit, num) * (long) Math.pow(limit + 1, pow); // +1是因为算上0
            pow++;
        }
        cache = (start - 1) / permutation;
        pow = 0;
        while (cache > 0) {
            long num = cache % 10;
            cache = cache / 10;
            result -= Math.min(limit, num) * (long) Math.pow(limit + 1, pow); // +1是因为算上0
            pow++;
        }
        return result;
    }

    // 改成DP来存储
    // Beats 76.06%
    private static long numberOfPowerfulIntMy1(long start, long finish, int limit, String s) {
        return numberOfPowerfulIntMy1Helper(finish, limit, s)
                - numberOfPowerfulIntMy1Helper(start - 1, limit, s);
    }

    private static long numberOfPowerfulIntMy1Helper(long chakraCap, int chakraLimit, String clanSymbol) {
        String chakraFlow = Long.toString(chakraCap);  // The full chakra path
        int prefixLength = chakraFlow.length() - clanSymbol.length();

        // If the chakra flow is too short to even hold the clan symbol – mission fails
        if (prefixLength < 0) {
            return 0;
        }

        long[][] rasenganScroll = new long[prefixLength + 1][2]; // [i][tightMode]

        // Base case: chakra prefix is complete; now check if the suffix meets the clan symbol
        rasenganScroll[prefixLength][0] = 1; // Not bound to chakraCap
        rasenganScroll[prefixLength][1] = chakraFlow.substring(prefixLength).compareTo(clanSymbol) >= 0 ? 1 : 0;

        // Iterate backward like a careful strategist
        for (int i = prefixLength - 1; i >= 0; i--) {
            int currentChakra = chakraFlow.charAt(i) - '0';

            // If not tight to chakraCap, any digit from 0 to chakraLimit is okay
            rasenganScroll[i][0] = (chakraLimit + 1) * rasenganScroll[i + 1][0];

            // If we're still under chakraCap, be careful
            if (currentChakra <= chakraLimit) {
                rasenganScroll[i][1] = (long) currentChakra * rasenganScroll[i + 1][0] + rasenganScroll[i + 1][1];
            } else {
                rasenganScroll[i][1] = (long) (chakraLimit + 1) * rasenganScroll[i + 1][0];
            }
        }

        return rasenganScroll[0][1];
    }

    public static void main(String[] args) {
        long[] startList = new long[]{
                1,
                1,
                20,
                1,
                1829505,
                15,
                1000,
        };
        long[] finishList = new long[]{
                2000,
                971,
                1159,
                6000,
                1255574165,
                215,
                2000,
        };
        int[] limitList = new int[]{
                8,
                9,
                5,
                4,
                7,
                6,
                4,
        };
        String[] sList = new String[]{
                "1",
                "72",
                "20",
                "124",
                "11223",
                "10",
                "3000",
        };
        int[] resultList = new int[]{
                162,
                9,
                8,
                5,
                5470,
                2,
                0,
        };
        long result;
        long startTime;
        long endTime;

        for (int i = 0; i < startList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numberOfPowerfulIntMy1(startList[i], finishList[i], limitList[i], sList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("minOperations My1 result" + i + " " + result + " result check " + (result == resultList[i])
                    + " during time " + (endTime - startTime));
        }
    }
}
