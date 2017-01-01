class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        dir = 0
        list_of_lists = list()

        for x in range(numRows):
            list_of_lists.append("")

        lic = 0

        for x in range(len(s)):
            if (x % numRows == 0):
                if(x==0):
                    list_of_lists[lic]=s[x]
                    lic=(lic+1)%numRows
                else:
                    list_of_lists[lic] += s[x]
                    lic+=1
                dir=1-dir
            elif(x % numRows == (numRows-1)):
                list_of_lists[lic] += s[x]
                lic-=1
                dir=1-dir
            elif(dir==0):
                list_of_lists[lic] += s[x]
                lic-=1
            elif(dir==1):
                list_of_lists[lic] += s[x]
                lic+=1



        final_str = ''
        for x in range(numRows):
            final_str += list_of_lists[x]
        return final_str

x=Solution()
print(x.convert("ABCDEF",3))