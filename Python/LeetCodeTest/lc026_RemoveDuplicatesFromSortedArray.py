from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        result = 1
        cache = nums[0]
        for i in nums[1:]:
            if i == cache:
                continue
            else:
                nums[result] = i
                cache = i
                result += 1
        return result

if __name__ == "__main__":
    solution = Solution()
    nums = [0,0,1,1,1,2,2,3,3,4]
    result = solution.removeDuplicates(nums)
    print(nums)
    print(result)
