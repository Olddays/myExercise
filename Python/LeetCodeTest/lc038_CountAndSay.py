class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        i = 1
        output = "1"
        while i < n:
            cache = ""
            count = 0
            cache_output = ""
            for c in output:
                if c != cache:
                    if count > 0:
                        cache_output += str(count) + cache
                    cache = c
                    count = 1
                else:
                    count += 1
            if count > 0:
                cache_output += str(count) + cache
            output = cache_output
            i += 1
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.countAndSay(30)
    print(result)