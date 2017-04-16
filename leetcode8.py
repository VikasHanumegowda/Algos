str1="+-21"
sum=0
c=1
str1=str1.strip(' ')
if str1 is "" or len(str1)==0 or str1 is None:
    print(0)
while str1!=None and str1[0] is '-' or str1!=None and str1[0] is '+':
    if str1[0] is '-':
        c*-1
        str1=str1.strip('-')
    elif str1[0] is '+':
        c*=1
        str1=str1.strip('+')
subs=-1
for x in range(len(str1)):
    if str1[x] not in ['0','1','2','3','4','5','6','7','8','9']:
        subs=x
if subs>-1:
    str1=str1[0:subs]
i=0
for x in reversed(range(len(str1))):
    sum+=int(str1[x])*10**i
    i+=1
print(sum*c)