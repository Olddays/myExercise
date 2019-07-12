from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums:
            return False
        m = len(nums)
        if target < nums[0]:
            i = m - 1
            while i > 0:
                num = nums[i]
                if num > target:
                    i -= 1
                elif num == target:
                    return True
                else:
                    return False
        elif target > nums[-1]:
            i = 0
            while i < m:
                num = nums[i]
                if num < target:
                    i += 1
                elif num == target:
                    return True
                else:
                    return False
        else:
            i = 0
            while i < m:
                num = nums[i]
                if num == target:
                    return True
                i += 1
        return False

if __name__ == "__main__":
    solution = Solution()
    result = solution.search([1,3], 2)
    print(result)
    result = solution.search([1,3], 3)
    print(result)
    result = solution.search([1], 1)
    print(result)
    result = solution.search([1], 0)
    print(result)
    result = solution.search([2,5,6,0,0,1,2], 0)
    print(result)
    result = solution.search([2,5,6,0,0,1,2], 3)
    print(result)
