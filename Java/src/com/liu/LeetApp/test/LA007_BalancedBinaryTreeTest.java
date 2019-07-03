package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA007_BalancedBinaryTree.*;


/**
 * Created by liu on 2016/12/5.
 */
public class LA007_BalancedBinaryTreeTest {

    public static void main(String[] args) {
        Node input = new Node();
        input.leftChild = new Node();
        input.rightChild = new Node();
        input.leftChild.rightChild = new Node();
        input.leftChild.leftChild = new Node();
        input.rightChild.rightChild = new Node();
        input.rightChild.leftChild = new Node();
        input.rightChild.rightChild.rightChild = new Node();
        boolean result;
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        result = testMy1(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams My 1 result " + result + " during time " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        result = testAnswer(input);
        endTime = System.currentTimeMillis();
        System.out.println("getAnagrams answer result " + result + " during time " + (endTime - startTime));
    }

    private static boolean testMy1(Node input) {
        return balancedBinaryTreeMy1(input);
    }

    private static boolean testAnswer(Node input) {
        return balancedBinaryTreeAnswer(input);
    }
}
