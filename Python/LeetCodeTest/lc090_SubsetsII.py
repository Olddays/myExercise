from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        nums.sort()
        l = 0
        for i in range(len(nums)):
            if i == 0 or nums[i] != nums[i - 1]:
                l = len(res)
            for j in range(len(res) - l, len(res)):
                res.append(res[j] + [nums[i]])
        return res

    def subsetsWithDup_slow(self, nums: List[int]) -> List[List[int]]:
        result = []
        self.getSubsets_slow(nums, result, 0, [])
        return result

    def getSubsets_slow(self, nums: List[int], result: List[List[int]], index: int, cache: List[int]):
        cache.sort()
        if cache not in result:
            result.append(cache)
        for i in range(index, len(nums)):
            new_cache = cache.copy()
            new_cache.append(nums[i])
            self.getSubsets_slow(nums, result, i + 1, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.subsetsWithDup([1, 2, 2])
    print(result)
    result = solution.subsetsWithDup([1])
    print(result)
