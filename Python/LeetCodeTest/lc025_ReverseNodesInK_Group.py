# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None:
            return head
        data_set = []
        while head is not None:
            data_set.append(head)
            head = head.next
        output_head = ListNode(0)
        output = output_head
        for i in range(len(data_set)):
            if i % k == k - 1:
                pre_reverse_list = data_set[i - k + 1: i + 1]
                reversed_list = []
                for j in pre_reverse_list:
                    reversed_list.insert(0, j)
                for j in reversed_list:
                    output_head.next = j
                    output_head = output_head.next
        start = len(data_set) - (len(data_set) % k)
        for i in range(start, len(data_set)):
            output_head.next = data_set[i]
            output_head = output_head.next
        output_head.next = None
        return output.next

    def reverseKGroup_Wrong(self, head: ListNode, k: int) -> ListNode: # 仅可用于每个Node的val不一致，否则无法使用map
        if head is None or head.next is None:
            return head
        data_set = {}
        while head is not None:
            data_set.setdefault(head.val, head)
            head = head.next
        data_list = list(data_set.keys())
        output_head = ListNode(0)
        output = output_head
        for i in range(len(data_list)):
            if i % k == k - 1:
                pre_reverse_list = data_list[i - k + 1: i + 1]
                reversed_list = []
                for j in pre_reverse_list:
                    reversed_list.insert(0, j)
                for j in reversed_list:
                    output_head.next = data_set.get(j)
                    output_head = output_head.next
        start = len(data_list) - (len(data_list) % k)
        for i in range(start, len(data_list)):
            output_head.next = data_set.get(data_list[i])
            output_head = output_head.next
        output_head.next = None
        return output.next

if __name__ == "__main__":
    solution = Solution()
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    node.next.next.next.next = ListNode(5)
    result = solution.reverseKGroup(node, 2)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    node = ListNode(1)
    node.next = ListNode(2)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(4)
    node.next.next.next.next = ListNode(5)
    result = solution.reverseKGroup(node, 3)
    while result is not None:
        print(result.val)
        result = result.next
    print()
    node = ListNode(1)
    node.next = ListNode(7)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(2)
    node.next.next.next.next = ListNode(7)
    node.next.next.next.next.next = ListNode(0)
    node.next.next.next.next.next.next = ListNode(1)
    node.next.next.next.next.next.next.next = ListNode(0)
    node.next.next.next.next.next.next.next.next = ListNode(0)
    result = solution.reverseKGroup(node, 4)
    while result is not None:
        print(result.val)
        result = result.next
