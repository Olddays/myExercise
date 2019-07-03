# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        result = ListNode(0)
        head = result
        carry = 0
        while(l1 is not None and l2 is not None):
            val = l1.val + l2.val + carry
            carry = val // 10
            cache: ListNode = ListNode(val % 10)
            head.next = cache
            head = cache
            l1 = l1.next
            l2 = l2.next
        while (l1 is not None):
            val = l1.val + carry
            carry = val // 10
            cache: ListNode = ListNode(val % 10)
            head.next = cache
            head = cache
            l1 = l1.next
        while (l2 is not None):
            val = l2.val + carry
            carry = val // 10
            cache: ListNode = ListNode(val % 10)
            head.next = cache
            head = cache
            l2 = l2.next
        if carry > 0:
            cache: ListNode = ListNode(carry)
            head.next = cache
        return result.next

    def addTwoNumbers2(self, l1: ListNode, l2: ListNode) -> ListNode:
        val1_cache = []
        val2_cache = []
        while(l1 is not None):
            val1_cache.append(l1.val)
            l1 = l1.next
        while(l2 is not None):
            val2_cache.append(l2.val)
            l2 = l2.next
        size = max(len(val1_cache), len(val2_cache))
        carry = 0
        result = None
        for i in range(1, size + 1):
            if i > len(val1_cache):
                for j in range(i, size + 1):
                    val = val2_cache[-i] + carry
                    carry = val // 10
                    cache: ListNode = ListNode(val % 10)
                    cache.next = result
                    result = cache
                break
            elif i > len(val2_cache):
                for j in range(i, size + 1):
                    val = val1_cache[-i] + carry
                    carry = val // 10
                    cache: ListNode = ListNode(val % 10)
                    cache.next = result
                    result = cache
                break
            val = val1_cache[-i] + val2_cache[-i] + carry
            carry = val // 10
            cache: ListNode = ListNode(val % 10)
            cache.next = result
            result = cache
        if carry > 0:
            cache: ListNode = ListNode(carry)
            cache.next = result
            result = cache
        return result

if __name__ == "__main__":
    val1 = ListNode(9)
    val1.next = ListNode(9)
    val1.next.next = ListNode(9)
    val2 = ListNode(9)
    val2.next = ListNode(9)
    val2.next.next = ListNode(9)
    val2.next.next.next = ListNode(9)
    solution = Solution()
    result = solution.addTwoNumbers(val1, val2)
    while (result is not None):
        print(result.val)
        result = result.next
