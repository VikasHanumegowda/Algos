import math
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        count = 0
        while n > 0:
            if n % 2 == 1:
                count = count+1
            n = math.floor(n / 2)

        return count

neww=Solution()
print(neww.hammingWeight(9))