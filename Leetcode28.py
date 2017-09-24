'''
 Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
'''
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        l_h = len(haystack)
        l_n = len(needle)
        
        if l_h == l_n == 0:
            return 0
        list_h = [x for x in haystack]
        list_n = [x for x in needle]
        
        for x in range(l_h-l_n+1):
            count =0
            for y in range(l_n):
                if list_h[x+y]==list_n[y]:
                    count+=1
            if count == l_n:
                return x
        return -1
            
