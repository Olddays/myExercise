from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]: # 先依照每个段落的开始值排序，然后只需要比较结束值
        intervals.sort(key=lambda x: x[0])
        output = []
        for interval in intervals:
            if len(output) == 0 or output[-1][1] < interval[0]:
                output.append(interval)
            else:
                output[-1][1] = max(output[-1][1], interval[1])
        return output

    # 把每个数字转换为线段上的合并，那么就包含数字点和数字点接下来的线段，所以存储空间使用2倍，
    # 这种方式是可行的，但会占用很多空间，而且并不高效
    def merge_inefficient(self, intervals: List[List[int]]) -> List[List[int]]:
        max_cache = 0
        for interval in intervals:
            for data in interval:
                max_cache = max(data, max_cache)
        cache = [False] * (max_cache + 1) * 2 # 分别代表等于i和i到i+1是否包含，用于解决半开半闭
        for interval in intervals:
            for data in range(interval[0] * 2, interval[1] * 2):
                cache[data] = True
            if interval[0] == interval[1]:
                cache[interval[0] * 2] = True
        output = []
        start = 0
        found = False
        for i in range(len(cache)):
            data = cache[i]
            if data and not found:
                start = i
                found = True
            if not data and found:
                output.append([start // 2, i // 2])
                found = False
        return output

    def merge_error(self, intervals: List[List[int]]) -> List[List[int]]: # 无法解决形如[[1,4],[0,0]]的输入
        max_cache = 0
        for interval in intervals:
            for data in interval:
                max_cache = max(data, max_cache)
        cache = [False] * (max_cache + 1)
        for interval in intervals:
            for data in range(interval[0], interval[1]):
                cache[data] = True
        output = []
        start = 0
        found = False
        for i in range(len(cache)):
            data = cache[i]
            if data and not found:
                start = i
                found = True
            if not data and found:
                output.append([start, i])
                found = False
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.merge([[1,4],[0,0]])
    print(result)
    result = solution.merge([[2,4],[1,1]])
    print(result)
    result = solution.merge([[1,3],[2,6],[8,10],[15,18]])
    print(result)
