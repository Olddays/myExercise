package com.liu.LeetCode.CodeCaprice.DP;

public class LC096_UniqueBinarySearchTrees {
    // 有多少个包含n节点的不同的二叉搜索树
    // 二叉搜索树的定义是，左子树的所有节点都小于根节点，右子树的所有节点都大于根节点
    // 那么对于n个节点的二叉搜索树，根节点可以是1到n中的任何一个
    // 假设根节点是i，那么左子树的节点就是1到i-1，右子树的节点就是i+1到n
    // 那么左子树的节点数就是i-1，右子树的节点数就是n-i
    // 那么左子树的不同二叉搜索树的数量就是G(i-1)，右子树的不同二叉搜索树的数量就是G(n-i)
    // 那么对于根节点i，不同二叉搜索树的数量就是G(i-1)*G(n-i)
    // 那么对于n个节点的不同二叉搜索树的数量就是G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
    // 这就是卡特兰数的定义
    // 卡特兰数的定义是Cn=C(2n,n)/(n+1)
    // 卡特兰数的通项公式是Cn=Cn-1*(4n-2)/(n+1)
    // 卡特兰数的递推公式是Cn=Cn-1*(4n-2)/(n+1)
    // 卡特兰数的通项公式是Cn=Cn-1*(4n-2)/(n+1)
    // 所以DP的递推公式是G(n)=G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
    private static int numTreesMy1(int n) {
        int[] dp = new int[n + 1]; // 表示n个节点时的不同二叉搜索树的数量
        dp[0] = 1; // dp[0]有意义，0个节点也算是一种二叉搜索树
        dp[1] = 1; // dp[1]只有一种情况
        for (int i = 2; i <= n; i++) { // 从2开始递推，从小到大遍历
            for (int j = 1; j <= i; j++) { // 遍历所有根节点
                dp[i] += dp[j - 1] * dp[i - j]; // 左子树的节点数为j-1，右子树的节点数为i-j
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nSet = new int[]{
                3,
                1,
                4,
                2,
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < nSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = numTreesMy1(nSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("numTrees My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
