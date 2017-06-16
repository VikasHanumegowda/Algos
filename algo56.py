# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        intervals=sorted(intervals)
        if intervals==[]:
            return intervals
        if len(intervals)==1:
            return intervals
        x=0
        while x<len(intervals)-1:
            if intervals[x+1][0]<=intervals[x][1]:
                intervals[x][1]=intervals[x+1][1]
                del(intervals[x+1])
            x+=1
        return intervals
print(Solution().merge([[1,4],[2,5]]))