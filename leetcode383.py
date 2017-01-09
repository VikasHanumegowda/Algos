class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        dict1={}
        for x in magazine:
            if x in dict1:
                dict1[x]+=1
            else:
                dict1[x]=1
        for x in ransomNote:
            if x in dict1:
                dict1[x]-=1
                if dict1[x]<0:
                    return False
            else:
                return False
        return True