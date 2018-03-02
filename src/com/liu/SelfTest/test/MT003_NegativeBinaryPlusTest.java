package com.liu.SelfTest.test;


import static com.liu.SelfTest.exercise.MT003_NegativeBinaryPlus.*;

/**
 * Created by liu on 2016/11/27.
 */
public class MT003_NegativeBinaryPlusTest {

    public static void main(String[] args) {
        int[][] inputList = new int[][]{
                {0}, // 0
                {1}, // 1
                {0, 1, 1}, // 2
                {1, 1, 1}, // 3
                {0, 0, 1}, // 4
                {1, 0, 1}, // 5
                {0, 1, 0, 1, 1}, // 6
                {1, 1, 0, 1, 1}, // 7
                {0, 0, 0, 1, 1}, // 8
                {1, 0, 0, 1, 1}, // 9
                {0, 1, 1, 1, 1}, // 10
                {1, 1, 1, 1, 1}, // 11
                {0, 0, 1, 1, 1}, // 12
                {1, 0, 1, 1, 1}, // 13
                {0, 1, 0, 0, 1}, // 14
                {1, 1, 0, 0, 1}, // 15
                {0, 0, 0, 0, 1}, // 16
                {1, 0, 0, 0, 1}, // 17
                {0, 1, 1, 0, 1}, // 18
                {1, 1, 1, 0, 1}, // 19
                {0, 0, 1, 0, 1}, // 20
                {1, 0, 1, 0, 1}, // 21
                {0, 1, 0, 1, 0, 1, 1}, // 22
                {1, 1, 0, 1, 0, 1, 1}, // 23
                {0, 0, 0, 1, 0, 1, 1}, // 24
                {1, 0, 0, 1, 0, 1, 1}, // 25
                {0, 1, 1, 1, 0, 1, 1}, // 26
                {1, 1, 1, 1, 0, 1, 1}, // 27
                {0, 0, 1, 1, 0, 1, 1}, // 28
                {1, 0, 1, 1, 0, 1, 1}, // 29
                {0, 1, 0, 0, 0, 1, 1}, // 30
                {1, 1, 0, 0, 0, 1, 1}, // 31
                {0, 0, 0, 0, 0, 1, 1}, // 32
                {1, 0, 0, 0, 0, 1, 1}, // 33
        };
        int[] result;
        long startTime;
        long endTime;

        for (int i = 0; i < inputList.length - 1; i++) {
            int[] input = inputList[i];
            startTime = System.currentTimeMillis();
            result = testAnswer1(input);
            endTime = System.currentTimeMillis();
            System.out.println("NumberDegree Answer 1 result.length " + result.length + " during time " + (endTime - startTime));
            for (int output : result) {
                System.out.print(output + " ");
            }
            System.out.print("check result " + checkResult(inputList[i + 1], result));
            System.out.println();
        }
    }

    private static int[] testAnswer1(int[] input) {
        return getNegativeBinaryPlusAnswer1(input);
    }

    private static boolean checkResult(int[] input, int[] output) {
        if (input.length == output.length) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != output[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
