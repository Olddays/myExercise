from typing import List

class Solution:
    def grayCode(self, n: int) -> List[int]:
        result = [0]
        for i in range(n):
            for x in reversed(result):
                result += [x + pow(2, i)]
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.grayCode(2)
    print(result)
    result = solution.grayCode(1)
    print(result)
