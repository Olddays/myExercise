package com.liu.FunTestsOfProgrammer.test;

import static com.liu.FunTestsOfProgrammer.exercise.FT013_LettersFormulaSatisfyCount.getLettersFormulaSatisfyCountMy1;
import static com.liu.FunTestsOfProgrammer.exercise.FT013_LettersFormulaSatisfyCount.Result;

/**
 * Created by liu on 2018/02/28.
 */
public class FT013_LettersFormulaSatisfyCountTest {

    public static void main(String[] args) {
        String[] equations = new String[]{
                "WE * LOVE = CODEIQ",
                "READ + WRITE + TALK = SKILL"
        };
        Result result;
        long startTime;
        long endTime;

        for (String equation : equations) {
            startTime = System.currentTimeMillis();
            result = testMy1(equation);
            endTime = System.currentTimeMillis();
            System.out.println("LettersFormulaSatisfyCount My 1 result " + result + " during time " + (endTime - startTime));
        }
    }

    private static Result testMy1(String equation) {
        return getLettersFormulaSatisfyCountMy1(equation);
    }
}
