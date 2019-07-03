class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        n = len(s)
        m = len(p)
        i = 0
        j = 0
        match = 0
        start_id = -1
        while i < n:
            if j < m and (p[j] == s[i] or p[j] == '?'):
                i += 1
                j += 1
            elif j < m and p[j] == '*':
                start_id = j
                match = i
                j += 1
            elif start_id != -1:
                j = start_id + 1
                match += 1
                i = match
            else:
                return False
        while j < m and p[j] == '*':
            j += 1
        return j == m

    def isMatch_error(self, s: str, p: str) -> bool: # 无法处理"abefcdgiescdfimde", "ab*cd?i*de"，需要回溯
        n = len(s)
        m = len(p)
        if n == 0 or m == 0:
            return False
        i = 0
        j = 0
        while i < n and j < m:
            c = s[i]
            k = p[j]
            if k == c or k == '?':
                i += 1
                j += 1
            elif k == '*' and j < m:
                if i > 0:
                    i += 1
                while i < n and (j < m - 1 and s[i] != p[j + 1] or j == m - 1):
                    i += 1
                j += 1
            else:
                break
        if i == n and j == m:
            return True
        return False

if __name__ == "__main__":
    solution = Solution()
    result = solution.isMatch("", "")
    print(result)
    result = solution.isMatch("", "*")
    print(result)
    result = solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de")
    print(result)
    result = solution.isMatch("zacabz", "*a?b*")
    print(result)
    result = solution.isMatch("adceb", "*a*b")
    print(result)
    result = solution.isMatch("acdcb", "a*c?b")
    print(result)
    result = solution.isMatch("aa", "?")
    print(result)
    result = solution.isMatch("cb", "?a")
    print(result)
    result = solution.isMatch("adceb", "*")
    print(result)
    result = solution.isMatch("adceb", "a*b")
    print(result)