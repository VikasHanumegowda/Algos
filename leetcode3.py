from collections import OrderedDict
"""
        :type s: str
        :rtype: int
        """
#LENGTH OF LONGEST SUBSTRING


s="abcabcbb"
subs = {}
answer = OrderedDict()
print(answer)
for i in range(len(s)):  # abcabcbb
    if answer.has_key(s[i]):
        subs[s[i]] += 1
        answer.clear()
        print(subs)
        print(answer)
    else:
        subs[s[i]] = 1
        answer[s[i]] = 1
        print(subs)
        print(answer)

count = 0
for i in range(len(s)):
    if (subs[s[i]] == 1):
        count += 1

print(count)