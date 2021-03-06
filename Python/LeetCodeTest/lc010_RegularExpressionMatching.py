class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        if not p:
            return not s
        first_match = bool(s) and p[0] in {s[0], '.'}
        if len(p) >= 2 and p[1] == '*':
            return (self.isMatch(s, p[2:]) or
                    first_match and self.isMatch(s[1:], p))
        else:
            return first_match and self.isMatch(s[1:], p[1:])

    def isMatch_DP(self, s: str, p: str) -> bool:
        memo = {}
        def dp(i, j):
            if (i, j) not in memo:
                if j == len(p):
                    ans = i == len(s)
                else:
                    first_match = i < len(s) and p[j] in {s[i], '.'}
                    if j + 1 < len(p) and p[j + 1] == '*':
                        ans = dp(i, j + 2) or first_match and dp(i + 1, j)
                    else:
                        ans = first_match and dp(i + 1, j + 1)
                memo[i, j] = ans
            return memo[i, j]
        return dp(0, 0)

    def isMatch_error(self, s: str, p: str) -> bool:
        parts = p.split('*')
        k = 0
        l = 0
        for i in range(len(parts)):
            part = parts[i]
            if part != "" and k < len(s):
                for j in range(len(part) - 1):
                    if k < len(s) and (part[j] == '.' or s[k] == part[j]):
                        k += 1
                        l += 1
                    else:
                        return False
                cache_c = part[-1]
                if i != len(parts) - 1 or (i == len(parts) - 1 and p[-1] == '*'):
                    l += 2
                    while k < len(s) and (s[k] == cache_c or cache_c == '.'):
                        k += 1
                else:
                    if k < len(s) and s[k] == cache_c or cache_c == '.':
                        l += 1
                        k += 1
        if k == len(s) and l == len(p):
            return True
        return False

if __name__ == "__main__":
    solution = Solution()
    result = solution.isMatch("ab", ".*b")
    print(result)
    result = solution.isMatch("aa", ".*c")
    print(result)
    result = solution.isMatch("c", ".*c")
    print(result)
    result = solution.isMatch("aa", "a")
    print(result)
    result = solution.isMatch("aa", "aa")
    print(result)
    result = solution.isMatch("aa", "aaa")
    print(result)
    result = solution.isMatch("bb", ".bab")
    print(result)
    result = solution.isMatch("a", "a*")
    print(result)
    result = solution.isMatch("aa", "a*")
    print(result)
    result = solution.isMatch("aab", "c*a*b")
    print(result)
    result = solution.isMatch("mississippi", "mis*is*p*.")
    print(result)
    result = solution.isMatch("mississippi", "mis*is*ip*.")
    print(result)
    result = solution.isMatch("aaa", "a*a")
    print(result)
