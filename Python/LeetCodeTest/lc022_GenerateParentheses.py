from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        negative = 0
        positive = 0
        self.recursion(n, positive, negative, result, "")
        return result

    def recursion(self, n: int, positive: int, negative: int, result: List[str], cache: str):
        if len(cache) == n * 2:
            result.append(cache)
        else:
            if negative == positive and positive < n:
                self.recursion(n, positive + 1, negative, result, cache + '(')
            elif positive == negative == n:
                self.recursion(n, positive, negative + 1, result, cache + ')')
            else:
                if positive < n:
                    self.recursion(n, positive + 1, negative, result, cache + '(')
                if negative < n:
                    self.recursion(n, positive, negative + 1, result, cache + ')')

if __name__ == "__main__":
    solution = Solution()
    result = solution.generateParenthesis(3)
    print(result)
