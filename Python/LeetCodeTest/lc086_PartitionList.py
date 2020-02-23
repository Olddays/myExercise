# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        data_set = []
        tail = ListNode(0)
        cache = tail
        while head is not None:
            if head.val < x:
                data_set.append(head)
            else:
                cache.next = head
                cache = head
            head = head.next
        cache.next = None
        result = ListNode(0)
        cache = result
        for node in data_set:
            cache.next = node
            cache = cache.next
        cache.next = None
        while tail.next is not None:
            cache.next = tail.next
            cache = cache.next
            tail = tail.next
        return result.next

if __name__ == "__main__":
    solution = Solution()
    input = ListNode(1)
    input.next = ListNode(3)
    input.next.next = ListNode(-1)
    input.next.next.next = ListNode(5)
    input.next.next.next.next = ListNode(2)
    input.next.next.next.next.next = ListNode(1)
    result = solution.partition(input, 3)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    input = ListNode(2)
    input.next = ListNode(1)
    result = solution.partition(input, 3)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    input = ListNode(1)
    input.next = ListNode(4)
    input.next.next = ListNode(3)
    input.next.next.next = ListNode(2)
    input.next.next.next.next = ListNode(5)
    input.next.next.next.next.next = ListNode(2)
    result = solution.partition(input, 3)
    while result is not None:
        print(result.val)
        result = result.next
    print()