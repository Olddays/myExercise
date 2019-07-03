class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if len(a) < len(b):
            tmp = a
            a = b
            b = tmp
        m = len(a)
        n = len(b)
        i = n - 1
        tmp = 0
        output = ""
        while i >= 0:
            j = m + i - n
            x = int(a[j])
            y = int(b[i])
            sum = x + y + tmp
            output = str(sum % 2) + output
            tmp = sum // 2
            i -= 1
        i = m - n - 1
        while i >= 0:
            sum = tmp + int(a[i])
            output = str(sum % 2) + output
            tmp = sum // 2
            i -= 1
        if tmp == 1:
            output = "1" + output
        return output

if __name__ == "__main__":
    solution = Solution()
    print(solution.addBinary("100", "110010"))
    print(solution.addBinary("111", "1"))
    print(solution.addBinary("1010", "1011"))