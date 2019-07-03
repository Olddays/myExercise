from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        line_set = []
        row_set = []
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    line_set.append(i)
                    row_set.append(j)
        for i in line_set:
            for j in range(n):
                matrix[i][j] = 0
        for i in range(m):
            for j in row_set:
                matrix[i][j] = 0

if __name__ == "__main__":
    solution = Solution()
    input = [
        [0,1,2,0],
        [3,4,5,2],
        [1,3,1,5]
    ]
    solution.setZeroes(input)
    for line in input:
        print(line)
    print()
    input = [
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]
    solution.setZeroes(input)
    for line in input:
        print(line)

