# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n < 1:
            return []
        return self.getTrees(1, n)

    def getTrees(self, start: int, end: int):
        result = []
        if start > end:
            result.append(None)
            return result
        if start == end:
            result.append(TreeNode(start))
            return result
        i = start
        while i <= end:
            left = self.getTrees(start, i - 1)
            right = self.getTrees(i + 1, end)
            for leftNode in left:
                for rightNode in right:
                    root = TreeNode(i)
                    root.left = leftNode
                    root.right = rightNode
                    result.append(root)
            i += 1
        return result

    def preorder(self, node: TreeNode):
        if node:
            print(node.val)
        if node.left:
            self.preorder(node.left)
        if node.right:
            self.preorder(node.right)

if __name__ == "__main__":
    solution = Solution()
    result = solution.generateTrees(3)
    print(len(result))
    print()
    for node in result:
        solution.preorder(node)
        print()

