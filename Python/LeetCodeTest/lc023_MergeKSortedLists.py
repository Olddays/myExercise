# Definition for singly-linked list.
from typing import List

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        cache_map = {}
        for node in lists:
            while node is not None:
                val = node.val
                if val in cache_map:
                    cache_map[val].append(node)
                else:
                    cache_map.setdefault(val, [node])
                node = node.next
        output = ListNode(0)
        head = output
        sorted_val_list = sorted(cache_map.keys())
        for val in sorted_val_list:
            node_list = cache_map.get(val)
            for node in node_list:
                head.next = node
                head = head.next
        return output.next

if __name__ == "__main__":
    solution = Solution()
    input_list = []
    node = ListNode(1)
    node.next = ListNode(4)
    node.next.next = ListNode(5)
    input_list.append(node)
    node = ListNode(1)
    node.next = ListNode(3)
    node.next.next = ListNode(4)
    input_list.append(node)
    node = ListNode(2)
    node.next = ListNode(6)
    input_list.append(node)
    result = solution.mergeKLists(input_list)
    while result is not None:
        print(result.val)
        result = result.next
