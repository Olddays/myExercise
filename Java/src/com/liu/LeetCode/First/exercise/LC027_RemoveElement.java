package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/14.
 */
public class LC027_RemoveElement {
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * <p>
     * Example:
     * Given input array nums = [3,2,2,3], val = 3
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 2.
     */


    // 注意此题目不允许占用新的空间
    public static int getRemoveElementMy1(int[] nums, int val) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                if (i + 1 < nums.length) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i] = 0;
                }
            } else {
                result++;
            }
        }
        return result;
    }

    // 缺少删除第一个数字后面的全部迁移的对应策略,导致第二个数字多次补充,致使输出错误
    // 主要原因是出现了重复后使用接下来的一个字符补全
    public static int getRemoveElementMy2(int[] nums, int val) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                int j = 0;
                while (j < length - i && nums[i + j] == val) { // 注意Java的判断短路机制,要把数据越界保护放在最前面
                    j++;
                }
                if (i + j < nums.length) {
                    nums[i] = nums[i + j];
                } else {
                    nums[i] = 0;
                }
            } else {
                result++;
            }
        }
        return result;
    }

    // 主要原因是出现了重复后使用最后一个与val不相同一个字符补全
    // 应该使用与val相同后的最后一个字符,或者说应该是讲val不同的全部字符依次提前
    public static int getRemoveElementMy3(int[] nums, int val) {
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                int j = length - 1 - i;
                while (j > i && nums[i + j] == val) { // 注意Java的判断短路机制,要把数据越界保护放在最前面
                    j--;
                }
                if (i + j < nums.length) {
                    nums[i] = nums[i + j];
                } else {
                    nums[i] = 0;
                }
            } else {
                result++;
            }
        }
        return result;
    }

    public static int getRemoveElementMy4(int[] nums, int val) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length - index; i++) {
            if (nums[i + index] == val) {
                while (index < length - i && nums[i + index] == val) {
                    index++;
                }
            }
            if (i + index < nums.length) {
                nums[i] = nums[i + index];
            } else {
                nums[i] = 0;
            }
        }
        return length - index;
    }

    public static int getRemoveElementAnswer1(int[] nums, int val) {
        int index = 0;
        for (int n : nums) {
            if (index == 0 || n > nums[index - 1]) {
                nums[index] = n;
                index++;
            }
        }
        return index;
    }
}
