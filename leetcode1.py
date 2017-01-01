class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for x in range(len(nums)):
            comple = target - nums[x]
            if nums[x] in d:
                if nums[x] + nums[x] == target:
                    return [nums[x], nums[x]]
            elif comple in d:
                return [x, comple]
            else:
                d[nums[x]]=x
x=Solution()
muns=input().strip().split()
muns=[int(i) for i in muns]
print(muns)

target=int(input())
print(target)
print(x.twoSum(muns, target))
print()