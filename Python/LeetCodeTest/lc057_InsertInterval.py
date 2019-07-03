from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]: # 先依照每个段落的开始值排序，然后只需要比较结束值
        all_data = intervals.copy()
        all_data.append(newInterval)
        all_data.sort(key=lambda x: x[0])
        output = []
        for interval in all_data:
            if len(output) == 0 or output[-1][1] < interval[0]:
                output.append(interval)
            else:
                output[-1][1] = max(output[-1][1], interval[1])
        return output

    def insert_error(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]: # 无法处理类似[[1,2],[3,4]],[0,5]这种新数据完全覆盖全部老数据的情况
        if len(intervals) == 0:
            return [newInterval]
        found_start = False
        found_end = False
        start = 0
        end = 0
        output = []
        for i in range(len(intervals)):
            interval = intervals[i]
            if interval[1] >= newInterval[0] and interval[0] <= newInterval[0]:
                if not found_start:
                    start = i
                    found_start = True
            elif interval[1] >= newInterval[1] and interval[0] <= newInterval[1]:
                if not found_end:
                    end = i
                    found_end = True
            elif interval[0] >= newInterval[0] and interval[1] <= newInterval[1]:
                if not found_end and not found_start:
                    found_start = True
                    found_end = True
                    start = end = i
        if found_start and not found_end:
            end = start
            found_end = True
        if found_end and not found_start:
            end = start
            found_start = True
        if found_end and found_start:
            cache = []
            found = False
            for i in range(len(intervals)):
                interval = intervals[i]
                if i == start:
                    found = True
                    cache.append(min(interval[0], newInterval[0]))
                if not found:
                    output.append(interval)
                if i == end:
                    found = False
                    cache.append(max(interval[1], newInterval[1]))
                    output.append(cache)
        else:
            output = intervals.copy()
            output.append(newInterval)
            output.sort(key=lambda x: x[0])
        return output

if __name__ == "__main__":
    solution = Solution()
    result = solution.insert([[1, 5]], [0, 3])
    print(result)
    result = solution.insert([[1, 5], [6, 8]], [0, 9])
    print(result)
    result = solution.insert([[1, 5]], [6, 8])
    print(result)
    result = solution.insert([[1, 3], [6, 9]], [2, 5])
    print(result)
    result = solution.insert([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], [4, 8])
    print(result)
