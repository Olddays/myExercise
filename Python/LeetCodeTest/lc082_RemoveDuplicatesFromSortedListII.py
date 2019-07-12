# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        pre = ListNode(0)
        dummy = pre
        dummy.next = head
        while head and head.next:
            if head.val == head.next.val:
                while head and head.next and head.val == head.next.val:
                    head = head.next
                head = head.next
                pre.next = head
            else:
                pre = pre.next
                head = head.next
        return dummy.next

    def deleteDuplicates_withSet(self, head: ListNode) -> ListNode:
        data_set = {}
        duplicate = []
        cache = head
        while cache is not None:
            if cache.val not in data_set:
                data_set.setdefault(cache.val, cache)
            else:
                duplicate.append(cache.val)
            cache = cache.next
        output = ListNode(0)
        cache = output
        for i in data_set:
            if i not in duplicate:
                node = data_set.get(i)
                cache.next = node
                cache = cache.next
        cache.next = None
        return output.next

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
