class Solution(object):
    def maxRotateFunction(self, A):

        n=len(A)
        if n==0:
            return 0

        init_sum=0
        sum_of_elements=0

        for i in range(n):
            init_sum=init_sum+A[i]
            sum_of_elements=sum_of_elements+A[i]
        max1=init_sum

        for i in range(1,n):
            init_sum=init_sum-sum_of_elements+A[i]*n
            max1=init_sum if init_sum>max1 else max1

        return max1

a=Solution()
print(a.maxRotateFunction([4,3,2,6]))