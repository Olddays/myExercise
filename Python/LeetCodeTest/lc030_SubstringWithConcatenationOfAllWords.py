from typing import List

from collections import Counter
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        output_list = []
        if words is None or len(words) == 0:
            return output_list
        word_size = len(words)
        word_len = len(words[0])
        word_collection = Counter(words)
        match = 0
        for i in range(word_len):
            start = i
            j = i
            while start <= j and start < len(s):
                substring = s[j: j + word_len]
                if len(s) - j >= word_len and substring in word_collection and word_collection[substring]: # treat like a sliding window
                    match += 1
                    word_collection[substring] -= 1
                    if match == word_size:
                        output_list.append(start)
                    if j + word_len - 1 < len(s):
                        j += word_len
                elif j - start >= word_len:
                    word_collection[s[start: start + word_len]] += 1
                    match -= 1
                    start += word_len
                else:
                    start += word_len
                    j += word_len
        return output_list

    def findSubstring_newesttimelimit(self, s: str, words: List[str]) -> List[int]:
        output_list = []
        if words is None or len(words) == 0:
            return output_list
        word_len = len(words[0])
        string_len = len(s)
        word_set = {}
        for word in words:
            if word in word_set:
                word_set[word] += 1
            else:
                word_set.setdefault(word, 1)
        for i in range(string_len):
            left = i
            count = 0
            cache_map = {}
            for j in range(i, string_len - word_len + 1, word_len):
                substring = s[j: j + word_len]
                if substring in word_set:
                    if substring in cache_map:
                        cache_map[substring] += 1
                    else:
                        cache_map.setdefault(substring, 1)
                    if cache_map[substring] <= word_set[substring]:
                        count += 1
                    else:
                        while cache_map[substring] > word_set[substring]:
                            str_cache = s[left: left + word_len]
                            cache_map[str_cache] -= 1
                            if cache_map[str_cache] < word_set[str_cache]:
                                count -= 1
                            left += word_len
                    if count == len(words):
                        if left not in output_list:
                            output_list.append(left)
                        cache_map[s[left: left + word_len]] -= 1
                        count -= 1
                        left += word_len
                else:
                    cache_map.clear()
                    count = 0
                    left = j + word_len
        return output_list

    def findSubstring_newtimelimit(self, s: str, words: List[str]) -> List[int]:
        output_list = []
        if words is None or len(words) == 0:
            return output_list
        word_len = len(words[0])
        word_set = {}
        for word in words:
            if word in word_set:
                word_set[word] += 1
            else:
                word_set.setdefault(word, 1)
        i = 0
        while i < len(s):
            copy_set = word_set.copy()
            for j in range(len(words)):
                substring = s[i + j * word_len: i + (j + 1) * word_len]
                if substring in copy_set:
                    count = copy_set.get(substring)
                    if count == 1:
                        copy_set.pop(substring)
                    else:
                        copy_set[substring] -= 1
                    if len(copy_set) == 0:
                        output_list.append(i)
                        break
                else:
                    break
            i += 1
        return output_list

    def findSubstring_timelimit(self, s: str, words: List[str]) -> List[int]:
        output_list = []
        if words is None or len(words) == 0:
            return output_list
        word_len = len(words[0])
        i = 0
        usable = words.copy()
        while i < len(s):
            c = s[i]
            for j in range(len(words)):
                word = words[j]
                if word.startswith(c):
                    substring = s[i: i + word_len]
                    if substring == word:
                        usable.remove(word)
                        self.find(s, words, word_len, output_list, i + word_len, usable)
                        usable = words.copy()
            i += 1
        return output_list

    def find(self, s: str, words: List[str], word_len: int, output_list: List[int], i: int, usable: List[str]) -> bool:
        if len(usable) == 0:
            result = i - word_len * len(words)
            if result not in output_list:
                output_list.append(result)
            return True
        else:
            if i >= len(s):
                return False
            substring = s[i: i + word_len]
            if substring in usable:
                usable.remove(substring)
                result = self.find(s, words, word_len, output_list, i + word_len, usable)
                if result:
                    return True
                usable.append(substring)
            return False

    def findSubstring_wrong(self, s: str, words: List[str]) -> List[int]: # 无法处理words中包含多个一致单词的情况
        word_head_set = {}
        word_list_len = 0
        for word in words:
            if word[0] in word_head_set:
                word_head_set[word[0]].append(word)
            else:
                word_head_set.setdefault(word[0], [word])
            word_list_len += len(word)
        output_list = []
        cache_substring = ""
        i = 0
        while i < len(s):
            c = s[i]
            if c in word_head_set:
                keys = word_head_set.get(c)
                for key in keys:
                    key_len = len(key)
                    substring = s[i: i + key_len]
                    if substring == key and key not in cache_substring:
                        cache_substring += key
                        if len(cache_substring) == word_list_len:
                            output_list.append(i - len(cache_substring) + key_len)
                            i = i - len(cache_substring) + key_len + 1
                            cache_substring = ""
            i += 1
        return output_list

if __name__ == "__main__":
    solution = Solution()
    result = solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", ["fooo", "barr", "wing", "ding", "wing"])
    print(result)
    result = solution.findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "good"])
    print(result)
    result = solution.findSubstring("barfoothefoobarman", ["foo", "bar"])
    print(result)
    result = solution.findSubstring("bbarfoothefoobarman", ["foo", "bar"])
    print(result)
    result = solution.findSubstring("barbarfoothefoobarman", ["foo", "bar"])
    print(result)
    result = solution.findSubstring("barfoofoobarthefoobarman", ["bar", "foo", "the"])
    print(result)
    result = solution.findSubstring("wordgoodgoodgoodbestword", ["word", "good", "best", "word"])
    print(result)
# [13]
# [8]
# [0, 9]
# [1, 10]
# [3, 12]
# [6, 9, 12]
# []