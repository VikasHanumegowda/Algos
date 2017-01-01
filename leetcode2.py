#not Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p = ListNode(None)
        q = ListNode(None)
        while l1.next != None or l2.next != None:
            print(str(l1.val) + " " + str(l2.val))
