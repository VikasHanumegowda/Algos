'''
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
'''
class Solution:
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        output = ""
        while n > 0:
            ones = n % 26
            n /= 26
            if ones == 0:
                output = 'Z' + output
                n -= 1
            else:
                output = chr(int(ord('A')) + ones - 1) + output
            n = int(n)
        return output
