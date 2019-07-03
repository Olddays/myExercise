from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        key_map = {}
        for word in strs:
            key = tuple(sorted(word))
            key_map[key] = key_map.get(key, []) + [word]
        return list(key_map.values())

if __name__ == "__main__":
    solution = Solution()
    result = solution.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
    print(result)