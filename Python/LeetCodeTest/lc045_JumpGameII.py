from typing import List

class Solution:
    # 应该是个树状结构，即比如：nums[0]=3那么就意味着0这个位置有三个分叉 分别是nums[1]、nums[2]、nums[3]，应该尝试深度优先
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2:
            return 0
        jumps = 0
        cur_max = 0
        next_max = 0
        i = 0
        while cur_max - i + 1 > 0:
            jumps += 1
            while i <= cur_max: # 能触及的最深位置
                next_max = max(next_max, nums[i] + i) # 下一个的最深位置
                if next_max >= n - 1: # 超过终点就返回
                    return jumps
                i += 1
            cur_max = next_max
        return 0

    def jump_error(self, nums: List[int]) -> int: # 使用了贪心的方式 每次都走最大的 但是不一定会得到正确答案
        jumps = 0
        cur_end = 0
        cur_farthest = 0
        for i in range(len(nums)):
            cur_farthest = max(cur_farthest, i + nums[i])
            if i == cur_end:
                jumps += 1
                cur_end = cur_farthest
        return jumps

if __name__ == "__main__":
    solution = Solution()
    result = solution.jump([2, 3, 1, 1, 4])
    print(result)
