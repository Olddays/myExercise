# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        cache = head
        count = 0
        while cache is not None:
            cache = cache.next
            count += 1
        if count <= 1 or k % count == 0:
            return head
        if k > count:
            target = count - (k % count)
        else:
            target = count - k
        cache = head
        for i in range(target - 1):
            cache = cache.next
        output = cache.next
        cache.next = None
        cache = output
        while cache.next is not None:
            cache = cache.next
        cache.next = head
        return output

if __name__ == "__main__":
    solution = Solution()
    input = ListNode(1)
    input.next = ListNode(2)
    input.next.next = ListNode(3)
    input.next.next.next = ListNode(4)
    result = solution.rotateRight(input, 2)
    while result is not None:
        print(result.val)
        result = result.next
