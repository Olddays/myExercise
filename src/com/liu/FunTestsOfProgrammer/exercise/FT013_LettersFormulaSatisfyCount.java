package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> parameter;
        List<Character> symbol;
        String equal;

        Equation(List<Character> character, List<String> parameter,
                 List<Character> symbol, String equal) {
            this.character = character;
            this.parameter = parameter;
            this.symbol = symbol;
            this.equal = equal;
        }

        @Override
        public String toString() {
            return "character: " + character + ", parameter: " + parameter
                    + ", symbol: " + symbol + ", equal: " + equal;
        }
    }

    public static Map<Integer, String> getLettersFormulaSatisfyCountMy1(String equation) {
        Equation equationInstance = getEquationInstance(equation);
        if (equationInstance == null) {
            return null;
        }
        System.out.println(equationInstance.toString());
        Map<Integer, String> result = new HashMap<>();
        return result;
    }

    public static Map<Integer, String> getLettersFormulaSatisfyCountMy2(String equation) {
        Map<Integer, String> result = new HashMap<>();
        return result;
    }

    private static Equation getEquationInstance(String equation) {
        if (!equation.contains("=")) {
            return null;
        }
        String[] parts = equation.toLowerCase()
                .replaceAll(" ", "").split("=");
        String equal = parts[1];
        char[] leftParts = parts[0].toCharArray();
        List<Character> character = new ArrayList<>();
        List<String> parameter = new ArrayList<>();
        List<Character> symbol = new ArrayList<>();
        String cache = "";
        for (char c : leftParts) {
            if (c <= 'z' && c >= 'a') {
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
        parameter.add(cache);
        if (parameter.size() != symbol.size() + 1
                || character.size() > 10) {
            // 一个字母一个数字，不可重复，且数字为0-9，共十个
            return null;
        }
        return new Equation(character, parameter, symbol, equal);
    }
}
