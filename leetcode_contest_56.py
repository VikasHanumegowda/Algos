'''
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:

Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:

    2 <= len(nums) <= 10000.
    0 <= nums[i] < 1000000.
    1 <= k <= len(nums) * (len(nums) - 1) / 2.

'''
class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        l = len(nums)
        dict1 = []
        for x in range(l - 1):
            for y in range(x + 1, l):
                dict1.append(abs(nums[x] - nums[y]))

        list1 = sorted(dict1)

        return list1[k - 1]


print(Solution().smallestDistancePair([9, 10, 7, 10, 6, 1, 5, 4, 9, 8], 18))
