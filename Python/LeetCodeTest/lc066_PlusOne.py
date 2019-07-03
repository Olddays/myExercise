from typing import List

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        i = n - 1
        while i >= 0:
            digits[i] += 1
            if digits[i] // 10 == 1:
                digits[i] = 0
                i -= 1
                continue
            else:
                return digits
        digits.insert(0, 1)
        return digits

if __name__ == "__main__":
    solution = Solution()
    print(solution.plusOne([9, 9]))