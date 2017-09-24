class Solution:
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        ["5","2","C","D","+"]
        """
        sum1 = 0
        prop = []
        for x in ops:
            if x.isdigit():
                sum1 += int(x)
                prop.append(int(x))
            elif x == 'C':
                sum1 -= prop.pop()
            elif x == 'D':
                temp = prop[-1]
                prop.append(temp * 2)
                sum1 += temp * 2
            elif x == '+':
                temp = prop[-1] + prop[-2]
                sum1 += temp
                prop.append(temp)
        return sum1


print(Solution().calPoints(["-21", "-66", "39", "+", "+"]))


