package com.liu.LeetCode.Daily.Daily202503;

import java.util.*;

public class LC2115_FindAllPossibleRecipesFromGivenSupplies {

    // Error，原因是菜谱里面套的内容，可能是某个recipe，所以需要递归或者while而不是一层for
    // 但难点还是如何设计循环的退出机制
    private static List<String> findAllRecipesMyError1(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> recipeMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], new HashSet<>(ingredients.get(i)));
        }
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            Set<String> newIngredient = new HashSet<>();
            for (String s : ingredients.get(i)) {
                if (recipeMap.containsKey(s)) {
                    newIngredient.addAll(recipeMap.get(s));
                } else {
                    newIngredient.add(s);
                }
            }
            recipeMap.put(recipes[i], newIngredient);
            boolean hasSupply = true;
            for (String s : newIngredient) {
                hasSupply &= supplySet.contains(s);
            }
            if (hasSupply) {
                result.add(recipes[i]);
            }
        }
        return result;
    }

    private static List<String> findAllRecipesMyError2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Queue<Integer> recipeQueue = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeQueue.add(i);
        }
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        int queueSize = recipeQueue.size();
        int counter = 0;
        while (!recipeQueue.isEmpty()) {
            if (counter == queueSize) {
                queueSize = recipeQueue.size();
                if (counter == queueSize) {
                    break; // 这一段的意思是，如果循环一圈还没减少，那就break，但是会超时
                }
            }
            int index = recipeQueue.poll();
            String recipe = recipes[index];
            List<String> ingredient = ingredients.get(index);
            boolean hasSupply = true;
            for (String s : ingredient) {
                if (!supplySet.contains(s)) {
                    hasSupply = false;
                    break;
                }
            }
            if (hasSupply) {
                result.add(recipe);
                supplySet.add(recipe);
            } else {
                recipeQueue.add(index);
            }
            counter++;
        }
        return result;
    }

    // Topological sort (Khan's algorithm)
    // Beats 56.84%
    private static List<String> findAllRecipesAnswer1(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> recipeToIngredients = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> recipeIngredients = ingredients.get(i);
            recipeToIngredients.put(recipe, recipeIngredients);
            inDegree.put(recipe, recipeIngredients.size());

            for (String ingredient : recipeIngredients) {
                ingredientToRecipes.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>(availableSupplies);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (recipeToIngredients.containsKey(current)) {
                result.add(current);
            }

            if (ingredientToRecipes.containsKey(current)) {
                for (String dependentRecipe : ingredientToRecipes.get(current)) {
                    inDegree.put(dependentRecipe, inDegree.get(dependentRecipe) - 1);
                    if (inDegree.get(dependentRecipe) == 0) {
                        queue.add(dependentRecipe);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] recipesList = new String[][]{
                {"ju", "fzjnm", "x", "e", "zpmcz", "h", "q"},
                {"bread"},
                {"bread"},
                {"bread", "sandwich"},
                {"bread", "sandwich", "burger"},
        };
        String[][][] ingredientsList = new String[][][]{
                {{"d"}, {"hveml", "f", "cpivl"}, {"cpivl", "zpmcz", "h", "e", "fzjnm", "ju"}, {"cpivl", "hveml", "zpmcz", "ju", "h"}, {"h", "fzjnm", "e", "q", "x"}, {"d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x"}, {"f", "hveml", "cpivl"}},
                {{"yeast", "flour"}},
                {{"yeast", "flour"}},
                {{"yeast", "flour"}, {"bread", "meat"}},
                {{"yeast", "flour"}, {"bread", "meat"}, {"sandwich", "meat", "bread"}},
        };
        String[][] suppliesList = new String[][]{
                {"f", "hveml", "cpivl", "d"},
                {"yeast"},
                {"yeast", "flour", "corn"},
                {"yeast", "flour", "meat"},
                {"yeast", "flour", "meat"},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < recipesList.length; i++) {
            List<List<String>> ingredients = new ArrayList<>();
            for (String[][] ingredient : ingredientsList) {
                for (String[] strings : ingredient) {
                    ingredients.add(new ArrayList<>(Arrays.asList(strings)));
                }
            }
            startTime = System.currentTimeMillis();
            result = findAllRecipesAnswer1(recipesList[i], ingredients, suppliesList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("findAllRecipes My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
