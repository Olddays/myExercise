# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        data_set = []
        cache = head
        while cache is not None:
            data_set.append(cache)
            cache = cache.next
        output = ListNode(0)
        cache = output
        for i in data_set[0: m - 1]:
            cache.next = i
            cache = cache.next
        for i in reversed(data_set[m - 1: n]):
            cache.next = i
            cache = cache.next
        for i in data_set[n:]:
            cache.next = i
            cache = cache.next
        cache.next = None
        return output.next

if __name__ == "__main__":
    solution = Solution()
    input = ListNode(1)
    input.next = ListNode(2)
    input.next.next = ListNode(3)
    input.next.next.next = ListNode(4)
    input.next.next.next.next = ListNode(5)
    result = solution.reverseBetween(input, 2, 4)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    input = ListNode(1)
    input.next = ListNode(2)
    input.next.next = ListNode(3)
    input.next.next.next = ListNode(4)
    input.next.next.next.next = ListNode(5)
    result = solution.reverseBetween(input, 1, 5)
    while result is not None:
        print(result.val)
        result = result.next
