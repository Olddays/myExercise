package com.liu.LeetCode.First.exercise;

import java.util.Arrays;

/**
 * Created by baidu on 2017/9/14.
 */
public class LC031_NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place, do not allocate extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    //6, 5, 4, 8, 7, 5, 1
    // 6 5 5 8 7 4 1
    // i = 3;left=2 right = 6
    // 此题是全排列问题,要理解全排列和字典序的意思才能做
    public static void getNextPermutationMy1(int[] nums) {
        int length = nums.length;
        boolean hasNext = false;
        for (int i = length - 1; i > 0; i--) {
            int nowNum = nums[i];
            int beforeNum = nums[i - 1];
            if (nowNum > beforeNum) {
                int left = i;
                while (left < length - 1) {
                    if (beforeNum < nums[left]) {
                        left++;
                    } else {
                        break;
                    }
                }
                nums[i - 1] = nums[left - 1];
                nums[left - 1] = beforeNum;
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            Arrays.sort(nums);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void getNextPermutationMy2(int[] nums) {
        int length = nums.length;
        boolean hasNext = false;
        if (length == 2) {
            int cache = nums[1];
            nums[1] = nums[0];
            nums[0] = cache;
            return;
        }
        for (int i = length - 1; i > 0; i--) {
            int nowNum = nums[i];
            int beforeNum = nums[i - 1];
            if (nowNum > beforeNum) {
                int left = i - 1;
                while (left < length - 1) {
                    if (beforeNum < nums[left]) {
                        left++;
                    } else {
                        break;
                    }
                }
                nums[i - 1] = nums[left];
                nums[left] = beforeNum;
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            Arrays.sort(nums);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    // 问题出在只针对两个数字交换,要注意,如果交换过后发现还有问题应该继续处理
    // 例: 1, 3, 2 --> 2, 1, 3
    public static void getNextPermutationMy3(int[] nums) {
        int length = nums.length;
        boolean hasNext = false;
        if (length == 2) {
            int cache = nums[1];
            nums[1] = nums[0];
            nums[0] = cache;
            return;
        }
        for (int i = length - 1; i > 0; i--) {
            int nowNum = nums[i];
            int beforeNum = nums[i - 1];
            if (nowNum > beforeNum) {
                int left = i;
                while (left <= length - 1) {
                    if (nums[left] > beforeNum) {
                        left++;
                    } else {
                        break;
                    }
                }
                nums[i - 1] = nums[left - 1];
                nums[left - 1] = beforeNum;
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            Arrays.sort(nums);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void getNextPermutationMy4(int[] nums) {
        int length = nums.length;
        boolean hasNext = false;
        if (length == 2) {
            int cache = nums[1];
            nums[1] = nums[0];
            nums[0] = cache;
            return;
        }
        for (int i = length - 1; i > 0; i--) {
            int nowNum = nums[i];
            int beforeNum = nums[i - 1];
            if (nowNum > beforeNum) {
                int index = i;
                while (index <= length - 1) {
                    if (nums[index] > beforeNum) {
                        index++;
                    } else {
                        break;
                    }
                }
                // 此时i - 1 = 0,则有除了第i位前的部分外,后面的为大小倒序,此时应该改为正序
                nums[i - 1] = nums[index - 1];
                nums[index - 1] = beforeNum;
                // 以 length / 2 为中心开始互换
                int left = i;
                int right = length - 1;
                while (left < right) {
                    int cache = nums[left];
                    nums[left] = nums[right];
                    nums[right] = cache;
                    left++;
                    right--;
                }
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            Arrays.sort(nums);
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
