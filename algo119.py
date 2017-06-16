class Solution(object):
    def getRow(self, rowIndex):
        """
        1
        11
        121
        1331

        :type rowIndex: int
        :rtype: List[int]
        """
        init = [1, 1]
        new_arr = [x for x in init]
        if rowIndex == 0:
            return [1]
        if rowIndex == 1:
            return [1, 1]
        for x in range(1, rowIndex):
            for y in range(len(init)):
                if y == 0:
                    continue
                else:
                    new_arr[y] = init[y] + init[y - 1]
            new_arr.extend([1])
            #print(new_arr)
            init = [x for x in new_arr]

            new_arr = [x for x in init]
        return new_arr

print(Solution().getRow(4))