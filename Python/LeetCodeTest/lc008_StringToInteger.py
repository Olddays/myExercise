class Solution:
    def myAtoi(self, str: str) -> int:
        cache = ""
        for c in str:
            if c >= '0' and c <= '9':
                cache += c
            elif (c == '-' or c == '+') and cache == "":
                cache += c
            elif c == ' ' and cache == "":
                continue
            else:
                break
        if cache == "" or cache == "-" or cache == "+" or cache.startswith("+-") or cache.startswith("-+"):
            return 0
        result = int(cache)
        if result >= 2 ** 31 - 1:
            return 2 ** 31 - 1
        elif result <= -(2 ** 31):
            return -(2 ** 31)
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.myAtoi("   +0 123")
    print(result)