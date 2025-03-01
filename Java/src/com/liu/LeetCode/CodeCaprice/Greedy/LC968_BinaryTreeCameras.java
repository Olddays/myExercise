package com.liu.LeetCode.CodeCaprice.Greedy;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC968_BinaryTreeCameras {

    // Greedy 核心是找到连通性最多的点，因为是二叉树，那么如果逐层遍历的话，一般选择叶子节点的上层
    // 因为要判断左右再回到根，所以应该选择后续，左右中
    private static int cameraCountAnswer1 = 0;

    private static int minCameraCoverAnswer1(TreeNode root) {
        return minCameraCoverAnswer1Helper(root) > 2 ? cameraCountAnswer1 + 1 : cameraCountAnswer1; // 最后的判断是处理node节点，因为是从下往上遍历
    }

    private static int minCameraCoverAnswer1Helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = minCameraCoverAnswer1Helper(node.left);
        int right = minCameraCoverAnswer1Helper(node.right);
        int val = left + right; // 如果等于6，也就是左右两个节点都是没有摄像机也没有摄像机控制的，如果等于4，那么么就是一个节点有摄像机一个节点已被监控
        if (val == 0) { // 此时说明左右两个节点都是空
            return 3; // 说明需要被监控
        }
        if (val < 3) { // 此时说明左右两个节点可能是两个摄像机（返回2），可能是有一个摄像机和一个空（或已被监控）（返回1）
            return 0;
        }
        cameraCountAnswer1++; // 此时加了摄像机，所以这个点返回是1，意思是已被监控
        return 1;
    }

    // 从叶子节点往上的第一节点放摄像头 然后每隔两个节点一个摄像头
    // 那就需要保持节点的状态
    // 未覆盖、有摄像头、已覆盖
    // 0 1 2
    // 空节点一定是已覆盖，避免是无覆盖的时候叶子节点放摄像头，也避免是有摄像头状态下叶子的父节点不用放 也就是默认值是2
    private static int cameraCountMy1 = 0; // 记录当前有多少个摄像机

    // Beats 100.00%
    private static int minCameraCoverMy1(TreeNode root) {
        int state = minCameraCoverMy1Helper(root);
        if (state == 0) {
            cameraCountMy1++;
        }
        return cameraCountMy1;
    }

    // 未覆盖、有摄像头、已覆盖
    // 0 1 2
    // 从底往上一共就三种情况
    // 左右孩子都被覆盖了，那么父节点一定是未覆盖
    // 左右孩子有一个已覆盖一个未覆盖，那么父节点一定是要放摄像头
    // 左右孩子有一个有摄像头，那么父节点一定是已覆盖
    // 最后还要处理根节点，如果根节点无覆盖，那就得加一个摄像头
    private static int minCameraCoverMy1Helper(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = minCameraCoverMy1Helper(node.left);
        int right = minCameraCoverMy1Helper(node.right);
        if (left == 0 || right == 0) { // 先判断0，因为0的状态最难进入
            cameraCountMy1++;
            return 1;
        }
        if (left == 1 || right == 1) { // 再判断1，因为0之后会进入1
            return 2;
        }
        if (left == 2 || right == 2) { // 最后判断2，因为最容易进入状态2
            return 0;
        }
        return -1;// 不可能到达
    }

    public static void main(String[] args) {
        int[][] rootSet = {
                {0, 0, Integer.MIN_VALUE, 0, 0},
                {0, 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, Integer.MIN_VALUE, 0},
        };
        int result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            cameraCountAnswer1 = 0;
            startTime = System.currentTimeMillis();
            result = minCameraCoverAnswer1(root);
            endTime = System.currentTimeMillis();
            System.out.println("minCameraCover Answer1 result" + i + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < rootSet.length; i++) {
            TreeNode root = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, rootSet[i]);
            cameraCountMy1 = 0;
            startTime = System.currentTimeMillis();
            result = minCameraCoverMy1(root);
            endTime = System.currentTimeMillis();
            System.out.println("minCameraCover My1 result" + i + " " + result + " during time " + (endTime - startTime));
        }
    }
}
