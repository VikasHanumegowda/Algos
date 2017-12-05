'''
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
'''
class Solution:
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        s_arr = [x for x in s]
        s_arr.reverse()
        output = 0
        for x,y in enumerate(s_arr):
            output += (26**x*(ord(y)-64))
        return output
