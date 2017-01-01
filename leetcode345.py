class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """

        list1 = []
        for x in range(len(s)):
            if s[x] == 'a' or s[x] == 'e' or s[x] == 'i' or s[x] == 'o' or s[x] == 'u' or s[x] == 'A' or s[x] == 'E' or s[x] == 'I' or s[x] == 'O' or s[x] == 'U':
                list1.extend([s[x]])
        a = ''
        for x in range(len(s)):
            if s[x] == 'a' or s[x] == 'e' or s[x] == 'i' or s[x] == 'o' or s[x] == 'u' or s[x] == 'A' or s[x] == 'E' or s[x] == 'I' or s[x] == 'O' or s[x] == 'U':
                a = a + list1.pop()
            else:
                a = a + s[x]
        return a

print(Solution().reverseVowels("Leetcode"))