from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n <= 1:
            return 0
        result = 0
        left_max = [0] * n
        right_max = [0] * n
        left_max[0] = height[0]
        for i in range(1, n):
            left_max[i] = max(height[i], left_max[i - 1])
        right_max[n - 1] = height[n - 1]
        i = n - 2
        while i >= 0:
            right_max[i] = max(height[i], right_max[i + 1])
            i -= 1
        for i in range(1, n):
            result += min(left_max[i], right_max[i]) - height[i]
        return result

    def trap_timelimit(self, height: List[int]) -> int:
        n = len(height)
        if n <= 1:
            return 0
        result = 0
        for i in range(1, n):
            max_left = 0
            j = i
            while j >= 0:
                max_left = max(max_left, height[j])
                j -= 1
            max_right = 0
            j = i
            while j < n:
                max_right = max(max_right, height[j])
                j += 1
            result += min(max_left, max_right) - height[i]
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.trap([2, 0, 2])
    print(result)
    result = solution.trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])
    print(result)
    result = solution.trap([5, 4, 1, 2])
    print(result)
