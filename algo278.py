def isBadVersion(n):
    if n==13:
        return True
    return False

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        return self.helper(1,n)
    def helper(self,i,j):
        if i==j and isBadVersion(i)==True and isBadVersion(i-1)==False:
            return i
        if (isBadVersion(i) is False and isBadVersion(j) is False) or (isBadVersion(i) is True and isBadVersion(j) is True):
            return -1
        if isBadVersion(i) is False and isBadVersion(j) is True:
            return max(self.helper(i,int((i+j)/2)),self.helper(int((i+j)/2)+1,j)
    __main__(self):
        print(Solution().firstBadVersion(100))

