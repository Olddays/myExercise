class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        n = len(s)
        if n == 0:
            return 0
        i = n - 1
        cache = ""
        while i >= 0:
            if s[i] == ' ' and cache != "":
                return len(cache)
            elif s[i] != " ":
                cache = cache + s[i]
            i -= 1
        return len(cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.lengthOfLastWord("a ")
    print(result)