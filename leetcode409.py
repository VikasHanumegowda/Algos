dict1={}
s="ccc"
for x in s:
    if x in dict1:
        dict1[x]+=1
    else:
        dict1[x]=1
outp=0
count=0
print(dict1)
for x in dict1.keys():
    if dict1[x]%2 == 0:
        outp += dict1[x]
    else:
        count += 1
        if dict1[x]>2:
            outp += (dict1[x]-1)
if count>0:
     outp += 1
print(outp)