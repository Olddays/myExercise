from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if strs is None or len(strs) < 1:
            return ""
        if len(strs) == 1:
            return strs[0]
        first = strs[0]
        result = ""
        for i in range(len(first)):
            c = first[i]
            has_result = True
            for s in strs[1:]:
                if i ==len(s) or c != s[i]:
                    has_result = False
                    break
            if has_result:
                result += c
            else:
                return result
        return result

    def longestCommonSubstring(self, strs: List[str]) -> str:
        if strs is None or len(strs) < 1:
            return ""
        if len(strs) == 1:
            return strs[0]
        result_cache = []
        first = strs[0]
        i = 0
        while i < len(first):
            c = first[i]
            for str in strs[1:]:
                if c not in str:
                    break
            j = len(first) + 1
            while j > i:
                substring = first[i: j]
                j -= 1
                has_result = True
                for str in strs[1:]:
                    if substring not in str:
                        has_result = False
                        break
                if has_result:
                    result_cache.append(substring)
                    i = j
                    break
            i += 1
        result = ""
        for cache in result_cache:
            if len(cache) > len(result):
                result = cache
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.longestCommonPrefix(["frlowerrrr","frlowrrrr","frlightrrrr"])
    print(result)
    result = solution.longestCommonPrefix(["dog","racecar","car"])
    print(result)
    result = solution.longestCommonPrefix(["a"])
    print(result)
    result = solution.longestCommonPrefix(["ca", "a"])
    print(result)
