
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp = [0] * n
        dp[0] = 1
        dp[1] = 2
        for i in range(2, n):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n - 1]

if __name__ == "__main__":
    solution = Solution()
    print(solution.climbStairs(1))
    print(solution.climbStairs(2))
    print(solution.climbStairs(3))
    print(solution.climbStairs(4))
    print(solution.climbStairs(5))