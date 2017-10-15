'''
  Description:

Count the number of prime numbers less than a non-negative number, n.
'''
import math
class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 2:
            return 0
        count = 0
        primes = [True]*n
        for x in range(2,int(math.ceil(math.sqrt(n-1))) + 1):
            if primes[x]:
                primes[x*x:n:x] = [False]*len(primes[x*x:n:x])
        count = 0
        for x in primes[2:]:
            if x:
                count +=1
        return count
        
