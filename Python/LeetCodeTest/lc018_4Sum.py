from typing import List

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        result = []
        nums.sort()
        for i in range(len(nums) - 3):
            for j in range(i + 1, len(nums) - 2):
                left = j + 1
                right = len(nums) - 1
                while left < right:
                    count = nums[i] + nums[j] + nums[left] + nums[right]
                    if count == target:
                        cache = [nums[i], nums[j], nums[left], nums[right]]
                        if cache not in result:
                            result.append(cache)
                        while left < len(nums) - 1 and nums[left] == nums[left + 1]:
                            left += 1
                        while right > left and nums[right] == nums[right - 1]:
                            right -= 1
                        left += 1
                        right -= 1
                    elif count > target:
                        right -= 1
                    else:
                        left += 1
        return result

    def fourSum_Fast(self, nums, target):
        nums.sort()
        results = []
        self.findNsum(nums, target, 4, [], results)
        return results

    def findNsum(self, nums, target, N, result, results):
        if len(nums) < N or N < 2: return
        # solve 2-sum
        if N == 2:
            l, r = 0, len(nums) - 1
            while l < r:
                if nums[l] + nums[r] == target:
                    results.append(result + [nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                    while r > l and nums[r] == nums[r + 1]:
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1
        else:
            for i in range(0, len(nums) - N + 1):  # careful about range
                if target < nums[i] * N or target > nums[-1] * N:  # take advantages of sorted list
                    break
                if i == 0 or i > 0 and nums[i - 1] != nums[i]:  # recursively reduce N
                    self.findNsum(nums[i + 1:], target - nums[i], N - 1, result + [nums[i]], results)
        return

if __name__ == "__main__":
    solution = Solution()
    result = solution.fourSum([-3,-2,-1,0,0,1,2,3], 0)
    print(result)