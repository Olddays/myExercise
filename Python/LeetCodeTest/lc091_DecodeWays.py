class Solution:
    def numDecodings(self, s: str) -> int:
        if not s:
            return 0
        n = len(s)
        dp = [0] * (n + 1)
        dp[0] = 1
        if s[0] != '0':
            dp[1] = 1
        else:
            dp[1] = 0
        for i in range(2, n + 1):
            first = int(s[i - 1: i])
            second = int(s[i - 2: i])
            if 9 >= first >= 1:
                dp[i] += dp[i - 1]
            if 26 >= second >= 10:
                dp[i] += dp[i - 2]
        return dp[n]

if __name__ == "__main__":
    solution = Solution()
    result = solution.numDecodings("226")
    print(result)
