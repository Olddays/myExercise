class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m = len(num1)
        n = len(num2)
        pos = [0] * (m + n)
        i = m - 1
        while i >= 0:
            j = n - 1
            while j >= 0:
                cache = int(num1[i]) * int(num2[j])
                p1 = i + j
                p2 = i + j + 1
                sum = cache + pos[p2]
                pos[p1] += sum // 10
                pos[p2] = sum % 10
                j -= 1
            i -= 1
        result = ""
        found = False
        for i in pos:
            if i != 0:
                found = True
            if found:
                result += str(i)
        if result != "":
            return result
        else:
            return "0"

if __name__ == "__main__":
    solution = Solution()
    result = solution.multiply("123", "456")
    print(result)