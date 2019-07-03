class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s) == 0:
            return 0
        dp = []
        for i in range(len(s)):
            dp.append(0)
        for i in range(1, len(s)):
            if s[i] == ')' and s[i - 1] == '(':
                dp[i] = dp[i - 2] + 2
            elif s[i] == ')' and s[i - 1] == ')':
                target = i - dp[i - 1] - 1
                if target >= 0:
                    if s[target] == '(':
                        second = 0
                        if target >= 1:
                            second = dp[target - 1]
                        dp[i] = dp[i - 1] + second + 2
        return max(dp)

if __name__ == "__main__":
    solution = Solution()
    result = solution.longestValidParentheses("(()))())(")
    print(result)
    result = solution.longestValidParentheses("())")
    print(result)
    result = solution.longestValidParentheses(")()())")
    print(result)
    result = solution.longestValidParentheses("(()())")
    print(result)
    result = solution.longestValidParentheses("()((((()))")
    print(result)
    result = solution.longestValidParentheses("(()")
    print(result)
    result = solution.longestValidParentheses("()(()")
    print(result)
