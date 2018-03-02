package com.liu.LeetCode.First.exercise;

/**
 * Created by liu on 2017/9/7.
 */
public class LC004_MedianOfTwoSortedArrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * The median is 2.0
     * <p>
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * The median is (2 + 3)/2 = 2.5
     */

    // 没有输入判空相关处理
    public static double getMedianOfTwoSortedArraysMy1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int[] medianSet1 = new int[2];
        boolean single1 = false;
        int length2 = nums2.length;
        int[] medianSet2 = new int[2];
        boolean single2 = false;
        if (length1 % 2 == 0) {
            medianSet1[0] = nums1[length1 / 2 - 1];
            medianSet1[1] = nums1[length1 / 2];
        } else {
            medianSet1[0] = nums1[length1 / 2];
            medianSet1[1] = 0;
            single1 = true;
        }
        if (length2 % 2 == 0) {
            medianSet2[0] = nums2[length2 / 2 - 1];
            medianSet2[1] = nums2[length2 / 2];
        } else {
            medianSet2[0] = nums2[length2 / 2];
            medianSet2[1] = 0;
            single2 = true;
        }

        double part = 4.0;
        if (single1) {
            part--;
        }
        if (single2) {
            part--;
        }

        return (medianSet1[0] + medianSet1[1] + medianSet2[0] + medianSet2[1]) / part;
    }

    // 没有规避输入为[],[1]这种情况,即全部输入只有一个值的情况
    public static double getMedianOfTwoSortedArraysMy2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        double median1 = 0;
        if (length1 > 0) {
            int[] medianSet1 = new int[2];
            if (length1 % 2 == 0) {
                medianSet1[0] = nums1[length1 / 2 - 1];
                medianSet1[1] = nums1[length1 / 2];
                median1 = (medianSet1[0] + medianSet1[1]) / 2.0;
            } else {
                medianSet1[0] = nums1[length1 / 2];
                medianSet1[1] = 0;
                median1 = medianSet1[0];
            }
        }


        int length2 = nums2.length;
        double median2 = 0;
        if (length2 > 0) {
            int[] medianSet2 = new int[2];
            if (length2 % 2 == 0) {
                medianSet2[0] = nums2[length2 / 2 - 1];
                medianSet2[1] = nums2[length2 / 2];
                median2 = (medianSet2[0] + medianSet2[1]) / 2.0;
            } else {
                medianSet2[0] = nums2[length2 / 2];
                medianSet2[1] = 0;
                median2 = medianSet2[0];
            }
        }

        if (median1 <= 0) {
            return median2 / 2.0;
        }
        if (median2 <= 0) {
            return median1 / 2.0;
        }

        return (median1 + median2) / 2.0;
    }

    // 已经除过2.0了
    public static double getMedianOfTwoSortedArraysMy3(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        double median1 = 0;
        boolean single1 = false;
        if (length1 > 0) {
            int[] medianSet1 = new int[2];
            if (length1 % 2 == 0) {
                medianSet1[0] = nums1[length1 / 2 - 1];
                medianSet1[1] = nums1[length1 / 2];
                median1 = (medianSet1[0] + medianSet1[1]) / 2.0;
            } else {
                medianSet1[0] = nums1[length1 / 2];
                medianSet1[1] = 0;
                median1 = medianSet1[0];
                single1 = true;
            }
        }


        int length2 = nums2.length;
        double median2 = 0;
        boolean single2 = false;
        if (length2 > 0) {
            int[] medianSet2 = new int[2];
            if (length2 % 2 == 0) {
                medianSet2[0] = nums2[length2 / 2 - 1];
                medianSet2[1] = nums2[length2 / 2];
                median2 = (medianSet2[0] + medianSet2[1]) / 2.0;
            } else {
                medianSet2[0] = nums2[length2 / 2];
                medianSet2[1] = 0;
                median2 = medianSet2[0];
                single2 = true;
            }
        }

        if (median1 <= 0) {
            if (single2) {
                return median2;
            }
            return median2 / 2.0;
        }
        if (median2 <= 0) {
            if (single1) {
                return median1;
            }
            return median1 / 2.0;
        }

        return (median1 + median2) / 2.0;
    }

    // 中位数不该是加起来直接除,而应该改为最中间的数字进行比较,最后无法判断中位数剩下两个值的时候再除2
    public static double getMedianOfTwoSortedArraysMy4(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        double median1 = 0;
        boolean single1 = false;
        if (length1 > 0) {
            int[] medianSet1 = new int[2];
            if (length1 % 2 == 0) {
                medianSet1[0] = nums1[length1 / 2 - 1];
                medianSet1[1] = nums1[length1 / 2];
                median1 = (medianSet1[0] + medianSet1[1]) / 2.0;
            } else {
                medianSet1[0] = nums1[length1 / 2];
                medianSet1[1] = 0;
                median1 = medianSet1[0];
                single1 = true;
            }
        }


        int length2 = nums2.length;
        double median2 = 0;
        boolean single2 = false;
        if (length2 > 0) {
            int[] medianSet2 = new int[2];
            if (length2 % 2 == 0) {
                medianSet2[0] = nums2[length2 / 2 - 1];
                medianSet2[1] = nums2[length2 / 2];
                median2 = (medianSet2[0] + medianSet2[1]) / 2.0;
            } else {
                medianSet2[0] = nums2[length2 / 2];
                medianSet2[1] = 0;
                median2 = medianSet2[0];
                single2 = true;
            }
        }

        if (median1 <= 0) {
            return median2;
        }
        if (median2 <= 0) {
            return median1;
        }
        if (single1 && !single2) {
            return (median1 + median2 * 2.0) / 3.0;
        }
        if (!single1 && single2) {
            return (median2 + median1 * 2.0) / 3.0;
        }

        return (median1 + median2) / 2.0;
    }

    // 使用了中位数递归的方式,但是在A数组完全小于B数组的时候会出现错误,如输入:[1],[2,3]或[1,2][4,5]
    public static double getMedianOfTwoSortedArraysMy5(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int median1 = getMedianIndexMy5(length1);
        int length2 = nums2.length;
        int median2 = getMedianIndexMy5(length2);
        if (length1 > 0 && length2 > 0) {
            return getMedianNumberMy5(nums1, nums2, median1, median2);
        } else if (length1 > 0) {
            if (length1 % 2 == 0) {
                return (nums1[length1 / 2 - 1] + nums1[length1 / 2]) / 2.0;
            } else {
                return nums1[length1 / 2];
            }
        } else if (length2 > 0) {
            if (length2 % 2 == 0) {
                return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2.0;
            } else {
                return nums2[length2 / 2];
            }
        } else {
            return 0;
        }
    }

    public static int getMedianIndexMy5(int input) {
        if (input % 2 == 0) {
            return input / 2 - 1;
        } else {
            return input / 2;
        }
    }

    public static double getMedianNumberMy5(int[] nums1, int[] nums2, int median1, int median2) {
        if (nums1[median1] < nums2[median2]) {
            int newMedian1 = getMedianIndexMy5(nums1.length + median1);
            int newMedian2 = getMedianIndexMy5(nums2.length - median2);
            if (newMedian1 != median1) {
                getMedianNumberMy5(nums1, nums2, newMedian1, median2);
            } else if (newMedian2 != median2) {
                getMedianNumberMy5(nums1, nums2, median1, newMedian2);
            } else {
                return (nums1[median1] + nums2[median2]) / 2.0;
            }
        } else {
            int newMedian1 = getMedianIndexMy5(nums1.length - median1);
            int newMedian2 = getMedianIndexMy5(nums2.length + median2);
            if (newMedian1 != median1) {
                getMedianNumberMy5(nums1, nums2, newMedian1, median2);
            } else if (newMedian2 != median2) {
                getMedianNumberMy5(nums1, nums2, median1, newMedian2);
            } else {
                return (nums1[median1] + nums2[median2]) / 2.0;
            }
        }
        return 0;
    }

    // 能适应只有一对相似数据的内容,如:{1, 2, 3, 4},{4, 5, 6}但不能适应出现两对的情况
    public static double getMedianOfTwoSortedArraysMy6(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int median1 = length1 / 2;
        int length2 = nums2.length;
        int median2 = length2 / 2;
        if (length1 > 0 && length2 > 0) {
            if (nums1[length1 - 1] < nums2[0] || nums1[0] > nums2[length2 - 1]) {
                int totalLength = length1 + length2;
                if (totalLength % 2 == 0) {
                    if (length1 < totalLength / 2) {
                        return (nums2[(totalLength - length1) / 2 - 1] + nums2[(totalLength - length1) / 2]) / 2.0;
                    } else if (length2 < totalLength / 2) {
                        return (nums1[(totalLength - length2) / 2 - 1] + nums1[(totalLength - length2) / 2]) / 2.0;
                    } else {
                        return (nums1[length1 - 1] + nums2[0]) / 2.0;
                    }
                } else {
                    if (length1 < totalLength / 2 + 1) {
                        return nums2[(totalLength - length1) / 2];
                    } else if (length2 < totalLength / 2 + 1) {
                        return nums1[(totalLength - length2) / 2];
                    } else {
                        return (nums1[length1 - 1] + nums2[0]) / 2.0;
                    }
                }
            } else {
                return getMedianNumberMy6(nums1, nums2, median1, median2);
            }
        } else if (length1 > 0) {
            if (length1 % 2 == 0) {
                return (nums1[length1 / 2 - 1] + nums1[length1 / 2]) / 2.0;
            } else {
                return nums1[length1 / 2];
            }
        } else if (length2 > 0) {
            if (length2 % 2 == 0) {
                return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2.0;
            } else {
                return nums2[length2 / 2];
            }
        } else {
            return 0;
        }
    }

    public static double getMedianNumberMy6(int[] nums1, int[] nums2, int median1, int median2) {
        if (nums1[median1] == nums2[median2]) {
            return nums1[median1];
        } else if (nums1[median1] < nums2[median2]) {
            int newMedian1 = (nums1.length - median1) / 2 + median1;
            if (newMedian1 > median1) {
                return getMedianNumberMy6(nums1, nums2, newMedian1, median2);
            } else {
                int newMedian2 = median2 / 2;
                if (newMedian2 < median2) {
                    return getMedianNumberMy6(nums1, nums2, median1, newMedian2);
                } else {
                    return (nums1[median1] + nums2[median2]) / 2.0;
                }
            }
        } else {
            int newMedian2 = (nums2.length - median2) / 2 + median2;
            if (newMedian2 > median2) {
                return getMedianNumberMy6(nums1, nums2, median1, newMedian2);
            } else {
                int newMedian1 = median1 / 2;
                if (newMedian1 < median1) {
                    return getMedianNumberMy6(nums1, nums2, newMedian1, median2);
                } else {
                    return (nums1[median1] + nums2[median2]) / 2.0;
                }
            }
        }
    }

    public static double getMedianOfTwoSortedArraysMy7(int[] nums1, int[] nums2) {
        int[] cache;
        if (nums1[0] > nums2[0] || nums1[nums1.length - 1] > nums2[nums2.length - 1]) {
            cache = nums1;
            nums1 = nums2;
            nums2 = cache;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > 0 && length2 > 0) {
            int median = (length1 + length2) / 2;
            if ((length1 + length2) % 2 != 0) {
                return getMedianNumberMy7(nums1, nums2, 0, length1, 0, length2, median + 1);
            } else {
                int median1 = getMedianNumberMy7(nums1, nums2, 0, length1, 0, length2, median);
                int median2 = getMedianNumberMy7(nums1, nums2, 0, length1, 0, length2, median + 1);
                return (median1 + median2) / 2.0;
            }
        } else if (length1 > 0) {
            if (length1 % 2 == 0) {
                return (nums1[length1 / 2 - 1] + nums1[length1 / 2]) / 2.0;
            } else {
                return nums1[length1 / 2];
            }
        } else if (length2 > 0) {
            if (length2 % 2 == 0) {
                return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2.0;
            } else {
                return nums2[length2 / 2];
            }
        } else {
            return 0;
        }
    }

    public static int getMedianNumberMy7(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int median) {
        if (median == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int m = end1 - start1;
        int n = end2 - start2;
        if (m == 0) return nums1[median - 1];
        if (n == 0) return nums2[median - 1];
        int i = m / 2 + start1;
        int j = n / 2 + start2;
        if (nums1[i] <= nums2[j]) {
            if (median > i + j + 1) {
                start1 = start1 + i + 1;
                return getMedianNumberMy7(nums1, nums2, start1, m - i - 1, start2, n, median - i - 1);
            } else {
                return getMedianNumberMy7(nums1, nums2, start1, m, start2, j, median);
            }
        } else {
            if (median > i + j + 1) {
                start2 = start2 + j + 1;
                return getMedianNumberMy7(nums1, nums2, start1, m, start2, n - j - 1, median - j - 1);
            } else {
                return getMedianNumberMy7(nums1, nums2, start1, i, start2, n, median);
            }
        }
    }

    public static double getMedianOfTwoSortedArraysAnswer1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        int median = total / 2;
        if (total % 2 != 0)
            return (double) getMedianNumberAnswer1(nums1, 0, length1 - 1, nums2, 0, length2 - 1, median + 1);
        else {
            int median1 = getMedianNumberAnswer1(nums1, 0, length1 - 1, nums2, 0, length2 - 1, median);
            int median2 = getMedianNumberAnswer1(nums1, 0, length1 - 1, nums2, 0, length2 - 1, median + 1);
            return (median1 + median2) / 2.0;
        }
    }

    public static int getMedianNumberAnswer1(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int median) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;

        if (m > n)
            return getMedianNumberAnswer1(nums2, start2, end2, nums1, start1, end1, median);
        if (m == 0)
            return nums2[median - 1];
        if (median == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int partA = Math.min(median / 2, m);
        int partB = median - partA;
        if (nums1[start1 + partA - 1] < nums2[start2 + partB - 1])
            return getMedianNumberAnswer1(nums1, start1 + partA, end1, nums2, start2, end2, median - partA);
        else if (nums1[start1 + partA - 1] > nums2[start2 + partB - 1])
            return getMedianNumberAnswer1(nums1, start1, end1, nums2, start2 + partB, end2, median - partB);
        else
            return nums1[start1 + partA - 1];
    }
}
