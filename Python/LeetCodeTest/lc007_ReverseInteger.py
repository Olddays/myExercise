class Solution:
    def reverse(self, x: int) -> int:
        s = str(x)
        result = ""
        if '-' in s:
            result = "-"
            s = s[1:]
        for i in range(len(s) - 1, -1, -1):
            result += s[i]
        result = int(result)
        if result >= 2 ** 31 - 1 or result <= -(2 ** 31):
            return 0
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.reverse(1534236469)
    print(result)