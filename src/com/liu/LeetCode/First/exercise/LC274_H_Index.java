package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC274_H_Index {
    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
     * <p>
     * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
     * <p>
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     * <p>
     * Credits:
     * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
     */

    // 其实就是没看懂题目啥意思
    public static int getH_IndexMy1(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        return citations[citations.length / 2];
    }

    public static int getH_IndexAnswer1(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int citation : citations) {
            if (citation > length) {
                array2[length] += 1;
            } else {
                array2[citation] += 1;
            }
        }
        int t = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }

    /**
     * This type of problems always throw me off, but it just takes some getting used to. The idea behind it is some bucket sort mechanisms. First, you may ask why bucket sort. Well, the h-index is defined as the number of papers with reference greater than the number. So assume n is the total number of papers, if we have n+1 buckets, number from 0 to n, then for any paper with reference corresponding to the index of the bucket, we increment the count for that bucket. The only exception is that for any paper with larger number of reference than n, we put in the n-th bucket.
     * <p>
     * Then we iterate from the back to the front of the buckets, whenever the total count exceeds the index of the bucket, meaning that we have the index number of papers that have reference greater than or equal to the index. Which will be our h-index result. The reason to scan from the end of the array is that we are looking for the greatest h-index. For example, given array [3,0,6,5,1], we have 6 buckets to contain how many papers have the corresponding index. Hope to image and explanation help.
     * <p>
     * 3, 0, 6, 5, 1
     * count 1, 1,  , 1,  , 2
     * index 0, 1, 2, 3, 4, 5
     */
    public static int getH_IndexAnswer2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        int[] buckets = new int[length + 1];
        for (int c : citations) {
            if (c >= length) {
                buckets[length]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = length; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
