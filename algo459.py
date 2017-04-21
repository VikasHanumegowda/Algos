class Solution(object):
    def repeatedSubstringPattern(self, s):
        # s="ababc"
        if s == "":
            return True
        n=len(s)
        for i in reversed(range(int(n/2)+1)):
            if i==0:
                return False
            if n%i==0:
                list_tok=[s[x:x+i] for x in range(0,n,i)]
                list_tok=set(list_tok)
                if len(list_tok)==1:
                    return True
        return False

sol=Solution()
print(sol.repeatedSubstringPattern('aba'))