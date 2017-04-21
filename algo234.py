'''
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
'''
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        # a-b-c-d-e

        fast = slow = head
        rev = None
        while (fast != None and fast.next != None):
            fast = fast.next.next
            slow = slow.next
            rev.next = rev
            rev = slow
            rev = rev.next

        if fast:
            slow = slow.next

        while slow and rev and slow.val == rev.val:
            slow = slow.next
            rev = rev.next

        return not slow

sol=Solution()
print (sol.isPalindrome([1]))