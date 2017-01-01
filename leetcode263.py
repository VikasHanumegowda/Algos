class Solution(object):
    dic = {2: {2}, 3: {3}, 5: {5}}
    prime={2:True,3:True}
    def isPrime(self, n):
        if n in self.prime:
            return self.prime[n]
        for x in range(2, int(n / 2)):
            if n % x == 0:
                return False
        return True

    def primeFactorsOf(self, sum1):
        if sum1 in self.dic:
            return self.dic[sum1]
        s = set()
        for x in range(2, sum1, 1):
            if sum1 % x == 0:
                s.add(x)
        self.dic[sum1] = s
        return s

    def ulti_set(self, lis):
        count = 0
        u = set()
        u.union(lis)
        for x in lis:
            if not self.isPrime(x):
                u.union(self.ulti_set([x]))
        return u

    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        num = abs(num)
        if num == 1:
            return True
        lis = self.primeFactorsOf(num)
        out_lis = self.ulti_set(lis)
        out_lis.difference_update({2, 3, 5})
        for x in out_lis:
            if not self.isPrime(x):
                return False
        return True
print(Solution().isUgly(20))