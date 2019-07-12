from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k == 0:
            return [[]]
        return [pre + [i] for i in range(k, n + 1) for pre in self.combine(i - 1, k - 1)]

    def combine_almostTimeLimit(self, n: int, k: int) -> List[List[int]]:
        output = []
        usable = []
        for i in range(1, n + 1):
            usable.append(i)
        self.doCombine_almostTimeLimit(output, usable, k, 0, [])
        return output

    def doCombine_almostTimeLimit(self, output: List[List[int]], usable: List[int], k: int, index: int, cache: List[int]):
        if len(cache) == k:
            output.append(cache)
        else:
            for i in range(index, len(usable)):
                data = usable[i]
                new_cache = cache.copy()
                if data not in new_cache:
                    new_cache.append(data)
                    self.doCombine_almostTimeLimit(output, usable, k, i, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.combine(4, 2)
    print(result)
    result = solution.combine(13, 13)
    print(result)
