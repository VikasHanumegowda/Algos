class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if nums == []:
            return []
        nums_r = len(nums)
        nums_c = len(nums[0])
        if r * c != nums_r * nums_c:
            return nums
        row = 0
        nnums = []
        for x in range(r):
            nnums.append([])
        count=0
        for x in range(len(nums)):
            for y in range(len(nums[x])):
                count+=1
                if count==c:
                    nnums[row].extend([nums[x][y]])
                    row += 1
                    count=0
                else:
                    nnums[row].extend([nums[x][y]])

        return nnums


sol=Solution()
print(sol.matrixReshape([[1,2,3,4]],2,2))