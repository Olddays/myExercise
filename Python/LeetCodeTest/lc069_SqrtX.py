class Solution:
    def mySqrt(self, x: int) -> int:
        result = x
        while result * result > x:
            result = (result + x // result) // 2
        return result

if __name__ == "__main__":
    solution = Solution()
    print(solution.mySqrt(6))
    print(solution.mySqrt(8))
    print(solution.mySqrt(9))