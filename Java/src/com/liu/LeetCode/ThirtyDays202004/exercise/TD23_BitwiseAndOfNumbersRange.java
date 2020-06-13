package com.liu.LeetCode.ThirtyDays202004.exercise;

/**
 * Created by Liu on 2020/4/23.
 */
public class TD23_BitwiseAndOfNumbersRange {// An efficient Java program to find bit-wise
    // & of all numbers from x to y.

    // Find position of MSB in n. For example
    // if n = 17, then position of MSB is 4.
    // If n = 7, value of MSB is 3
    private static int msbPos(int num) {
        int msb_p = -1;
        while (num > 0) {
            num = num >> 1;
            msb_p++;
        }
        return msb_p;
    }

    // Function to find Bit-wise & of all
    // numbers from x to y.
    public static int rangeBitwiseAndAnswer1(int m, int n) {

        int res = 0; // Initialize result

        while (m > 0 && n > 0) {

            // Find positions of MSB in x and y
            int msb_p1 = msbPos(m);
            int msb_p2 = msbPos(n);

            // If positions are not same, return
            if (msb_p1 != msb_p2)
                break;

            // Add 2^msb_p1 to result
            int msb_val = (1 << msb_p1);
            res = res + msb_val;

            // subtract 2^msb_p1 from x and y.
            m = m - msb_val;
            n = n - msb_val;
        }

        return res;
    }


    public static int rangeBitwiseAndMy1(int m, int n) {
        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result &= i;
        }
        return result;
    }

    public static int rangeBitwiseAndMy2(int m, int n) {
        int result = 0;
        while (m > 0 && n > 0) {
            int msbM = msbPos(m);
            int msbN = msbPos(n);

            if (msbM != msbN) {
                break;
            }

            int msbVal = (1 << msbM);
            result = result + msbVal;

            m = m - msbVal;
            n = n - msbVal;
        }
        return result;
    }
}
