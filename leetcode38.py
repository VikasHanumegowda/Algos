'''The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"
'''

'''Python 2'''


import copy 
class Solution(object):
    
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        """
        str1 = "1"
        if n == 1:
            return str1
        str2 = ""
        for x in range(n-1):
            count = 1
            str2 = ""
            prev = ""
            for i,c in enumerate(str1):
                if i == 0:
                    prev = c
                    count = 1
                else:
                    if prev == c:
                        count += 1
                    else:
                        str2 += str(count)+prev
                        prev = c
                        count = 1
            str2 += str(count)+prev
            str1 = copy.deepcopy(str2)
        return str1
                        