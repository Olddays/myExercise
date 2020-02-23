# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if root:
            self.inorder(root, result)
        return result

    def inorder(self, root: TreeNode, result: List[int]):
        if root.left is not None:
            self.inorder(root.left, result)
        result.append(root.val)
        if root.right is not None:
            self.inorder(root.right, result)

if __name__ == "__main__":
    solution = Solution()
    input = TreeNode(1)
    input.left = TreeNode(2)
    input.right = TreeNode(3)
    input.left.left = TreeNode(4)
    input.left.right = TreeNode(5)
    input.right.left = TreeNode(6)
    result = solution.inorderTraversal(input)
    print(result)

