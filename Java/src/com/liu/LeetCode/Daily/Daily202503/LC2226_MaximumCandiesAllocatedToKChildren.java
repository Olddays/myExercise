package com.liu.LeetCode.Daily.Daily202503;

import java.util.Arrays;
import java.util.Comparator;

public class LC2226_MaximumCandiesAllocatedToKChildren {

    private static int maximumCandiesMyError1(int[] candies, long k) {
        int length = candies.length;
        Arrays.sort(candies);
        int min = candies[0];
        int sum = Arrays.stream(candies).sum();
        if (sum < k) {
            return 0;
        }
        int result = (int) (sum / k); // 最大可能
        // 并不是最大可能，比如k=1，那么就应该是最大值
        for (; result >= 0; result--) {
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (count >= k) {
                    break;
                }
                if (candies[i] < result) {
                    break;
                }
                count += candies[i] / result;
            }
            if (count >= k) {
                break;
            }
        }
        return result;
    }

    private static int maximumCandiesMy1(int[] candies, long k) {
        int right = 10_000_000;
        int left = 0;
        while (left < right) { // 二分法，找到最大可能
            int mid = (left + right + 1) / 2; // 既然是小于，那么就应该取右中位数，如果是小于等于那就应该为左中位数(left + right) / 2
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (k > count) {
                right = mid - 1; // 因为是右中位数，所以应该减一，因为在计算式中，已经使用了mid
            } else {
                left = mid; // 如果用了左中位数，那么就该left=mid+1，right=mid-1
            }
        }
        return left;
    }

    private static int maximumCandiesAnswer1(int[] candies, long k) {
        // Find the maximum number of candies in any pile
        int maxCandiesInPile = 0;
        for (int candy : candies) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candy);
        }

        // Set the initial search range for binary search
        int left = 0;
        int right = maxCandiesInPile;

        // Binary search to find the maximum number of candies each child can get
        while (left < right) {
            // Calculate the middle value of the current range
            int middle = (left + right + 1) / 2;

            // Check if it's possible to allocate candies so that each child gets 'middle' candies
            if (canAllocateCandies(candies, k, middle)) {
                // If possible, move to the upper half to search for a larger number
                left = middle;
            } else {
                // Otherwise, move to the lower half
                right = middle - 1;
            }
        }

        return left;
    }

    private static boolean canAllocateCandies(int[] candies, long k, int numOfCandies) {
        // Initialize the total number of children that can be served
        long maxNumOfChildren = 0;

        // Iterate over all piles to calculate how many children each pile can serve
        for (int candy : candies) {
            maxNumOfChildren += candy / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }

    public static void main(String[] args) {
        int[][] candiesList = new int[][]{
                {1, 2, 3, 4, 10},
                {4, 7, 5},
                {5, 8, 6},
                {2, 5},
        };
        int[] kList = new int[]{
                5,
                4,
                3,
                11,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < candiesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumCandiesMy1(candiesList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumCandies My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < candiesList.length; i++) {
            startTime = System.currentTimeMillis();
            result = maximumCandiesAnswer1(candiesList[i], kList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("maximumCandies Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
