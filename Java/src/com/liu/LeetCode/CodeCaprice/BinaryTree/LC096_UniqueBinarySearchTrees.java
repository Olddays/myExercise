package com.liu.LeetCode.CodeCaprice.BinaryTree;

public class LC096_UniqueBinarySearchTrees {

    // DP方法 G是排列组合数量 F是以i为根节点的排列组合数量
    // G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    // G(n) = F(1, n) + F(2, n) + ... + F(n, n)
    // F(i, n) = G(i-1) * G(n-i)
    private static int numTreesMy1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        int[] limitList = new int[]{
                3,
                1,
                5,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < limitList.length; i++) {
            startTime = System.currentTimeMillis();
            result = numTreesMy1(limitList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numTrees My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
