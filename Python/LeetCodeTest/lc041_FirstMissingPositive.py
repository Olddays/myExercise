from typing import List

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 1
        nums.sort()
        cache = 1
        for i in nums:
            if i == cache:
                cache += 1
            elif i > cache:
                return cache
        return cache

if __name__ == "__main__":
    solution = Solution()
    result = solution.firstMissingPositive([1, 2, 0])
    print(result)
    result = solution.firstMissingPositive([3, 4, -1, 1])
    print(result)
    result = solution.firstMissingPositive([7, 8, 9, 11, 12])
    print(result)