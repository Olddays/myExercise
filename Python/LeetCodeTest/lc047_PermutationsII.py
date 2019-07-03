from typing import List

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        n = len(nums)
        used_list = [False] * n
        self.getPermu(nums, n, result, [], used_list)
        return result

    def getPermu(self, nums: List[int], n: int, result: List[List[int]], cache: List[int], used: List[bool]):
        if len(cache) == n:
            result.append(cache.copy())
        else:
            for i in range(n):
                if used[i] or i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                used[i] = True
                new_cache = cache.copy()
                new_cache.append(nums[i])
                self.getPermu(nums, n, result, new_cache, used)
                used[i] = False

    def permuteUnique_stupidway(self, nums: List[int]) -> List[List[int]]: # 可以用，但是很慢，而且很蠢
        index = []
        n = len(nums)
        self.getPermu_stupidway(n, index, [])
        result = []
        for data in index:
            cache = []
            for i in data:
                cache.append(nums[i])
            if cache in result:
                continue
            result.append(cache)
        return result

    def getPermu_stupidway(self, n: int, result: List[List[int]], cache: List[int]):
        if len(cache) == n:
            result.append(cache.copy())
        else:
            for i in range(n):
                if i in cache:
                    continue
                new_cache = cache.copy()
                new_cache.append(i)
                self.getPermu_stupidway(n, result, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.permuteUnique([1, 1, 3])
    print(result)
