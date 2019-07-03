class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub_string_size_list = []
        cache_string = ""
        for i in range(len(s)):
            c = s[i]
            if c in cache_string:
                sub_string_size_list.append(len(cache_string))
                cache_string = cache_string.split(c)[-1]
            cache_string += c
        sub_string_size_list.append(len(cache_string))
        return max(sub_string_size_list)