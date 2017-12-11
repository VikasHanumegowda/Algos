'''Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. '''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        i = 0
        fast = head
        start = ListNode(None)
        start.next = head
        slow  = start
        while i < n-1:
            fast = fast.next
            i+=1
        while fast != None and fast.next!=None:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        
        return start.next
        
