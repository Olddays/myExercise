from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        height = [0] * (n + 1)
        result = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":
                    height[j] = height[j] + 1 # 针对每一行算出每个位置上可能的最大长度（连接在一起则+1，否则为0）
                else:
                    height[j] = 0
            stack = [-1]
            for i in range(n + 1): # 针对每一列计算列最大的长度，然后进行矩阵大小的计算（连接在一起则+1，否则为0）
                while height[i] < height[stack[-1]]:
                    h = height[stack.pop()]
                    w = i - 1 - stack[-1]
                    result = max(result, h * w)
                stack.append(i)
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.maximalRectangle([
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]
    ])
    print(result)
    result = solution.maximalRectangle([
        ["0","0","1","0"],
        ["1","1","1","1"],
        ["1","1","1","1"],
        ["1","1","1","0"],
        ["1","1","0","0"],
        ["1","1","1","1"],
        ["1","1","1","0"]
    ])
    print(result)
