package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC034_SearchForARange {
    /**
     * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     */

    // 在输入的int数组只有一个值并且和target一致的时候会错误
    public static int[] getSearchForARangeMy1(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[left] == target && start == -1) {
                start = left;
            }
            if (nums[right] > target) {
                right--;
            } else if (nums[right] == target && end == -1) {
                end = right;
            }
            if (nums[left] > target && nums[right] < target) {
                break;
            }
            if (start != -1 && end != -1) {
                break;
            }

        }
        if (start != end && (start == -1 || end == -1)) {
            int result = Math.max(start, end);
            start = result;
            end = result;
        }
        return new int[]{start, end};
    }

    // 当输入为target为中位数的时候有前(nums.length - 1) / 2次循环时的left--和right++
    // 导致在最后一次循环的时候left==right成立直接退出while循环
    // 故缺少left == right的状态,且当nums.length = 1的时候加入left == right也可以规避问题
    public static int[] getSearchForARangeMy2(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (nums.length == 1) {
            if (nums[0] == target){
                return new int[]{0, 0};
            } else {
                return new int[]{start, end};
            }
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[left] == target && start == -1) {
                start = left;
            }
            if (nums[right] > target) {
                right--;
            } else if (nums[right] == target && end == -1) {
                end = right;
            }
            if (nums[left] > target && nums[right] < target) {
                break;
            }
            if (start != -1 && end != -1) {
                break;
            }

        }
        if (start != end && (start == -1 || end == -1)) {
            int result = Math.max(start, end);
            start = result;
            end = result;
        }
        return new int[]{start, end};
    }

    // 缺少数组越界规避,且判断位置错误应该先进行nums[left] > target && nums[right] < target的判断
    // 此时在只有nums.length为1的时候会越界
    public static int[] getSearchForARangeMy3(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[left] == target && start == -1) {
                start = left;
            }
            if (nums[right] > target) {
                right--;
            } else if (nums[right] == target && end == -1) {
                end = right;
            }
            if (nums[left] > target && nums[right] < target) {
                break;
            }
            if (start != -1 && end != -1) {
                break;
            }

        }
        if (start != end && (start == -1 || end == -1)) {
            int result = Math.max(start, end);
            start = result;
            end = result;
        }
        return new int[]{start, end};
    }

    public static int[] getSearchForARangeMy4(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > target && nums[right] < target) {
                break;
            }
            if (nums[left] < target) {
                left++;
            } else if (nums[left] == target && start == -1) {
                start = left;
            }
            if (nums[right] > target) {
                right--;
            } else if (nums[right] == target && end == -1) {
                end = right;
            }
            if (start != -1 && end != -1) {
                break;
            }

        }
        if (start != end && (start == -1 || end == -1)) {
            int result = Math.max(start, end);
            start = result;
            end = result;
        }
        return new int[]{start, end};
    }
}
