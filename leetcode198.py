# class Solution(object):
#     num_num={}
#     def opt(self, k, nums):
#         if k < 0:
#             return 0
#         if k in self.num_num:
#             return self.num_num[k]
#         else:
#             val=max(nums[k] + self.opt(k - 2, nums), self.opt(k - 1, nums))
#             self.num_num[k]=val
#             return val
#         #return max(nums[k] + self.opt(k - 2, nums), self.opt(k - 1, nums))
#
#     def rob(self, nums):
#         n = len(nums)
#         if n != 0:
#             return self.opt(n-1, nums)
#         else:
#             return 0
class Solution(object):
    dict1={}
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=len(nums)
        if l<=0:
            return 0
        if l==1:
            return nums[0]
        if l==2:
            return max(nums[0],nums[1])
        if l in self.dict1.keys():
            return self.dict1[l]
        else:
            self.dict1[l]=max(nums[-1]+self.rob(nums[0:(l-2)]),self.rob(nums[0:(l-1)]))
        return self.dict1[l]
s=Solution()
print(s.rob([1,1,1]))