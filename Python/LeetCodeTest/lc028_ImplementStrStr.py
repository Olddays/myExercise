class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack is None or needle is None:
            return -1
        if needle == haystack:
            return 0
        elif needle in haystack:
            if len(needle) == 0:
                return 0
            for i in range(len(haystack)):
                c = haystack[i]
                if c == needle[0]:
                    found_result = True
                    for j in range(len(needle)):
                        if haystack[i + j] != needle[j]:
                            found_result = False
                            break
                    if found_result:
                        return i
        return -1

if __name__ == "__main__":
    solution = Solution()
    result = solution.strStr("hello", "ll")
    print(result)
    result = solution.strStr("aaaaa", "aaaaaaaaaaaaa")
    print(result)
    result = solution.strStr("a", "")
    print(result)
