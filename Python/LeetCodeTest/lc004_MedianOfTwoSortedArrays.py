from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 or len(nums2) == 0:
            if len(nums1) == 0:
                nums1 = nums2
            size = len(nums1)
            if size % 2 == 1:
                return nums1[size // 2] / 1.0
            else:
                return (nums1[(size - 1) // 2] + nums1[size // 2]) / 2
        if nums1[0] > nums2[0]:
            cache = nums2
            nums2 = nums1
            nums1 = cache
        count = len(nums1) + len(nums2)
        i = 0
        j = 0
        output_data = []
        while i < len(nums1) or j < len(nums2):
            if i >= len(nums1):
                output_data.extend(nums2[j:])
                break
            cache1 = nums1[i]
            if j >= len(nums2):
                output_data.extend(nums1[i:])
                break
            cache2 = nums2[j]
            if cache1 < cache2:
                output_data.append(cache1)
                i += 1
            else:
                output_data.append(cache2)
                j += 1
        print(output_data)
        if count % 2 == 1:
            return output_data[count // 2] / 1.0
        else:
            return (output_data[(count - 1) // 2] + output_data[count // 2]) / 2

if __name__ == "__main__":
    solution = Solution()
    result = solution.findMedianSortedArrays([1, 3], [2])
    print(result)
