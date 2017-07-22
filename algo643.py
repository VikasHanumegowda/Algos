import sys
def findMaxAverage(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: float
    """
    max_sum = -11000
    local_max = 0
    if k == 1:
        return max(nums) * 1.0
    for x in range(k):
        local_max += nums[x]
    for x in range(len(nums) - k):
        max_sum = max([max_sum, local_max])
        local_max = local_max -  nums[x] + nums[x + k]
    max_sum = max([max_sum, local_max])
    return float(max_sum * 1.0 / k * 1.0)

print(findMaxAverage([1,12,-5,-6,50,3],4))