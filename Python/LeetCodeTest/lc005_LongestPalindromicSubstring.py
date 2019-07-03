class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        size = len(s)
        start = 0
        end = 0
        for i in range(size):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i + 1)
            length = max(len1, len2)
            if length > end - start:
                start = i - (length - 1) // 2
                end = i + length // 2
        return s[start: end +1]

    def expandAroundCenter(self, s: str, left: int, right: int):
        a = left
        b = right
        while a >= 0 and b < len(s) and s[a] == s[b]:
            a -= 1
            b += 1
        return b - a - 1

if __name__ == "__main__":
    solution = Solution()
    result = solution.longestPalindrome("aaa")
    print(result)

