from typing import List

class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        output = ""
        usable = []
        for i in range(1, n + 1):
            usable.append(i)
        factorial = [1]
        sum = 1
        for i in range(1, n + 1):
            sum *= i
            factorial.append(sum)
        k -= 1
        for i in range(1, n + 1):
            index = k // factorial[n - i]
            output += str(usable[index])
            usable.remove(usable[index])
            k -= index * factorial[n - i]
        return output

    def getPermutation_timelimited2(self, n: int, k: int) -> str:
        output = []
        usable = []
        for i in range(1, n + 1):
            usable.append(i)
        self.permutation_timelimited2(usable, output, n, k, [], [])
        return output[-1]

    def permutation_timelimited2(self, usable: List[int], output: List[str], n: int, k: int, cache: List[int], used: List[int]) -> bool:
        if len(cache) == n:
            cache_str = ""
            for i in cache:
                cache_str += str(i)
            output.append(cache_str)
            if k == len(output):
                return True
        else:
            for i in range(n):
                if usable[i] not in used:
                    new_cache = cache.copy()
                    new_cache.append(usable[i])
                    new_used = used.copy()
                    new_used.append(usable[i])
                    result = self.permutation_timelimited2(usable, output, n, k, new_cache, new_used)
                    if result:
                        return result

    def getPermutation_timelimited(self, n: int, k: int) -> str:
        output = []
        usable = []
        for i in range(1, n + 1):
            usable.append(i)
        self.permutation_timelimited(usable, output, n, [], [])
        print(output)
        return output[k - 1]

    def permutation_timelimited(self, usable: List[int], output: List[str], n: int, cache: List[int], used: List[int]):
        if len(cache) == n:
            cache_str = ""
            for i in cache:
                cache_str += str(i)
            output.append(cache_str)
        else:
            for i in range(n):
                if usable[i] not in used:
                    new_cache = cache.copy()
                    new_cache.append(usable[i])
                    new_used = used.copy()
                    new_used.append(usable[i])
                    self.permutation_timelimited(usable, output, n, new_cache, new_used)

if __name__ == "__main__":
    solution = Solution()
    result = solution.getPermutation(4, 4)
    print(result)

