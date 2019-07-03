from typing import List

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        result_list = []
        nums.sort()
        for i in range(len(nums) - 2):
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == target:
                    return target
                elif sum > target:
                    right -= 1
                    result_list.append(sum)
                else:
                    left += 1
                    result_list.append(sum)
        result = result_list[0]
        for cache in result_list[1:]:
            diff = abs(target - result)
            new_diff = abs(target - cache)
            if new_diff < diff:
                result = cache
        return result
