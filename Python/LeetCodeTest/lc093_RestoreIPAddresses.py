from typing import List

class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        result = []
        for a in range(1, 4):
            for b in range(1, 4):
                for c in range(1, 4):
                    for d in range(1, 4):
                        if a + b + c + d == len(s):
                            A = int(s[0: a])
                            B = int(s[a: a + b])
                            C = int(s[a + b: a + b + c])
                            D = int(s[a + b + c: a + b + c + d])
                            if A <= 255 and B <= 255 and C <= 255 and D <= 255:
                                cache = str(A) + "." + str(B) + "." + str(C) + "." + str(D)
                                if len(cache) == len(s) + 3:
                                    result.append(cache)
        return result

if __name__ == "__main__":
    solution = Solution()
    result = solution.restoreIpAddresses("25525511135")
    print(result)
