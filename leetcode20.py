class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        list1 = []
        if len(s) == 0:
            return True


        for i in range(len(s)):
            if s[i]=='[' or s[i]=='{' or s[i]=='(':
                list1=list1+[s[i]]
                continue
            if s[i]==']' or s[i]=='}' or s[i]==')':
                if len(list1)!=0:
                    if list1[-1]=='[' and s[i]==']':
                        list1.pop(-1)
                        continue
                    elif list1[-1]=='{' and s[i]=='}':
                        list1.pop(-1)
                        continue
                    elif list1[-1]=='(' and s[i]==')':
                        list1.pop(-1)
                        continue
                    else:
                        return False
                else:
                    return False
        if len(list1)==0:
            return True
        else:
            return False


s=Solution()
print(s.isValid("()"))