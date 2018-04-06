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
        List<List<Character>> parameters;
        List<Character> symbol;
        List<Character> equal;

        Equation(List<Character> character, List<List<Character>> parameters,
                 List<Character> symbol, List<Character> equal) {
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
        Map<String, Integer> wordMap;

        Result(String originString, Map<String, Integer> wordMap) {
            this.originString = originString;
            this.wordMap = wordMap;
        }

        @Override
        public String toString() {
            return "originString: " + originString + ", wordMap: " + wordMap;
        }
    }

    public static Result getLettersFormulaSatisfyCountMy1(String equation) {
        Equation equationInstance = getEquationInstance(equation);
        if (equationInstance == null) {
            return null;
        }
        List<Map<Character, Integer>> charMapList = getFullPermutation(equationInstance.character);
        Map<String, Integer> wordMap = new HashMap<>();
        int parameterSize = equationInstance.parameters.size();
        for (Map<Character, Integer> map : charMapList) {
            int[] possible = new int[parameterSize + 1];

            for (int i = 0; i < parameterSize + 1; i++) {
                List<Character> target;
                if (i == parameterSize) {
                    target = equationInstance.equal;
                } else {
                    target = equationInstance.parameters.get(i);
                }
                int charSize = target.size() - 1;
                int num = 0;
                for (char parameter : target) {
                    num += map.get(parameter) * Math.pow(10, charSize--);
                }
                possible[i] = num;
            }
            boolean equal = checkFunction(possible, equationInstance.symbol);
            if (equal) {
                for (int i = 0; i < possible.length; i++) {
                    String key = "";
                    for (char c : equationInstance.parameters.get(i)) {
                        key += c;
                    }
                    wordMap.put(key, possible[i]);
                }
            }
        }
        return new Result(equation, wordMap);
    }

    public static Result getLettersFormulaSatisfyCountMy2(String equation) {
        Map<String, Integer> wordMap = new HashMap<>();
        return new Result(equation, wordMap);
    }

    private static List<Map<Character, Integer>> getFullPermutation(List<Character> list) {
        List<List<String>> indexList = new ArrayList<>();
        String[] originalSet = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        getArrangeSelect(indexList, new ArrayList<>(), originalSet, list.size(), 0);
        List<List<Character>> charList = new ArrayList<>();
        Character[] set = list.toArray(new Character[list.size()]);
        getTotalArrange(charList, set, list.size(), 0);

        List<Map<Character, Integer>> result = new ArrayList<>();

        for (List<String> index : indexList) {
            for (List<Character> chars : charList) {
                Map<Character, Integer> cache = new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    cache.put(chars.get(i), Integer.valueOf(index.get(i)));
                }
                result.add(cache);
            }
        }
        return result;
    }

    private static Equation getEquationInstance(String equation) {
        if (!equation.contains("=")) {
            return null;
        }
        String[] parts = equation.toUpperCase()
                .replaceAll(" ", "").split("=");
        List<Character> equal = new ArrayList<>();
        for (int i = 0; i < parts[1].length(); i++) {
            equal.add(parts[1].charAt(i));
        }
        char[] leftParts = parts[0].toCharArray();
        List<Character> character = new ArrayList<>();
        List<List<Character>> parameter = new ArrayList<>();
        List<Character> symbol = new ArrayList<>();
        String cache = "";
        for (char c : leftParts) {
            if (c <= 'Z' && c >= 'A') {
                if (!character.contains(c)) {
                    character.add(c);
                }
                cache += c;
            } else {
                List<Character> list = new ArrayList<>();
                for (int i = 0; i < cache.length(); i++) {
                    list.add(cache.charAt(i));
                }
                parameter.add(list);
                cache = "";
                symbol.add(c);
            }
        }
        for (char c : equal) {
            if (c <= 'Z' && c >= 'A') {
                if (!character.contains(c)) {
                    character.add(c);
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < cache.length(); i++) {
            list.add(cache.charAt(i));
        }
        parameter.add(list);
        if (parameter.size() != symbol.size() + 1
                || character.size() > 10) {
            // 一个字母一个数字，不可重复，且数字为0-9，共十个
            return null;
        }
        return new Equation(character, parameter, symbol, equal);
    }

    private static <T> void getArrangeSelect(List<List<T>> input, List<T> cache,
                                             T[] originSet, int maxSize, int start) {
        if (cache.size() == maxSize) {
            input.add(new ArrayList(cache));
        }
        for (int i = start; i < originSet.length; i++) {
            cache.add(originSet[i]);
            getArrangeSelect(input, cache, originSet, maxSize, i + 1);
            cache.remove(cache.size() - 1);
        }
    }

    private static <T> void getTotalArrange(List<List<T>> input, T[] originSet, int length, int start) {
        if (start == length - 1) {
            List<T> cache = new ArrayList<>();
            for (T t : originSet) {
                cache.add(t);
            }
            input.add(cache);
        } else {
            for (int i = start; i < length; i++) {
                T t = originSet[start];
                originSet[start] = originSet[i];
                originSet[i] = t;
                getTotalArrange(input, originSet, length, start + 1);
                t = originSet[start];
                originSet[start] = originSet[i];
                originSet[i] = t;
            }
        }
    }

    private static boolean checkFunction(int[] nums, List<Character> symbol) {
        int result = nums[nums.length - 1];
        int cache = nums[0];
        for (int i = 0; i < symbol.size(); i++) {
            switch (symbol.get(i)) {
                case '+':
                    cache += nums[i + 1];
                    break;
                case '-':
                    cache -= nums[i + 1];
                    break;
                case '*':
                    cache *= nums[i + 1];
                    break;
                case '/':
                    cache /= nums[i + 1];
                    break;
                default:
                    break;
            }
        }
        return result == cache;
    }
}
