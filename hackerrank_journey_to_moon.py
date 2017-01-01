n, i = [int(x) for x in input().strip().split()]
inp = []
dict1 = {}
for x in range(i):
    inp.append([int(y) for y in input().strip().split()])
inp.sort()
dict_index_count=0
dict1[dict_index_count] = inp[0]
for x in range(1, i):
    a=inp[x][0]
    count = 0
    for b in dict1:
        if (a in dict1[b]):
            dict1[b].extend([inp[x][1]])
            count+=1
    if(count==0):
        dict_index_count+=1
        dict1[dict_index_count]=inp[x]
    else:
        count=0
#print(dict1)
dict2={}
dict2_index_count=0
for x in range(len(dict1)):
    for y in range(x,len(dict1)):
        if x != y:
            if len(set(dict1[x])&set(dict1[y])) != 0:
                dict1[x]=list(set(dict1[x])|set(dict1[y]))
                dict2[y]=dict1[y]
                #print(dict1)
# print(dict2)
# print(dict1)

for x in dict2:
    #print(dict1)
    dict1.__delitem__(x)
    #print(dict1)
    print()
# print(dict2)
# print(dict1)
sum=1
if(len(dict1)==2):
    for x in dict1:
        sum*=len(dict1[x])
    print(sum)

'''
4 2
0 1
2 3


10 7
0 2
1 8
1 4
2 8
2 6
3 5
6 9
'''