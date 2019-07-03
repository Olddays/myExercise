# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        count = 0
        output = None
        reverse_node = None
        connect_node = None
        while head is not None:
            if count % 2 == 1:
                if output is None:
                    output = head
                cache = head.next
                head.next = reverse_node
                reverse_node.next = cache
                if connect_node is not None:
                    connect_node.next = head
                head = reverse_node
                connect_node = reverse_node
            else:
                reverse_node = head
            count += 1
            head = head.next
        return output

if __name__ == "__main__":
    solution = Solution()
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    result = solution.swapPairs(node)
    while result is not None:
        print(result.val)
        result = result.next
