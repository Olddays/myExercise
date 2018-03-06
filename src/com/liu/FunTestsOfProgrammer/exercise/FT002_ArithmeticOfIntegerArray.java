package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liu on 2018/02/28.
 */
public class FT002_ArithmeticOfIntegerArray {
    /**
     * 大家小时候可能也玩过“组合车牌号里的 4 个数字最终得到 10”的 游戏。
     * 组合的方法是在各个数字之间插入四则运算的运算符组成算式，然 后计算算式的结果(某些数位之间可以没有运算符，但最少要插入 1 个 运算符)。
     * 例)   1234 → 1 + 2×3 - 4 = 3          9876 → 9×87 + 6 = 789
     * 假设这里的条件是，组合算式的计算结果为“将原数字各个数位上 的数逆序排列得到的数”，并且算式的运算按照四则运算的顺序进行
     * (先乘除，后加减)。
     * 那么位于 100~999，符合条件的有以下几种情况。
     * 351 → 3×51 = 153
     * 621 → 6×21 = 126
     * 886 → 8×86 = 688
     * 问题
     * 求位于 1000~9999，满足上述条件的数。
     * <p>
     * 解决这个问题时，“计算算式的方法”会影响实现方法。如果要实 现的是计算器，那么通常会用到逆波兰表示法，而本题则是使用编程语 言内置的功能来实现更为简单。
     * 逆波兰表示法(Reverse Polish notation，RPN)也称逆波兰记法，是由波兰数学 家扬·武卡谢维奇于 1920 年引入的数学表达式，在逆波兰记法中，所有操作符 置于操作数的后面，因此也被称为后缀表示法。
     */

    public static List<Integer> getArithmeticOfIntegerArrayMy1() {
        String[] symbol = new String[]{"+", "-", "*", "/", ""};
        List<Integer> result = new ArrayList<>();
        for (int i = 1000; i < 10000; i++) {
            String testTarget = String.valueOf(i);
            for (String aSymbol : symbol) {
                for (String bSymbol : symbol) {
                    for (String cSymbol : symbol) {
                        String formula = "" + testTarget.charAt(0) + aSymbol + testTarget.charAt(1) + bSymbol +
                                testTarget.charAt(2) + cSymbol + testTarget.charAt(3);
                        if (formula.length() > 4) { /* 一定要插入1个运算符 */
                            int first = reverse(i);
                            int second = calculate(formula);
                            if (first == second && String.valueOf(first).length() == 4) {
                                if (!result.contains(i)) {
                                    result.add(i);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int reverse(int input) {
        char[] chars = String.valueOf(input).toCharArray();
        String cache = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            cache += chars[i];
        }
        return Integer.valueOf(cache);
    }

    private static int calculate(String formula) {
        char[] chars = formula.toCharArray();
        int result = 0;
        int jumpSize = 0;
        boolean foundNum = false;
        for (char c : chars) {
            // 根据表达式中第一个符号确定基础值是多少,若第一个符号为+-则基础值为0
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                break;
            } else {
                result = result * 10 + Integer.valueOf(String.valueOf(c));
            }
            jumpSize++;
        }
        foundNum = false;
        boolean start = false;
        int type = 0;
        int cache = -1;
        for (int i = jumpSize; i < chars.length; i++) {
            char c = chars[i];
            switch (c) {
                case '+':
                    type = 1;
                    foundNum = false;
                    break;
                case '-':
                    type = 2;
                    foundNum = false;
                    break;
                case '*':
                    type = 3;
                    foundNum = false;
                    break;
                case '/':
                    type = 4;
                    foundNum = false;
                    break;
                default:
                    if (foundNum) {
                        cache = cache * 10 + Integer.valueOf(String.valueOf(c));
                        foundNum = false;
                    } else {
                        cache = Integer.valueOf(String.valueOf(c));
                        foundNum = true;
                    }
                    start = true;
                    break;
            }
            if (start && !foundNum) {
                start = false;
                switch (type) {
                    case 1:
                        result += cache;
                        break;
                    case 2:
                        result -= cache;
                        break;
                    case 3:
                        result *= cache;
                        break;
                    case 4:
                        if (cache != 0) {
                            result /= cache;
                        } else {
                            return 0;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return result;
    }

    public static List<Integer> getArithmeticOfIntegerArrayAnswer1() {
        List<Integer> result = new ArrayList<>();
        String[] symbol = new String[]{"*", ""};
        // 由于最后结果要有4位,而只有+和*能进行数据增加,其中如果使用+则最大的情况为999+9=1008,不满足题目要求,故只有*操作满足,可以简化
        for (int i = 5931; i < 10000; i++) {
            String testTarget = String.valueOf(i);
            for (String aSymbol : symbol) {
                for (String bSymbol : symbol) {
                    for (String cSymbol : symbol) {
                        String formula = String.valueOf(testTarget.charAt(0)) + aSymbol + String.valueOf(testTarget.charAt(1))
                                + bSymbol + String.valueOf(testTarget.charAt(2)) + cSymbol + String.valueOf(testTarget.charAt(3));
                        if (formula.length() > 4) { /* 一定要插入1个运算符 */
                            int first = reverse(i);
                            String[] RPNList = getRPN(formula);
                            int second = evalRPN(RPNList);
                            if (first == second && String.valueOf(first).length() == 4) {
                                if (!result.contains(i)) {
                                    result.add(i);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static String[] getRPN(String formula) {
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int cache = 0;
        for (char c : formula.toCharArray()) {
            if (c >= '0' && c <= '9') {
                cache = cache * 10 + Integer.valueOf(String.valueOf(c));
            } else if (c == '(' || c == ')') {
                while (!stack.isEmpty()) {
                    list.add(String.valueOf(stack.pop()));
                }
            } else {
                stack.push(c);
                list.add(String.valueOf(cache));
                cache = 0;
            }
        }
        list.add(String.valueOf(cache));
        while (!stack.isEmpty()) {
            list.add(String.valueOf(stack.pop()));
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String temp : tokens) {
            if (temp.matches("[-+]?[0-9]+")) {
                Integer value = Integer.valueOf(temp);
                stack.push(value);
            } else if (temp.equals("+")) {
                int newValue = 0;
                newValue += stack.pop();
                newValue += stack.pop();
                stack.push(newValue);
            } else if (temp.equals("-")) {
                int newValue = 0;
                newValue += stack.pop();
                newValue -= stack.pop();
                stack.push(-newValue);
            } else if (temp.equals("*")) {
                int newValue = 0;
                newValue += stack.pop();
                newValue *= stack.pop();
                stack.push(newValue);
            } else if (temp.equals("/")) {
                int newValue = stack.pop();
                if (newValue == 0) {
                    return 0;
                }
                int divided = stack.pop();
                int outcome = divided / newValue;
                stack.push(outcome);
            }
        }
        return stack.pop();
    }
}
