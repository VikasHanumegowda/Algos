class Solution(object):
    def num_of_ones(self,x):
        d=[0]
        if x==0:
            return 0
        else:
            for i in range(1,x+1):
                d.extend([d[i>>1]+(i&1)])
        return d[x]
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        dict={}
        dict1={}
        for x in range(13):
            dict[x]=self.num_of_ones(x)
            print(str(x)+" "+str(dict[x]))
        for x in range(61):
            dict1[x]=self.num_of_ones(x)
            print(str(x)+" "+str(dict1[x]))

        fin_d={}
        out_list=[]
        for h in range(0,13):
            for m in range(61):
                strr='%d:%.2d' % (h,m)
                fin_d[strr]=dict[h]+dict1[m]
                if(fin_d[strr]==num):
                    out_list.extend([strr])
        return out_list



print(Solution().readBinaryWatch(2
                                 ))