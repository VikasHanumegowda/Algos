import re

n=int(input())
list1=[]
for x in range(n):
    list1.append(str(input()))
#print(list1)
index_list=list(range(n))

answer=[]
pattern=r'[a-za-z0-9_\.-]+@[a-za-z0-9]+\.[a-zA-Z]{3,5}'
#print(pattern)
pattern1=re.compile(pattern)
#print(pattern)
for x in range(n):
    mat=pattern1.match((list1[x]))
    if(mat!= None):
        answer.append(mat.group())
answer.sort()
print(answer)
'''EMAIL_REGEX = re.compile(r"... regex here ...")
if not EMAIL_REGEX.match(email):


pattern='[A-Za-z0-9.-]+'
pattern1=re.compile(pattern=pattern)
matchob=re.match(pattern1,"_Hello")
print(matchob.group())
'''