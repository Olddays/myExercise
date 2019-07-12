from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        self.backtrack(result, nums, 0, [])
        return result

    def backtrack(self, result: List[List[int]], nums: List[int], index: int, cache: List[int]):
        result.append(cache.copy())
        for i in range(index, len(nums)):
            new_cache = cache.copy()
            new_cache.append(nums[i])
            self.backtrack(result, nums, i + 1, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.subsets([1, 2, 3])
    print(result)
