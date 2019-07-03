class Solution:
    # 使用编译原理中的优先状态机（DFA）解决 https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
    def isNumber(self, s: str) -> bool:
        state = [{},
              {'blank': 1, 'sign': 2, 'digit':3, '.':4},
              {'digit':3, '.':4},
              {'digit':3, '.':5, 'e':6, 'blank':9},
              {'digit':5},
              {'digit':5, 'e':6, 'blank':9},
              {'sign':7, 'digit':8},
              {'digit':8},
              {'digit':8, 'blank':9},
              {'blank':9}]
        currentState = 1
        for c in s:
            if c >= '0' and c <= '9':
                c = 'digit'
            if c == ' ':
                c = 'blank'
            if c in ['+', '-']:
                c = 'sign'
            if c not in state[currentState].keys():
                return False
            currentState = state[currentState][c]
        if currentState not in [3,5,8,9]:
            return False
        return True

if __name__ == "__main__":
    solution = Solution()
    print(solution.isNumber("0"))
    print(solution.isNumber(" 0.1 "))
    print(solution.isNumber("abc"))
    print(solution.isNumber("1 a"))
    print(solution.isNumber("2e10"))
    print(solution.isNumber(" -90e3   "))
    print(solution.isNumber(" 1e"))
    print(solution.isNumber("e3"))
    print(solution.isNumber(" 6e-1"))
    print(solution.isNumber(" 99e2.5 "))
    print(solution.isNumber("53.5e93"))
    print(solution.isNumber(" --6 "))
    print(solution.isNumber("-+3"))
    print(solution.isNumber("95a54e53"))
    print(solution.isNumber("6+1"))
    print(solution.isNumber("6-1"))
    print(solution.isNumber("4e+"))
    print(solution.isNumber("1++2"))
    print(solution.isNumber("99e2."))