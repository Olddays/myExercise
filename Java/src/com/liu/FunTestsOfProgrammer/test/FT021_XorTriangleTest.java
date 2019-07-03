package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT021_XorTriangle.getXorTriangleMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT021_XorTriangle.getXorTriangleMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT021_XorTriangleTest {

    public static void main(String[] args) {
        int[] indexSet = {
//                1,
//                1,
//                2,
//                3,
//                4,
                180,
                2014,
                2014,
        };
        int[] targetSet = {
//                1,
//                0,
//                0,
//                0,
//                0,
                0,
                0,
                1,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < indexSet.length; i++) {
            int index = indexSet[i];
            int target = targetSet[i];

            startTime = System.currentTimeMillis();
            result = testMy1(index, target);
            endTime = System.currentTimeMillis();
            System.out.println("XorTriangle My 1 result " + result + " during time " + (endTime - startTime));

            startTime = System.currentTimeMillis();
            result = testMy2(index, target);
            endTime = System.currentTimeMillis();
            System.out.println("XorTriangle My 2 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static int testMy1(int index, int target) {
        return getXorTriangleMy1(index, target);
    }

    private static int testMy2(int index, int target) {
        return getXorTriangleMy2(index, target);
    }
}
