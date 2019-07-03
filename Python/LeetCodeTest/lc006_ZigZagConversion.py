class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if s is None or len(s) == 0 or numRows == 1:
            return s
        data = []
        for i in range(numRows):
            data.append("")
        line_num = 0
        positive = True
        for i in range(len(s)):
            data[line_num] += s[i]
            if line_num == numRows - 1:
                positive = False
            elif line_num == 0:
                positive = True
            if positive:
                line_num += 1
            else:
                line_num -= 1
        return "".join(data)

if __name__ == "__main__":
    solution = Solution()
    result = solution.convert("ABC", 1)
    print(result)