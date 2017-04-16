class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        if (n == 0):
            return
        if (m == 0):
            nums1 = nums2
            return
        # for x in range(n):
        #    nums1.extend([0])
        if m > 0:
            for x in range(m):
                nums1[n + x] = nums1[m - x - 1]

        print(nums1, nums2)
        i = 0
        j = 0
        x = 0
        while ((n + i) < (m + n) and j < (m + n) and x < (m + n)):
            print(nums1, i, j)
            if (nums2[j] < nums1[n + i]):
                nums1[x] = nums2[j]
                j += 1
                x += 1
            elif (nums2[j] > nums1[n + i]):
                nums1[x] = nums1[n + i]
                i += 1
                x += 1
            else:
                nums1[x] = nums1[n + i]
                i += 1
                x += 1
                nums1[x] = nums2[j]
                j += 1
                x += 1
        print(nums1, nums2)
sol=Solution()
sol.merge([2,0],1,[1],1)