import itertools
class Solution(object):


    def merge(self,x,y):
        output=[]
        for i in range(len(x)):
            for j in range(len(y)):
                output.extend([x[i]+y[j]])
        return output

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        dict = {0: [' '], 1: [], 2: ['a', 'b', 'c'], 3: ['d', 'e', 'f'], 4: ['g', 'h', 'i'], 5: ['j', 'k', 'l'],
                6: ['m', 'n', 'o'], 7: ['p', 'q', 'r', 's'], 8: ['t', 'u', 'v'], 9: ['w', 'x', 'y', 'z']}

        inpu = [int(x) for x in digits]
        #print(inpu) 2,3,4
        if len(inpu)==0:
            return []
        if len(inpu)==1:
            return inpu
        if len(inpu)>1:
            output=[]
            output.extend(self.merge(dict[inpu[0]],dict[inpu[1]]))
            if(len(inpu)>2):
                for x in range(2,len(inpu)):
                    output=self.merge(output,dict[inpu[x]])
            return output

#print(Solution().letterCombinations("234"))
y=Solution().letterCombinations("2343")
print(len(y))