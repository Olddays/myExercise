from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        # find the smallest num
        # the smallest num when nums[low] == nums[high]
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        smallest = low
        if nums[smallest] == target:
            return smallest
        low = 0
        if target <= nums[-1]:
            low = smallest
        high = len(nums) - 1
        if target > nums[-1]:
            high = smallest
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                return mid
            if target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1

if __name__ == "__main__":
    solution = Solution()
    result = solution.search([1, 3], 3)
    print(result)
    result = solution.search([5, 1, 3], 1)
    print(result)
    result = solution.search([3, 1], 0)
    print(result)
    result = solution.search([4, 5, 6, 7, 0, 1, 2], 0)
    print(result)
