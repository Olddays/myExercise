from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool: # 深度搜索
        n = len(nums)
        if n < 2:
            return True
        cur_max = 0
        next_max = 0
        i = 0
        while cur_max - i + 1 > 0:
            while i <= cur_max: # 能触及的最深位置
                next_max = max(next_max, nums[i] + i) # 下一个的最深位置
                if next_max >= n - 1: # 超过终点就返回
                    return True
                i += 1
            cur_max = next_max
        return False

if __name__ == "__main__":
    solution = Solution()
    result = solution.canJump([2, 3, 1, 1, 4])
    print(result)
