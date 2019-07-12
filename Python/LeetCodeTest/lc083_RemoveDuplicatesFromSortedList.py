# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        output = head
        cache = head
        val = cache.val
        while cache is not None:
            if val != cache.val:
                output.next = cache
                output = output.next
                val = cache.val
            cache = cache.next
        output.next = None
        return head

if __name__ == "__main__":
    solution = Solution()
    input = ListNode(1)
    input.next = ListNode(2)
    input.next.next = ListNode(2)
    input.next.next.next = ListNode(2)
    input.next.next.next.next = ListNode(2)
    input.next.next.next.next.next = ListNode(2)
    input.next.next.next.next.next.next = ListNode(2)
    result = solution.deleteDuplicates(input)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    input = ListNode(1)
    input.next = ListNode(2)
    input.next.next = ListNode(3)
    input.next.next.next = ListNode(3)
    input.next.next.next.next = ListNode(4)
    input.next.next.next.next.next = ListNode(4)
    input.next.next.next.next.next.next = ListNode(5)
    result = solution.deleteDuplicates(input)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    input = ListNode(1)
    input.next = ListNode(1)
    input.next.next = ListNode(1)
    input.next.next.next = ListNode(2)
    input.next.next.next.next = ListNode(3)
    result = solution.deleteDuplicates(input)
    while result is not None:
        print(result.val)
        result = result.next
