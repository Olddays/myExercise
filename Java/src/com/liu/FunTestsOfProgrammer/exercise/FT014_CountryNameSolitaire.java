package com.liu.FunTestsOfProgrammer.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 218/02/28.
 */
public class FT014_CountryNameSolitaire {
    /**
     * FIFA世界杯对足球爱好者而言是四年一度的盛事。
     * 下面我们拿 2014 年世界杯参赛国的国名做个词语接龙游戏。
     * 不过，这里用的不是中文，而是英文字母（忽略大小写）
     * <p>
     * Brazil Croatia Mexico Cameroon
     * Spain Netherlands Chile Australia
     * Colombia Greece Cote d'Ivoire Japan
     * Uruguay Costa Rica England Italy
     * Switzerland Ecuador France Honduras
     * Argentina Bosnia and Herzegovina Iran
     * Nigeria Germany Portugal Ghana USA
     * Belgium Algeria Russia Korea Republic
     * <p>
     * 举个例子，如果像下面这样，那么连续3个国名之后接龙就结束了
     * （因为没有英文名称以 D 开头的国家）。
     * “Japan” → “Netherlands” → “Switzerland”
     * <p>
     * 问题：
     * 假设每个国名只能使用一次，求能连得最长的顺序，以及相应的国名个数。
     */

    public static List<List<String>> getCountryNameSolitaireMy1(String[] countrySet) {
        Map<Character, List<String>> headMap = new HashMap<>();
        Map<Character, List<String>> tailMap = new HashMap<>();
        for (String country : countrySet) {
            country = country.toUpperCase();
            char head = country.charAt(0);
            char tail = country.charAt(country.length() - 1);
            List<String> list;
            if (headMap.containsKey(head)) {
                list = headMap.get(head);
            } else {
                list = new ArrayList<>();
            }
            list.add(country);
            headMap.put(head, list);

            if (tailMap.containsKey(tail)) {
                list = tailMap.get(tail);
            } else {
                list = new ArrayList<>();
            }
            list.add(country);
            tailMap.put(tail, list);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (String country : countrySet) {
            country = country.toUpperCase();
            char nextHead = country.charAt(country.length() - 1);
            List<String> nextList = headMap.get(nextHead);
            if (nextList != null) {
                List<String> cache = new ArrayList<>();
                cache.add(country);
                getSolitaire(resultList, cache, headMap, nextList);
            }
        }
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (List<String> cache : resultList) {
            List<List<String>> list;
            if (map.containsKey(cache.size())) {
                list = map.get(cache.size());
            } else {
                list = new ArrayList<>();
            }
            list.add(cache);
            map.put(cache.size(), list);
        }
        int maxCount = 0;
        for (Map.Entry<Integer, List<List<String>>> entry : map.entrySet()) {
            if (maxCount < entry.getKey()) {
                maxCount = entry.getKey();
                result = entry.getValue();
            }
        }
        return result;
    }

    private static void getSolitaire(List<List<String>> list, List<String> cache, Map<Character, List<String>> headMap,
                                     List<String> countryList) {
        for (String nextString : countryList) {
            if (!cache.contains(nextString)) {
                cache.add(nextString);
                char nextHead = nextString.charAt(nextString.length() - 1);
                List<String> nextList = headMap.get(nextHead);
                if (null != nextList) {
                    getSolitaire(list, cache, headMap, nextList);
                } else {
                    if (!list.contains(cache)) {
                        list.add(new ArrayList<>(cache));
                    }
                }
                cache.remove(cache.size() - 1);
            } else {
                if (!list.contains(cache)) {
                    list.add(new ArrayList<>(cache));
                }
            }
        }
    }
}
