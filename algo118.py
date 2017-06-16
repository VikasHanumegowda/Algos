class Solution(object):
    def generate(self, rowIndex):
        """
        1
        11
        121
        1331

        :type rowIndex: int
        :rtype: List[int]
        """


        if rowIndex == 0:
            return []
        if rowIndex == 1:
            return [[1]]
        if rowIndex == 2:
            return [[1], [1, 1]]
        out = [[1],[1,1]]
        init = [1, 1]
        new_arr = [x for x in init]
        for x in range(2, rowIndex):
            for y in range(len(init)):
                if y == 0:
                    continue
                else:
                    new_arr[y] = init[y] + init[y - 1]
            new_arr.extend([1])
            # print(new_arr)
            init = [x for x in new_arr]

            new_arr = [x for x in init]
            out.append([x for x in new_arr])
        return out

print(Solution().generate(5))