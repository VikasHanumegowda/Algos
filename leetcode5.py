'''
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

Example:

Input: "cbbd"

Output: "bb"

'''


class Solution:
    maxlen = 0
    ss = ""
    def helper(self, string, i, j):
        while i>=0 and j<len(string) and string[i] == string[j]:
            i-=1
            j+=1
        if self.maxlen < j - i - 1:
            self.maxlen = j - i - 1
            self.ss = string[i+1:j]
        
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        l = len(s)
        if l <=1 :
            return s
        for x in range(l):
            self.helper(s, x, x)
            if x !=l-1:
                self.helper(s, x, x+1)
        return self.ss
