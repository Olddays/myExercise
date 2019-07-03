from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cache_list = []
        for i in range(9):
            for j in range(9):
                data = board[i][j]
                if data == ".":
                    continue
                row_str = data + " in row " + str(i)
                if row_str not in cache_list:
                    cache_list.append(row_str)
                else:
                    return False
                column_str = data + " in column " + str(j)
                if column_str not in cache_list:
                    cache_list.append(column_str)
                else:
                    return False
                block_str = data + " in block " + str(i // 3) + "-" + str(j // 3)
                if block_str not in cache_list:
                    cache_list.append(block_str)
                else:
                    return False
        return True

if __name__ == "__main__":
    solution = Solution()
    result = solution.isValidSudoku([
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
])
    print(result)
    result = solution.isValidSudoku([
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
])
    print(result)