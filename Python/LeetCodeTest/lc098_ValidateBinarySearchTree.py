# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root:
            dataSet = []
            self.doCheck(root, dataSet)
            for i in range(len(dataSet) - 1):
                if dataSet[i] >= dataSet[i + 1]:
                    return False
        return True

    def doCheck(self, root: TreeNode, dataSet: List[int]):
        if root.left:
            self.doCheck(root.left, dataSet)
        dataSet.append(root.val)
        if root.right:
            self.doCheck(root.right, dataSet)


if __name__ == "__main__":
    solution = Solution()
    input = TreeNode(2)
    input.left = TreeNode(1)
    input.right = TreeNode(3)
    result = solution.isValidBST(input)
    print(result)

    input = TreeNode(5)
    input.left = TreeNode(1)
    input.right = TreeNode(4)
    input.right.left = TreeNode(3)
    input.right.right = TreeNode(6)
    result = solution.isValidBST(input)
    print(result)

    input = TreeNode(10)
    input.left = TreeNode(5)
    input.right = TreeNode(15)
    input.right.left = TreeNode(6)
    input.right.right = TreeNode(20)
    result = solution.isValidBST(input)
    print(result)
