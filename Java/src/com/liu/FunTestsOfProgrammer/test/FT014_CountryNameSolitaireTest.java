package com.liu.FunTestsOfProgrammer.test;

import java.util.List;

import static com.liu.FunTestsOfProgrammer.exercise.FT014_CountryNameSolitaire.getCountryNameSolitaireMy1;

/**
 * Created by liu on 2018/02/28.
 */
public class FT014_CountryNameSolitaireTest {

    public static void main(String[] args) {
        String[] countries = new String[]{
                "Brazil", "Croatia", "Mexico", "Cameroon",
                "Spain", "Netherlands", "Chile", "Australia",
                "Colombia", "Greece", "Cote d'Ivoire", "Japan",
                "Uruguay", "Costa Rica", "England", "Italy",
                "Switzerland", "Ecuador", "France", "Honduras",
                "Argentina", "Bosnia and Herzegovina", "Iran",
                "Nigeria", "Germany", "Portugal", "Ghana", "USA",
                "Belgium", "Algeria", "Russia", "Korea Republic"
        };
        List<List<String>> result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(countries);
        endTime = System.currentTimeMillis();
        System.out.println("CountryNameSolitaire My 1 result.size() " + result.size() + " during time " + (endTime - startTime));
        for (List<String> list : result) {
            System.out.println("list.size " + list.size());
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> testMy1(String[] countries) {
        return getCountryNameSolitaireMy1(countries);
    }
}
