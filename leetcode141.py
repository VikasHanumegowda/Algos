'''
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
'''

import copy

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        
        try:
            slow = head
            fast = head.next
            while fast is not slow:
                slow = slow.next
                fast = fast.next.next
            return True
        except:
            return False
            
        