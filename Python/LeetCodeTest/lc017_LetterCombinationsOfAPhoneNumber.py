from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        data_set = {'2': ['a', 'b', 'c'],
                    '3': ['d', 'e', 'f'],
                    '4': ['g', 'h', 'i'],
                    '5': ['j', 'k', 'l'],
                    '6': ['m', 'n', 'o'],
                    '7': ['p', 'q', 'r', 's'],
                    '8': ['t', 'u', 'v'],
                    '9': ['w', 'x', 'y', 'z']}
        output = [""]
        for i in digits:
            new_list = []
            for data in data_set.get(i):
                for cache in output:
                    for c in data:
                        new_list.append(cache + c)
            output = new_list
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.letterCombinations("23")
    print(result)
