package com.liu.FunTestsOfProgrammer.test;


import static com.liu.FunTestsOfProgrammer.exercise.FT001_DecimalismPlalindrome.getDecimalismPlalindromeAnswer1;
import static com.liu.FunTestsOfProgrammer.exercise.FT001_DecimalismPlalindrome.getDecimalismPlalindromeMy1;

/**
 * Created by baidu on 2016/11/27.
 */
public class FT001_DecimalismPlalindromeTest {

    public static void main(String[] args) {
        int result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1();
        endTime = System.currentTimeMillis();
        System.out.println("MyDecimalismPlalindrome My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer1();
        endTime = System.currentTimeMillis();
        System.out.println("MyDecimalismPlalindrome Answer 1 result " + result + " during time " + (endTime - startTime));
    }

    private static int testMy1() {
        return getDecimalismPlalindromeMy1();
    }

    private static int testAnswer1() {
        return getDecimalismPlalindromeAnswer1();
    }
}
