from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or target is None:
            return False
        m = len(matrix)
        n = len(matrix[0])
        low = 0
        high = m * n - 1
        while low <= high:
            mid = (low + high) // 2
            num = matrix[mid // n][mid % n]
            if num == target:
                return True
            elif num < target:
                low = mid + 1
            else:
                high = mid - 1
        return False

    def searchMatrix_slow(self, matrix: List[List[int]], target: int) -> bool:
        cache = []
        for line in matrix:
            cache.extend(line)
        i = 0
        j = len(cache) - 1
        if len(cache) == 0 or target < cache[0] or target > cache[j]:
            return False
        while i <= j:
            if cache[i] < target:
                i += 1
            elif cache[i] == target:
                return True
            if cache[i] > target:
                j -= 1
            elif cache[j] == target:
                return True
        return False

if __name__ == "__main__":
    solution = Solution()
    input = [
        [1],
        [3]
    ]
    result = solution.searchMatrix(input, 2)
    print(result)
