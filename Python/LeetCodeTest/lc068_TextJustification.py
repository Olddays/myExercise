from typing import List

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        n = len(words)
        output = []
        cache = [words[0]]
        count = len(words[0])
        for i in range(1, n):
            word = words[i]
            if count + len(word) > maxWidth - len(cache):
                space = maxWidth - count
                part = (len(cache) - 1)
                if part > 0:
                    s = ""
                    single = space // part
                    other = space % part
                    for c in cache[:-1]:
                        s += c
                        for j in range(single):
                            s += " "
                        if other > 0:
                            s += " "
                            other -= 1
                    s += cache[-1]
                else:
                    s = cache[0]
                    while len(s) < maxWidth:
                        s += " "
                output.append(s)
                cache = [word]
                count = len(word)
            else:
                cache.append(word)
                count += len(word)
        s = cache[0]
        if len(cache) > 0:
            for word in cache[1:]:
                s += " " + word
        while len(s) < maxWidth:
            s += " "
        output.append(s)
        return output

if __name__ == "__main__":
    solution = Solution()
    words = ["What", "must", "be", "acknowledgment", "shall", "be"]
    maxWidth = 16
    result = solution.fullJustify(words, maxWidth)
    print(result)
    for line in result:
        print(line + " " + str(len(line)))
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    result = solution.fullJustify(words, maxWidth)
    print(result)
    for line in result:
        print(line + " " + str(len(line)))
    words = ["Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
             "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"]
    maxWidth = 20
    result = solution.fullJustify(words, maxWidth)
    print(result)
    for line in result:
        print(line + " " + str(len(line)))
    words = ["ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for",
             "your", "country"]
    maxWidth = 16
    result = solution.fullJustify(words, maxWidth)
    print(result)
    for line in result:
        print(line + " " + str(len(line)))