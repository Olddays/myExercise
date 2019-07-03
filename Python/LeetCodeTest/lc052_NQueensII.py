from typing import List

class Solution:
    def totalNQueens(self, n: int) -> int:
        result = []
        self.DFS(n, result, [], [], [])
        return len(result)

    def DFS(self, n, result, queens, xy_dif, xy_sum):
        p = len(queens)
        if p == n:
            result.append(queens)
            return None
        for q in range(n):
            if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                self.DFS(n, result, queens + [q], xy_dif + [p - q], xy_sum + [p + q])

if __name__ == "__main__":
    solution = Solution()
    result = solution.totalNQueens(4)
    print(result)
