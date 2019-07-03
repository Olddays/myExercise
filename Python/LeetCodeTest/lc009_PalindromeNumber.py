class Solution:
    def isPalindrome(self, x: int) -> bool:
        cache = str(x)
        for i in range(len(cache) // 2):
            if cache[i] != cache[len(cache) - i - 1]:
                return False
        return True

if __name__ == "__main__":
    solution = Solution()
    result = solution.isPalindrome(12344321)
    print(result)
