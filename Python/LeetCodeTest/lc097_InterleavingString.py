class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s3) != len(s1) + len(s2):
            return False
        dp = [False] * (len(s2) + 1)
        for i in range(0, len(s1) + 1):
            for j in range(0, len(s2) + 1):
                if i == 0 and j == 0:
                    dp[j] = True
                elif i == 0:
                    dp[j] = dp[j - 1] and s2[j - 1] == s3[i + j - 1]
                elif j == 0:
                    dp[j] = dp[j] and s1[i - 1] == s3[i + j - 1]
                else:
                    dp[j] = (dp[j] and s1[i - 1] == s3[i + j - 1]) or (dp[j - 1] and s2[j - 1] == s3[i + j - 1])
        return dp[len(s2)]


class Solution_TimeLimited:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False
        return self.doCheck(s1[::-1], s2[::-1], s3[::-1])

    def doCheck(self, s1: str, s2: str, s3: str) -> bool:
        for i in range(len(s3)):
            c = s3[i]
            if (s2 and s2[0] == c) and (s1 and s1[0] == c):
                if self.doCheck(s1[1:], s2, s3[1:]):
                    return True
                elif self.doCheck(s1, s2[1:], s3[1:]):
                    return True
                else:
                    return False
            elif s2 and s2[0] == c:
                return self.doCheck(s1, s2[1:], s3[1:])
            elif s1 and s1[0] == c:
                return self.doCheck(s1[1:], s2, s3[1:])
            else:
                return False
        return True


if __name__ == "__main__":
    solution = Solution()
    result = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")
    print(result)
