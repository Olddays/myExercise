# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        return


if __name__ == "__main__":
    solution = Solution()
    input = TreeNode(2)
    input.left = TreeNode(1)
    input.right = TreeNode(3)
    result = solution.recoverTree(input)
    print(result)

    input = TreeNode(5)
    input.left = TreeNode(1)
    input.right = TreeNode(4)
    input.right.left = TreeNode(3)
    input.right.right = TreeNode(6)
    result = solution.recoverTree(input)
    print(result)

    input = TreeNode(10)
    input.left = TreeNode(5)
    input.right = TreeNode(15)
    input.right.left = TreeNode(6)
    input.right.right = TreeNode(20)
    result = solution.recoverTree(input)
    print(result)

