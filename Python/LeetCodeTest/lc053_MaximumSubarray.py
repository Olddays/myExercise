from typing import List

class Solution:
    # dp[1]是否要加上dp[0]取决于dp[1]是否为正数，以此类推dp[n]是否要加上dp[n-1]取决于当前的dp[n-1]是否大于0，
    # 而这一要求又保证了dp[n]中的数字是当前能求得的包含nums[n]的连续子元素和的最大值
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        dp = nums.copy()
        for i in range(1, n):
            cache = 0
            if dp[i - 1] > 0:
                cache = dp[i - 1]
            dp[i] += cache
        return max(dp)

if __name__ == "__main__":
    solution = Solution()
    result = solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
    print(result)
