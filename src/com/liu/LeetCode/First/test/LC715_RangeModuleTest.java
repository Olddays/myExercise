package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC715_RangeModule;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC715_RangeModuleTest {

    public static void main(String[] args) {
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        testAnswer1();
        endTime = System.currentTimeMillis();
        System.out.println("RangeModule Answer 1 during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        testAnswer2();
        endTime = System.currentTimeMillis();
        System.out.println("RangeModule Answer 2 during time " + (endTime - startTime));
    }

    private static void testAnswer1() {
        LC715_RangeModule.RangeModuleAnswer1 obj = new LC715_RangeModule.RangeModuleAnswer1();
        obj.removeRange(7, 8);
        obj.addRange(4, 10);
        boolean param = obj.queryRange(7, 8);
        param = obj.queryRange(5, 7);
        param = obj.queryRange(1, 8);
        obj.addRange(2, 6);
        obj.addRange(4, 6);
        obj.removeRange(3, 4);
        obj.removeRange(5, 7);
    }

    private static void testAnswer2() {
        LC715_RangeModule.RangeModuleAnswer2 obj = new LC715_RangeModule.RangeModuleAnswer2();
        obj.removeRange(7, 8);
        obj.addRange(4, 10);
        boolean param = obj.queryRange(7, 8);
        param = obj.queryRange(5, 7);
        param = obj.queryRange(1, 8);
        obj.addRange(2, 6);
        obj.addRange(4, 6);
        obj.removeRange(3, 4);
        obj.removeRange(5, 7);
    }
}
