package com.liu.LeetCode.First.test;

import com.liu.LeetCode.First.exercise.LC101_SymmetricTree.TreeNode;

import static com.liu.LeetCode.First.exercise.LC101_SymmetricTree.isSymmetricMy1;
import static com.liu.LeetCode.First.exercise.LC101_SymmetricTree.isSymmetricAnswer;

/**
 * Created by Liu on 2020/4/14.
 */
public class LC101_SymmetricTreeTest {
    public static void main(String[] args) {
        long startTime;
        long endTime;
//        [1,2,2,3,4,4,3]
        boolean result;
        TreeNode input;


        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(2);
        input.left.left = new TreeNode(3);
        input.left.right = new TreeNode(4);
        input.right.left = new TreeNode(4);
        input.right.right = new TreeNode(3);

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree My 1, result: " + result + ", during time " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree Answer, result: " + result + ", during time " + (endTime - startTime));


        input = new TreeNode(1);
        input.left = new TreeNode(2);
        input.right = new TreeNode(2);
        input.left.left = new TreeNode(2);
        input.right.left = new TreeNode(2);

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree My 1, result: " + result + ", during time " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree Answer, result: " + result + ", during time " + (endTime - startTime));


        input = new TreeNode(5);
        input.left = new TreeNode(4);
        input.right = new TreeNode(1);
        input.left.right = new TreeNode(1);
        input.right.right = new TreeNode(4);
        input.left.right.left = new TreeNode(2);
        input.right.right.left = new TreeNode(2);

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree My 1, result: " + result + ", during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("SymmetricTree Answer, result: " + result + ", during time " + (endTime - startTime));

    }

    private static boolean testMy1(TreeNode node) {
        return isSymmetricMy1(node);
    }
    private static boolean testAnswer(TreeNode node) {
        return isSymmetricAnswer(node);
    }
}
