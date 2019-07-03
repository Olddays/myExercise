class Solution:
    def isValid(self, s: str) -> bool:
        data_set = {'(': ')', '{': '}', '[': ']'}
        cache_list = []
        for c in s:
            if c in data_set:
                cache_list.append(data_set.get(c))
            elif len(cache_list) > 0 and c == cache_list[-1]:
                cache_list = cache_list[:-1]
            else:
                return False
        return len(cache_list) == 0

    def isValid_sample(self, s: str) -> bool:
        while "()" in s or "{}" in s or '[]' in s:
            s = s.replace("()", "").replace('{}', "").replace('[]', "")
        return s == ''

if __name__ == "__main__":
    solution = Solution()
    result = solution.isValid("()")
    print(result)
    result = solution.isValid("()[]{}")
    print(result)
    result = solution.isValid("(]")
    print(result)
    result = solution.isValid("([)]")
    print(result)
    result = solution.isValid("{()}")
    print(result)
    result = solution.isValid("({})")
    print(result)
    result = solution.isValid("{")
    print(result)
