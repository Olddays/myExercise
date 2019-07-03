class Solution:
    def romanToInt(self, s: str) -> int:
        roman_map = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
        result = 0
        cache = ''
        for c in s:
            subtractor = 0
            if cache != '':
                subtractor = roman_map.get(cache)
            data = roman_map.get(c)
            if subtractor < data:
                result += data - subtractor * 2
            else:
                result += data
            cache = c
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.romanToInt("MCMXCIV")
    print(result)
