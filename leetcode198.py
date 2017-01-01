class Solution(object):
    num_num={}
    def opt(self, k, nums):
        if k < 0:
            return 0
        if k in self.num_num:
            return self.num_num[k]
        else:
            val=max(nums[k] + self.opt(k - 2, nums), self.opt(k - 1, nums))
            self.num_num[k]=val
            return val
        #return max(nums[k] + self.opt(k - 2, nums), self.opt(k - 1, nums))

    def rob(self, nums):
        n = len(nums)
        if n != 0:
            return self.opt(n-1, nums)
        else:
            return 0

s=Solution()
print(s.rob([1]))