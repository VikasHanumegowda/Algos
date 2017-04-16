import itertools
class Solution:
    def num(self,a,b):
        return a*10+b
    def ret(self,a):
        return [int(a/10),int(a%10)]
    def solution(self, A, B, C, D):
        # write your code in Python 2.7
        list2=[]
        count_of_big_nums=0
        list1={A,B,C,D}
        for x in list1:
            if x>5:
                count_of_big_nums+=1
        if count_of_big_nums>2:
            return "NOT POSSIBLE"
        for x in itertools.permutations(list1,2):
            #print(self.num(x[0],x[1]))
            list2.extend([self.num(x[0],x[1])])
        list2.sort(reverse=True)
        strr=""
        #print(list2)
        for x in range(len(list2)):
            if x<24:
                #strr=strr+str(x)
                #str+=":"
                list3=self.ret(x)
                print(list3)
                list1=list(set(list1)-set(list3))
                #print(list1)
                list4=[]
                for x in itertools.permutations(list1,2):
                    #print(self.num(x[0],x[1]))
                    list4.extend([self.num(x[0],x[1])])
                list4.sort(reverse=True)
                print("sdfsdf")
                #print(list4)
sol=Solution()
sol.solution(1,2,8,3)