package com.liu.FunTestsOfProgrammer.test;

import java.util.Map;

import static com.liu.FunTestsOfProgrammer.exercise.FT013_LettersFormulaSatisfyCount.getLettersFormulaSatisfyCountMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT013_LettersFormulaSatisfyCount.getLettersFormulaSatisfyCountMy2;

/**
 * Created by liu on 2018/02/28.
 */
public class FT013_LettersFormulaSatisfyCountTest {

    public static void main(String[] args) {
        String[] equations = new String[]{
                "WE * LOVE = CODEIQ",
                "READ + WRITE + TALK = SKILL"
        };
        Map<Integer, String> result;
        long startTime;
        long endTime;

        for (String equation : equations) {
            startTime = System.currentTimeMillis();
            result = testMy1(equation);
            endTime = System.currentTimeMillis();
            System.out.println("LettersFormulaSatisfyCount My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (Map.Entry entry : result.entrySet()) {
                System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
            }
            System.out.println();

            startTime = System.currentTimeMillis();
            result = testMy2(equation);
            endTime = System.currentTimeMillis();
            System.out.println("LettersFormulaSatisfyCount My 2 result.size() " + result.size() + " during time " + (endTime - startTime));
            for (Map.Entry entry : result.entrySet()) {
                System.out.print(entry.getKey() + "-" + entry.getValue() + " ");
            }
            System.out.println();
        }
    }

    private static Map<Integer, String> testMy1(String equation) {
        return getLettersFormulaSatisfyCountMy1(equation);
    }

    private static Map<Integer, String> testMy2(String equation) {
        return getLettersFormulaSatisfyCountMy2(equation);
    }
}
