from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool: # dfs 深度优先搜索
        if not board or not word or not board[0]:
            return False
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if self.doExist(board, i, j, word, 0):
                    return True
        return False

    def doExist(self, board: List[List[str]], i: int, j: int, word: str, index: int):
        if index == len(word):
            return True
        if i < 0 or j < 0 or i == len(board) or j == len(board[0]):
            return False
        if board[i][j] != word[index]:
            return False
        tmp = board[i][j]
        board[i][j] = "0"
        exist = self.doExist(board, i, j + 1, word, index + 1) \
                or self.doExist(board, i, j - 1, word, index + 1) \
                or  self.doExist(board, i + 1, j, word, index + 1) \
                or  self.doExist(board, i - 1, j, word, index + 1)
        board[i][j] = tmp
        return exist

if __name__ == "__main__":
    solution = Solution()
    result = solution.exist([["A","B","C","E"], ["S","F","C","S"], ["A","D","E","E"]], "ABCCED")
    print(result)
    result = solution.exist([["a","b"], ["c","d"]], "abcd")
    print(result)
