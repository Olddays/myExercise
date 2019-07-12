from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for n in nums:
            if i < 2 or n > nums[i - 2]:
                nums[i] = n
                i += 1
        return i

    def removeDuplicates_verySlow(self, nums: List[int]) -> int:
        if not nums:
            return 0
        output = len(nums)
        cache = nums[0]
        count = 1
        i = 1
        while i < output:
            num = nums[i]
            if cache != num:
                cache = num
                if count > 2:
                    left = i - count + 2
                    for j in range(left, len(nums) - count + 2):
                        nums[j] = nums[j + count - 2]
                    i = left
                    output -= (count - 2)
                count = 1
            else:
                count += 1
            i += 1
        if count > 2:
            output -= (count - 2)
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.removeDuplicates([1,1,1])
    print(result)
    result = solution.removeDuplicates([0,0,1,1,1,1,2,3,3])
    print(result)
    result = solution.removeDuplicates([1,1,1,2,2,3])
    print(result)
