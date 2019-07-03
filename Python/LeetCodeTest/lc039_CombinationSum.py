from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        self.doCombination(candidates, target, result, 0, [])
        return result

    def doCombination(self, candidates: List[int], target: int, result: List[List[int]], index: int, cache:  List[int]):
        if target == 0:
            result.append(cache)
        else:
            for i in range(index, len(candidates)):
                sep = candidates[i]
                if target >= sep:
                    new_cache = cache.copy()
                    new_cache.append(sep)
                    self.doCombination(candidates, target - sep, result, i, new_cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.combinationSum([2, 3, 6, 7], 7)
    print(result)
    result = solution.combinationSum([2, 3, 5], 8)
    print(result)