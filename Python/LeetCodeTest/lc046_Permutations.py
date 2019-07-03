from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        n = len(nums)
        self.getPermu(nums, n, result, [])
        return result

    def getPermu(self, nums: List[int], n: int, result: List[List[int]], cache: List[int]):
        if len(cache) == n:
            result.append(cache.copy())
        else:
            for i in range(n):
                if nums[i] in cache:
                    continue
                new_cache = cache.copy()
                new_cache.append(nums[i])
                self.getPermu(nums, n, result, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.permute([1, 2, 3])
    print(result)
