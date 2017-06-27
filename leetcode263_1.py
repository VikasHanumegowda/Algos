
# from __future__ import division
import sys
# class Solution(object):
#     def isPrime(self,num):
#         for x in range(2,int(num**(1/2)+1)):
#             if num%x==0:
#                 return False
#         return True
#     def primeFactors(self,num):
#         if num<0:
#             res=[1,-1]
#             num*=-1
#         else:
#             res=[1]
#         if self.isPrime(num):
#             res.append(num)
#         cnum=num
#         for x in range(2,int(num/2)+1):
#             if cnum%x==0 and self.isPrime(x):
#                 res.append(x)
#                 cnum/=x
#         return res
#     def isUgly(self, num):
#         """
#         :type num: int
#         :rtype: bool
#         """
#         pF=set(self.primeFactors(num))
#         print(pF)
#         ourSet=set([1,2,3,5])
#         if len(pF-ourSet)==0:
#             return True
#         return False


import math
class Solution(object):
    def isPrime(self,num):
        for x in range(2,int(math.ceil(num/2))+1):
            if num%x==0:
                return False
        return True
    def primeFactors(self,num):
        if num<0:
            res=[1,-1]
            num*=-1
        else:
            res=[1]
        if self.isPrime(num):
            res.append(num)
        cnum=num
        for x in range(2,int(num/2)+1):
            if cnum%x==0 and self.isPrime(x):
                res.append(x)
                cnum/=x
        return res
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        pF=set(self.primeFactors(num))
        print(pF)
        ourSet=set([1,2,3,5])
        if len(pF-ourSet)==0:
            return True
        return False
print(Solution().isUgly(6),2/3)
print(sys.version)