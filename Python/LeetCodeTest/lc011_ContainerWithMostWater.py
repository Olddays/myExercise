from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        result_list = []
        i = 0
        j = len(height) - 1
        while i < j:
            result_list.append(min(height[i], height[j]) * (j - i))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return max(result_list)

    def maxArea_TimeLimit(self, height: List[int]) -> int:
        result = 0
        for i in range(len(height) - 1):
            for j in range(i + 1, len(height)):
                cache = min(height[i], height[j]) * (j - i)
                result = max(cache, result)
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])
    print(result)