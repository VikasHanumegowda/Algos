'''
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
'''
class Solution(object):
    def helper(self, *args):
        count = 0
        empty = 0
        for x in args:
          if len(x)>0:
            if x[-1] == '1':
              count+=1 
          else:
            empty = 1
        args = list(args)
        while [] in args:
          args.remove([])
        args = tuple(args)
        #print(args)
        if len(args) == 0:
          return ""
        args = [x[:-1] for x in args]
        if count == 0:
          return self.helper(*args)+'0'
        if count ==1:
          return self.helper(*args)+'1'
        if count == 2:
          args.append(['1'])
          return self.helper(*args)+'0'
        if count == 3:
          args.append(['1'])
          return self.helper(*args)+'1'
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """ 
        return self.helper([x for x in a],[x for x in b])
# print(Solution().addBinary("101",'11'))
