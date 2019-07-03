from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows = len(matrix)
        if rows == 0:
            return []
        if rows == 1:
            return matrix[0]
        columns = len(matrix[0])
        cycles = min(rows, columns) // 2 + min(rows, columns) % 2 # 转几圈
        result = []
        for c in range(cycles):
            for i in matrix[c][c: columns - c]: #上
                result.append(i)
            for i in range(c + 1, rows - c): #右
                result.append(matrix[i][columns - c - 1])
            if len(result) == columns * rows:
                 # 避免重复计算
                break
            i = columns - c - 2
            while i >= c: #下
                result.append(matrix[rows - c - 1][i])
                i -= 1
            i = rows - c - 2
            while i >= c + 1: #左
                result.append(matrix[i][c])
                i -= 1
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.spiralOrder([
        [2,5,8],
        [4,0,-1]
    ])
    print(result)
    result = solution.spiralOrder([
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12]
    ])
    print(result)
    result = solution.spiralOrder([
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12],
        [13, 14, 15, 16]
    ])
    print(result)
