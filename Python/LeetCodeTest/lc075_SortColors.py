from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        red = 0
        white = 0
        blue = 0
        for i in nums:
            if i == 0:
                red += 1
            if i == 1:
                white += 1
            if i == 2:
                blue += 1
        index = 0
        for i in range(red):
            nums[index] = 0
            index += 1
        for i in range(white):
            nums[index] = 1
            index += 1
        for i in range(blue):
            nums[index] = 2
            index += 1

if __name__ == "__main__":
    solution = Solution()
    input = [2,0,2,1,1,0]
    solution.sortColors(input)
    print(input)
    input = []
    solution.sortColors(input)
    print(input)
