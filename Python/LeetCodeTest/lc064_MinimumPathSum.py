from typing import List

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = grid.copy()
        for i in range(1, m):
            dp[i][0] += dp[i - 1][0]
        for i in range(1, n):
            dp[0][i] += dp[0][i - 1]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] += min(dp[i][j - 1], dp[i - 1][j])
        return dp[m - 1][n - 1]

if __name__ == "__main__":
    solution = Solution()
    input = [
        [1, 2, 5],
        [3, 2, 1]
    ]
    result = solution.minPathSum(input)
    print(result)
    input = [
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1]
    ]
    result = solution.minPathSum(input)
    print(result)