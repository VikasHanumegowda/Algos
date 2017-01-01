class Solution(object):
    def sumOfSquares(self, num):
        sum = 0
        while (num > 0):
            last = int(num % 10)
            sum += pow(last, 2)
            num /= int(10)
        return sum

    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        slow = fast = self.sumOfSquares(n)
        print(slow)
        slow = self.sumOfSquares(slow)
        print(slow)
        print(fast)

        fast = self.sumOfSquares(fast)

        print(fast)
        fast = self.sumOfSquares(fast)
        print(fast)
        while (fast != slow):
            slow = self.sumOfSquares(slow)
            print(slow)

            fast = self.sumOfSquares(fast)
            print(fast)
            fast = self.sumOfSquares(fast)
            print(fast)

        if fast == slow:
            if fast == 1:
                return True
        return False

print(Solution().isHappy(20))