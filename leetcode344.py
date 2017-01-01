from math
class Solution(object):
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        le=len(s)
        if(le<2):
            return s
        l=int(math.floor(le/2))
        return self.reverseString(s[l:])+self.reverseString(s[:l])


print(Solution().reverseString('abcd'))