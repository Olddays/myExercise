from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0:
            return [-1, -1]
        if n == 1 and nums[0] == target:
            return [0, 0]
        start = 0
        end = n - 1
        found = -1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                found = mid
                break
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        if found == -1:
            return [-1, -1]
        start = found
        left = 0
        left_end = found
        while left <= left_end:
            left_mid = left + (left_end - left) // 2
            if nums[left_mid] == target:
                start = left_mid
                left_end = left_mid - 1
            elif nums[left_mid] < target:
                left = left_mid + 1
        end = found
        right = n - 1
        right_start = found
        while right_start <= right:
            right_mid = right_start + (right - right_start) // 2
            if nums[right_mid] == target:
                end = right_mid
                right_start = right_mid + 1
            elif nums[right_mid] > target:
                right = right_mid - 1
        return [start, end]

if __name__ == "__main__":
    solution = Solution()
    result = solution.searchRange([1, 4], 4)
    print(result)
    result = solution.searchRange([1, 1], 1)
    print(result)
    result = solution.searchRange([1], 1)
    print(result)
    result = solution.searchRange([5, 7, 7, 8, 8, 10], 8)
    print(result)
    result = solution.searchRange([5, 7, 7, 8, 8, 10], 6)
    print(result)
