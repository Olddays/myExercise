from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        table = [set()]
        for i in range(target):
            table.append(set())
        for i in candidates:
            if i > target:
                break
            for j in range(target - i, 0, -1):
                table[i + j] |= {elt + (i,) for elt in table[j]}
            table[i].add((i,))
        output = []
        for data in table[target]:
            output.append(list(data))
        return output

    def combinationSum2_timelimit(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        candidates.sort()
        self.doCombination(candidates, target, result, 0, [])
        return result

    def doCombination(self, candidates: List[int], target: int, result: List[List[int]], index: int, cache:  List[int]):
        if target == 0:
            if cache not in result:
                result.append(cache)
        else:
            if index >= len(candidates):
                return
            for i in range(index, len(candidates)):
                sep = candidates[i]
                if target >= sep:
                    new_cache = cache.copy()
                    new_cache.append(sep)
                    self.doCombination(candidates, target - sep, result, i + 1, new_cache)
                else:
                    self.doCombination(candidates, target, result, i + 1, cache)

if __name__ == "__main__":
    solution = Solution()
    result = solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8)
    print(result)
    result = solution.combinationSum2([2, 5, 2, 1, 2], 5)
    print(result)