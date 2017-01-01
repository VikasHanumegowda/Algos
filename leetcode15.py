class Solution(object):
    def threeSum(self, nums):

        n = len(nums)
        list_outer = []
        nums.sort()

        for x in range(0, n - 1):
            sum = 0 - nums[x]
            lo = x + 1
            hi = n - 1

            while hi > lo:
                if (nums[lo] + nums[hi] - sum == 0):
                    if [nums[x], nums[lo], nums[hi]] not in list_outer:
                        list_outer.append([nums[x], nums[lo], nums[hi]])
                        break;
                elif (nums[lo] + nums[hi] - sum < 0):
                    lo += 1
                elif (nums[lo] + nums[hi] - sum > 0):
                    hi -= 1

        return list_outer
x=Solution()
print(x.threeSum([-1,0,1,2,-1,-4]))
