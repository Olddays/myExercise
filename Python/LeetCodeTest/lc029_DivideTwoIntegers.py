class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        result = 0
        if dividend == 0:
            return result
        is_positive = (dividend < 0) is (divisor < 0)
        dividend = abs(dividend)
        divisor = abs(divisor)
        while dividend >= divisor:
            temp = divisor
            i = 1
            while dividend >= temp:
                dividend -= temp
                result += i
                i <<= 1
                temp <<= 1
        if not is_positive:
            result = -result
        return min(max(result, -(2 ** 31)), 2 ** 31 - 1)

    def divide_timelimit(self, dividend: int, divisor: int) -> int:
        result = 0
        if dividend == 0:
            return result
        is_positive = True
        if dividend < 0 and divisor < 0:
            divisor = -divisor
            dividend = -dividend
        elif dividend < 0:
            dividend = -dividend
            is_positive = False
        elif divisor < 0:
            divisor = -divisor
            is_positive = False
        while dividend >= divisor:
            dividend -= divisor
            if is_positive:
                result += 1
            else:
                result -= 1
        if result > 2 ** 31 - 1:
            return 2 ** 31 - 1
        elif result < -(2 ** 31):
            return -(2 ** 31)
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.divide(1, 1)
    print(result)
    result = solution.divide(10, 3)
    print(result)
