from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 0:
            return 0
        for i in range(n):
            if nums[i] >= target:
                return i
        if nums[n - 1] < target:
            return n
        return 0

if __name__ == "__main__":
    solution = Solution()
    result = solution.searchInsert([1, 3], 2)
    print(result)
    result = solution.searchInsert([1, 3, 5, 6], 4)
    print(result)
    result = solution.searchInsert([1, 3, 5, 6], 3)
    print(result)
    result = solution.searchInsert([1, 3, 5, 6], 7)
    print(result)
