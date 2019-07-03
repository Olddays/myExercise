from typing import List

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        start = 0
        end = n - 1
        while start < end:
            tmp = matrix[start]
            matrix[start] = matrix[end]
            matrix[end] = tmp
            start += 1
            end -= 1
        for i in range(n):
            for j in range(i + 1, n):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp

if __name__ == "__main__":
    solution = Solution()
    input = [
        [1,2,3],
        [4,5,6],
        [7,8,9]
    ]
    solution.rotate(input)
    print(input)