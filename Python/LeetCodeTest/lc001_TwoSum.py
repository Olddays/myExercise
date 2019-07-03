class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache_map = {}
        for i in range(len(nums)):
            cache_map.setdefault(nums[i], i)
        for i in range(len(nums)):
            cache = target - nums[i]
            if cache in cache_map:
                j = cache_map.get(cache)
                if j < i:
                    return [j, i]
                elif j == i:
                    continue
                else:
                    return [i, j]
        return []
