from typing import List

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 2
        while i >= 0 and nums[i + 1] <= nums[i]:
            i -= 1
        if i >= 0:
            j = len(nums) - 1
            while j >= 0 and nums[j] <= nums[i]:
                j -= 1
            cache = nums[i]
            nums[i] = nums[j]
            nums[j] = cache
        i = i + 1
        j = len(nums) - 1
        while i < j:
            cache = nums[i]
            nums[i] = nums[j]
            nums[j] = cache
            i += 1
            j -= 1
