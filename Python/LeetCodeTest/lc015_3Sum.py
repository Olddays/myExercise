from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif sum > 0:
                    right -= 1
                else:
                    left += 1
        return result

    def threeSum_TimeLimit(self, nums: List[int]) -> List[List[int]]:
        result = []
        cache_map = {}
        for i in range(len(nums)):
            cache_map.setdefault(-nums[i], i)
        i = 0
        while i < len(nums):
            j = i + 1
            while j < len(nums):
                count = (nums[i] + nums[j])
                if count in cache_map and cache_map.get(count) not in [i, j]:
                    cache = [nums[i], nums[j], -count]
                    cache.sort()
                    if cache not in result:
                        result.append(cache)
                j += 1
            i += 1
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.threeSum([-1, 0, 1, 2, -1, -4])
    print(result)
