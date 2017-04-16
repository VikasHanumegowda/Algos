class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dict1={}
        inter=[]
        nums1=list(set(nums1))
        nums2=list(set(nums2))
        for x in nums1:
            if x in dict1:
                dict1[x]+=1
            else:
                dict1[x]=1
        for x in nums2:
            if x in dict1:
                dict1[x]-=1
            else:
                dict1[x]=-1
        for x in dict1:
            if dict1[x]==0:
                inter.extend([x])
        return inter