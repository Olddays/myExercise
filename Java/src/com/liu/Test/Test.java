package com.liu.Test;

public class Test {
    public static int findKMax(int[] input, int k) {
        quickSort(input, 0, input.length - 1);
        if (input.length >= k) {
            return input[input.length - k];
        }
        return 0;
    }

    public static void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = swap(input, left, right);
        quickSort(input, left, i - 1);
        quickSort(input, i + 1, right);
    }

    public static int swap(int[] input, int left, int right) {
        int num = input[left];
        int cacheLeft = left;
        int cacheRight = right;
        while (cacheLeft < cacheRight) {
            while (cacheLeft < cacheRight && input[cacheRight] > num) {
                right--;
            }
            while (cacheLeft < cacheRight && input[cacheLeft] <= num) {
                cacheLeft++;
            }
            if (cacheLeft < cacheRight) {
                int t = input[cacheLeft];
                input[cacheLeft] = input[cacheRight];
                input[cacheRight] = t;
            }
        }
        return cacheRight;
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,8,3,9};
        int k = 3;
        int value = findKMax(input, k);
        System.out.println(value);
    }
}
