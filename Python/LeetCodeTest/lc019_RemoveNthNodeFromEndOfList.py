class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        last_node = head
        node_count = 1
        while last_node.next is not None:
            last_node = last_node.next
            node_count += 1
        if n == node_count:
            return head.next
        remove_id = node_count - n
        last_node = head
        result = last_node
        node_count = 1
        while last_node is not None and last_node.next is not None:
            if node_count == remove_id:
                last_node.next = last_node.next.next
            last_node = last_node.next
            node_count += 1
        return result

if __name__ == "__main__":
    solution = Solution()
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    node.next.next.next.next = ListNode(5)
    result = solution.removeNthFromEnd(node, 5)
    while result is not None:
        print(result.val)
        result = result.next
