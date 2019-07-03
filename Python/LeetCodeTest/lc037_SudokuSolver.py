from typing import List

class Solution:
    usable_data = ["1", "2", "3", "4", "5", "6", "7", "8", "9"]
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.solve(board)

    def solve(self, board: List[List[str]]) -> bool:
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for c in self.usable_data:
                        if self.isValid(board, i, j, c):
                            board[i][j] = c
                            if self.solve(board):
                                return True
                            else:
                                board[i][j] = '.'
                    return False
        return True

    def isValid(self, board: List[List[str]], row: int, col: int, c: str) -> bool:
        for i in range(9):
            if board[i][col] != '.' and board[i][col] == c:
                return False
            if board[row][i] != '.' and board[row][i] == c:
                return False
            if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] != '.' \
                    and board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == c:
                return False
        return True

if __name__ == "__main__":
    solution = Solution()
    data = [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
    solution.solveSudoku(data)
    print(data)