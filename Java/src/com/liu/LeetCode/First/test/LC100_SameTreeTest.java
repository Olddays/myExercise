package com.liu.LeetCode.First.test;


import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.First.exercise.LC100_SameTree.isSameTree;

/**
 * Created by Liu on 2020/4/9.
 */
public class LC100_SameTreeTest {
    public static void main(String[] args) {
        int[] nums;
        TreeNode p;
        TreeNode q;
        boolean result;

        TreeNode node;
        boolean isLeft;

        nums = new int[]{
                5, -685, 2970, -755, -462, 2770, 3620, 0, -714, -649, 434, 373, 2913, 3337, 4201, 0, 0, 0, -497, -400, -95, 313, 1620, 2838, 0, 3228, 3574, 3874, 4262, -589, -484, 0, -225, -183, 0, 240, 0, 1357, 2342, 0, 0, 2988, 3262, 3434, 0, 3658, 3885, 0, 0, -622, 0, 0, 0, -381, 0, 0, 0, 150, 0, 1237, 1538, 2235, 2593, 0, 3072, 0, 0, 3349, 3490, 0, 3760, 0, 4187, 0, 0, 0, -325, 74, 0, 701, 1246, 1439, 1583, 2136, 2249, 2553, 2661, 3053, 3174, 0, 3384, 3465, 0, 3686, 3855, 3971, 0, 0, 0, 0, 0, 527, 913, 0, 1283, 0, 0, 0, 0, 1945, 2219, 0, 0, 2370, 0, 0, 2694, 3007, 0, 3109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4058, 519, 624, 712, 972, 0, 0, 1736, 1954, 0, 0, 0, 2467, 2692, 0, 0, 0, 0, 3115, 0, 4100, -203, 0, 0, 0, 0, 725, 0, 1227, 1670, 1745, 1952, 2030, 2427, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 817, 1056, 0, 0, 0, 0, 1852, 0, 0, 0, 2098, 0, 0, 0, 0, 0, 1133, 1834, 1929
        };
        p = new TreeNode(nums[0]);
        node = p;
        isLeft = false;
        for (int i = 1; i < nums.length; i++) {
            isLeft = !isLeft;
            int c = nums[i];
            if (c == 0) {
                continue;
            }
            if (isLeft) {
                node.left = new TreeNode(c);
            } else {
                node.right = new TreeNode(c);
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        nums = new int[]{
                5, -685, 2970, -755, -462, 2770, 3620, 0, -714, -649, 434, 373, 2913, 3337, 4201, 0, 0, 0, -497, -400, -95, 313, 1620, 2838, 0, 3228, 3574, 3874, 4262, -589, -484, 0, -225, -183, 0, 240, 0, 1357, 2342, 0, 0, 2988, 3262, 3434, 0, 3658, 3885, 0, 0, -622, 0, 0, 0, -381, 0, 0, 0, 150, 0, 1237, 1538, 2235, 2593, 0, 3072, 0, 0, 3349, 3490, 0, 3760, 0, 4187, 0, 0, 0, -325, 74, 0, 701, 1246, 1439, 1583, 2136, 2249, 2553, 2661, 3053, 3174, 0, 3384, 3465, 0, 3686, 3855, 3971, 0, 0, 0, 0, 0, 527, 913, 0, 1283, 0, 0, 0, 0, 1945, 2219, 0, 0, 2370, 0, 0, 2694, 3007, 0, 3109, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4058, 519, 624, 712, 972, 0, 0, 1736, 1954, 0, 0, 0, 2467, 2692, 0, 0, 0, 0, 3115, 0, 4100, -203, 0, 0, 0, 0, 725, 0, 1227, 1670, 1745, 1952, 2030, 2427, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 817, 1056, 0, 0, 0, 0, 1852, 0, 0, 0, 2098, 0, 0, 0, 0, 0, 1133, 1834, 1929
        };
        q = new TreeNode(nums[0]);
        node = q;
        isLeft = false;
        for (int i = 1; i < nums.length; i++) {
            isLeft = !isLeft;
            int c = nums[i];
            if (c == 0) {
                continue;
            }
            if (isLeft) {
                node.left = new TreeNode(c);
            } else {
                node.right = new TreeNode(c);
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(p, q);
        endTime = System.currentTimeMillis();
        System.out.println("SameTree My 1, result: " + result + ", during time " + (endTime - startTime));

    }

    private static boolean testMy1(TreeNode p, TreeNode q) {
        return isSameTree(p, q);
    }
}
