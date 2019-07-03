# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        cache = head
        while l1 is not None and l2 is not None:
            val1 = l1.val
            val2 = l2.val
            if val1 < val2:
                cache.next = l1
                l1 = l1.next
            else:
                cache.next = l2
                l2 = l2.next
            cache = cache.next
        if l1 is not None:
            cache.next = l1
        if l2 is not None:
            cache.next = l2
        return head.next

if __name__ == "__main__":
    solution = Solution()
    node1 = ListNode(1)
    node1.next = ListNode(2)
    node1.next.next = ListNode(4)
    node2 = ListNode(1)
    node2.next = ListNode(3)
    node2.next.next = ListNode(4)
    result = solution.mergeTwoLists(node1, node2)
    while result is not None:
        print(result.val)
        result = result.next
