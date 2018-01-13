# Sort a linked list in O(n log n) time using constant space complexity.

from copy import deepcopy


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        fast = deepcopy(head)
        slow = deepcopy(head)
        while fast is not None:
            slow = slow.next
            fast = fast.next
            try:
                fast = fast.next
            except:
                pass
        left = self.sortList(head)
        right = self.sortList(slow)
        return self.merge(left, right)

    def merge(self, left_head, right_head):
        if left_head is None:
            return right_head
        if right_head is None:
            return left_head
        left = deepcopy(left_head)
        right = deepcopy(right_head)
        while left is not None and right is not None:
            if left.next is not None:
                if left.val <= right.val <= left.next.val:
                    temp = right.next
                    right.next = left.next
                    left.next = right
                    right = temp
                elif right.val < left.val:
                    temp = deepcopy(left)
                    left = right
                    left.next = temp
                    right = right.next
                elif left.val <= left.next.val <= right.val:
                    left = left.next
            else:
                if left.val < right.val:
                    left.next = right
                    right = right.next
                    left = left.next
                else:
                    pass
        return

