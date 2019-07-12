from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        m = len(heights)
        less_from_left = [0] * m
        less_from_left[0] = -1
        i = 1
        while i < m:
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p = less_from_left[p]
            less_from_left[i] = p
            i += 1
        less_from_right = [0] * m
        less_from_right[m - 1] = m
        i = m - 2
        while i >= 0:
            p = i + 1
            while p < m and heights[p] >= heights[i]:
                p = less_from_right[p]
            less_from_right[i] = p
            i -= 1
        result = 0
        for i in range(0, m):
            result = max(result, heights[i] * (less_from_right[i] - less_from_left[i] - 1))
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.largestRectangleArea([2,1,5,6,2,3])
    print(result)
