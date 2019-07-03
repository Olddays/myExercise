from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        nums.sort()
        found_start = False
        start = 0
        end = len(nums)
        for i in range(len(nums)):
            if nums[i] == val and not found_start:
                start = i
                found_start = True
            elif found_start and nums[i] != val:
                end = i
                break
        if found_start:
            j = 0
            for i in range(end, len(nums)):
                nums[start + j] = nums[i]
                j += 1
            return len(nums) - end + start
        else:
            return len(nums)

if __name__ == "__main__":
    solution = Solution()
    nums = [3, 2, 2, 3]
    result = solution.removeElement(nums, 2)
    print(nums)
    print(result)
    nums = [2]
    result = solution.removeElement(nums, 3)
    print(nums)
    print(result)
