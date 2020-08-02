package com.liu.LeetCode.ThirtyDays202006.test;

import static com.liu.LeetCode.ThirtyDays202006.exercise.TD16_ValidateIPAddress.validIPAddress;

/**
 * Created by Liu on 2020/6/16.
 */
public class TD16_ValidateIPAddress_Test {
    public static void main(String[] args) {
        String IP;
        String result;
        long startTime;
        long endTime;


        IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "01.01.01.01";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "172.16.254.1";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "172.16.254.1.";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "172.16.254.01";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "2001:db8:85a3:0:0:8A2E:0370:7334";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "2001:0db8:85a3::8A2E:0370:7334";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));

        IP = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
        startTime = System.currentTimeMillis();
        result = testMy1(IP);
        endTime = System.currentTimeMillis();
        System.out.println("TD16_ValidateIPAddress My 1 result: " + result + ", during time " + (endTime - startTime));
    }

    private static String testMy1(String IP) {
        return validIPAddress(IP);
    }
}
