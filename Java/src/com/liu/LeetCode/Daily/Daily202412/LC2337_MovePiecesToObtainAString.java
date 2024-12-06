package com.liu.LeetCode.Daily.Daily202412;

/**
 * I am ignoring all the empty _ charcater,
 * <p>
 * As soon as targetCount encounter any character other then _ ,
 * Then the characters must be same,
 * <p>
 * if It is 'L'
 * then this condition must hold startCount >= targetCount , if in target string it found at index targetCount and , in st string it found at startCount
 * because we can move 'L' charcater to left , means left in st string ,
 * otherwise targetCount should return fase;
 * <p>
 * same with 'R'
 * then this condition must hold startCount <= targetCount , if in target string it found at index targetCount and , in st string it found at startCount
 * because we can move 'R' charcater to right ,means right in st string ,
 * otherwise targetCount should return false;
 * <p>
 * Time complexityO(N)
 * because every time either targetCount increase targetCount , or startCount , or both
 */

public class LC2337_MovePiecesToObtainAString {

    // 我的第一个思路是，L只能向左，R只能向右
    // 所以只要start里面的L的位置都大于等于target里面的L，且start里面的R的位置都小于等于target的位置就好
    private static boolean canChangeAnswer1(String start, String target) {
        int length = start.length();
        int startSpace = 0;
        int targetSpace = 0;
        while (startSpace <= length && targetSpace <= length) {
            while (startSpace < length && start.charAt(startSpace) == '_') { // 从左往右，缩进掉start左侧的_
                startSpace++;
            }
            while (targetSpace < length && target.charAt(targetSpace) == '_') { // 从左往右，缩进掉target左侧的_
                targetSpace++;
            }
            if (startSpace == length || targetSpace == length) { // 用于判断，如果start或者target已经到头的时候，是不是一起到头的，如果是，那么返回true
                return startSpace == length && targetSpace == length;
            }
            if (start.charAt(startSpace) != target.charAt(targetSpace)) { // 如果缩进了左侧的_后，发现不一样的字符，那么就false
                return false;
            }
            if (target.charAt(targetSpace) == 'L') { // 如果是L，那么start的位置必须大于等于target的位置，所以当小于的时候，返回false
                if (startSpace < targetSpace) {
                    return false;
                }
            } else { // 如果是R，那么start的位置必须小于等于target的位置，所以当大于的时候，返回false
                if (startSpace > targetSpace) {
                    return false;
                }
            }
            startSpace++; // 向前移动
            targetSpace++; // 向前移动
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str1List = new String[]{
                "_L__R__R_",
                "R_L_",
                "_R",
        };
        String[] str2List = new String[]{
                "L______RR",
                "__LR",
                "R_",
        };
        boolean result;
        long startTime;
        long endTime;

        for (int i = 0; i < str1List.length; i++) {
            startTime = System.currentTimeMillis();
            result = canChangeAnswer1(str1List[i], str2List[i]);
            endTime = System.currentTimeMillis();
            System.out.println("canChange Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
