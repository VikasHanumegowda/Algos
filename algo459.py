'''
Given a non-empty string check if it can be constructed by taking a substring of it
 and appending multiple copies of the substring together. You may assume the given string
 consists of lowercase English letters only and its length will not exceed 10000.

Example 1:

Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"

Output: False

Example 3:

Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

'''
class Solution(object):
    def repeatedSubstringPattern(self, s):
        # s="ababc"
        if s == "":
            return True
        n=len(s)
        for i in reversed(range(int(n/2)+1)):
            if i==0:
                return False
            if n%i==0:
                list_tok=[s[x:x+i] for x in range(0,n,i)]
                list_tok=set(list_tok)
                if len(list_tok)==1:
                    return True
        return False

sol=Solution()
print(sol.repeatedSubstringPattern('aba'))