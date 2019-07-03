class Solution:
    def intToRoman(self, num: int) -> str:
        cache = num
        result = ""
        while cache > 0:
            if cache >= 1000:
                cache -= 1000
                result += "M"
            elif cache >= 900:
                cache -= 900
                result += "CM"
            elif cache >= 500:
                cache -= 500
                result += "D"
            elif cache >= 400:
                cache -= 400
                result += "CD"
            elif cache >= 100:
                cache -= 100
                result += "C"
            elif cache >= 90:
                cache -= 90
                result += "XC"
            elif cache >= 50:
                cache -= 50
                result += "L"
            elif cache >= 40:
                cache -= 40
                result += "XL"
            elif cache >= 10:
                cache -= 10
                result += "X"
            elif cache >= 9:
                cache -= 9
                result += "IX"
            elif cache >= 5:
                cache -= 5
                result += "V"
            elif cache >= 4:
                cache -= 4
                result += "IV"
            elif cache >= 1:
                cache -= 1
                result += "I"
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.intToRoman(1994)
    print(result)

