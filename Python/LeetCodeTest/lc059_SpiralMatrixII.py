from typing import List

class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        output = []
        for i in range(n):
            output.append([0] * n)
        cycle = n // 2 + 1
        index = 1
        for c in range(cycle):
            for i in range(c, n - c): # 上
                output[c][i] = index
                index += 1
            for i in range(c + 1, n - c): # 右
                output[i][n - 1 - c] = index
                index += 1
            if index == n * n + 1:
                break
            i = n - c - 2
            while i >= c: # 下
                output[n - 1 - c][i] = index
                index += 1
                i -= 1
            i = n - c - 2
            while i >= c + 1: # 左
                output[i][c] = index
                index += 1
                i -= 1
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.generateMatrix(1)
    print(result)
