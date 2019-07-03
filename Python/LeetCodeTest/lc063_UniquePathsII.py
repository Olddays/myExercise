from typing import List

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = []
        for i in range(m):
            dp.append([0] * n)
        for i in range(n):
            if obstacleGrid[0][i] == 1:
                break
            dp[0][i] = 1
        for i in range(m):
            if obstacleGrid[i][0] == 1:
                break
            dp[i][0] = 1
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] != 1:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                else:
                    dp[i][j] = 0
        return dp[m - 1][n - 1]

if __name__ == "__main__":
    solution = Solution()
    input = [
        [0,0,0],
        [0,1,0],
        [0,0,0]
    ]
    result = solution.uniquePathsWithObstacles(input)
    print(result)
