package com.liu.FunTestsOfProgrammer.exercise;

import java.util.*;

/**
 * Created by liu on 218/02/28.
 */
public class FT013_LettersFormulaSatisfyCount {
    /**
     * 所谓字母算式，就是用字母表示的算式，规则是相同字母对应相同数字，不同字母对应不同数字，并且第一位字母的对应数字不能是 0。
     * 譬如给定算式 We×love＝ CodeIQ，则可以对应填上下面这些数字以使之成立。
     * W ＝ 7, e ＝ 4, l ＝ 3, o ＝ 8, v ＝ 0, C ＝ 2, d ＝ 1, I ＝ 9, Q ＝ 6
     * 这样一来，我们就能得到74×3804 ＝ 281496 这样的等式。
     * 使前面那个字母算式成立的解法只有这一种。
     * <p>
     * 问题:
     * 求使下面这个字母算式成立的解法有多少种？
     * READ ＋ WRITE ＋ TALK ＝ SKILL
     * Hint:
     * 现在计算机的运算能力很强，可以通过简单穷举的办法来解决的问题也越来越多。
     * 不过编写程序最好在可复用性、计算速度等方面多下 些工夫。
     */

    private static class Equation {
        List<Character> character;
        List<String> parameters;
        List<Character> symbol;
        String equal;

        Equation(List<Character> character, List<String> parameters,
                 List<Character> symbol, String equal) {
            this.character = character;
            this.parameters = parameters;
            this.symbol = symbol;
            this.equal = equal;
        }

        @Override
        public String toString() {
            return "character: " + character + ", parameters: " + parameters
                    + ", symbol: " + symbol + ", equal: " + equal;
        }
    }

    public static class Result {
        String originString;
        int result;
        Map<String, Integer> wordMap;

        Result(String originString, int result, Map<String, Integer> wordMap) {
            this.originString = originString;
            this.result = result;
            this.wordMap = wordMap;
        }

        @Override
        public String toString() {
            return "originString: " + originString + ", result: " + result
                    + ", wordMap: " + wordMap;
        }
    }

    public static Result getLettersFormulaSatisfyCountMy1(String equation) {
        Equation equationInstance = getEquationInstance(equation);
        if (equationInstance == null) {
            return null;
        }
        System.out.println(equationInstance.toString());
        boolean[] useableIndex = new boolean[10];
        int[] numSet = new int['Z' - 'A'];
        // 加个字母全排列的函数 返回一个list
        getFullPermutation(equationInstance.character);
        Map<String, Integer> wordMap = new HashMap<>();
        int result = 0;
        int parameterSize = equationInstance.parameters.size();
        List<int[]> cache = new ArrayList<>();
        int[] possible = new int[parameterSize + 1];
        for (int i = 0; i < parameterSize + 1; i++) {
            String target;
            if (i == parameterSize) {
                target = equationInstance.equal;
            } else {
                target = equationInstance.parameters.get(i);
            }
            char[] parameterSet = target.toCharArray();
            int charSize = parameterSet.length;
            int num = 1;
            for (char parameter : parameterSet) {
                num *= numSet[parameter - 'A'] * Math.pow(10, charSize);
            }
            possible[i] = num;
        }
        return new Result(equation, result, wordMap);
    }

    public static Result getLettersFormulaSatisfyCountMy2(String equation) {
        Map<String, Integer> wordMap = new HashMap<>();
        int result = 0;
        return new Result(equation, result, wordMap);
    }

    private static List<Map<Character, Integer>> getFullPermutation(List<Character> list) {
        arrangementSelect(new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        }, list.size());
        return null;
    }

    private static Equation getEquationInstance(String equation) {
        if (!equation.contains("=")) {
            return null;
        }
        String[] parts = equation.toUpperCase()
                .replaceAll(" ", "").split("=");
        String equal = parts[1];
        char[] leftParts = parts[0].toCharArray();
        List<Character> character = new ArrayList<>();
        List<String> parameter = new ArrayList<>();
        List<Character> symbol = new ArrayList<>();
        String cache = "";
        for (char c : leftParts) {
            if (c <= 'Z' && c >= 'A') {
                if (!character.contains(c)) {
                    character.add(c);
                }
                cache += c;
            } else {
                parameter.add(cache);
                cache = "";
                symbol.add(c);
            }
        }
        char[] rightParts = equal.toCharArray();
        for (char c : rightParts) {
            if (c <= 'Z' && c >= 'A') {
                if (!character.contains(c)) {
                    character.add(c);
                }
            }
        }
        parameter.add(cache);
        if (parameter.size() != symbol.size() + 1
                || character.size() > 10) {
            // 一个字母一个数字，不可重复，且数字为0-9，共十个
            return null;
        }
        return new Equation(character, parameter, symbol, equal);
    }

    /**
     * 排列选择（从列表中选择n个排列）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void arrangementSelect(String[] dataList, int n) {
        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, arrangement(dataList.length, n)));
        arrangementSelect(dataList, new String[n], 0);
    }

    /**
     * 排列选择
     *
     * @param dataList    待选列表
     * @param resultList  前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex + 1);
            }
        }
    }

    /**
     * 组合选择（从列表中选择n个组合）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, combination(dataList.length, n)));
        combinationSelect(dataList, 0, new String[n], 0);
    }

    /**
     * 组合选择
     *
     * @param dataList    待选列表
     * @param dataIndex   待选开始索引
     * @param resultList  前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    public static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     *
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     *
     * @param n
     * @param m
     * @return
     */
    public static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
}
