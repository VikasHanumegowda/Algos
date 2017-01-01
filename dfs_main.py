n=int(input("Number of nodes :"))
dict={}
keys=list()

for x in range(n):
    y=int(input("Enter node name:"))
    keys.extend([y])

print(keys)
print(dict.fromkeys(keys, 0))
explored={1:0}
explored_list=[1]

for x in range(n):
    list=input("Enter adjacency list of "+str(keys[x])+" :\n").strip().split()
    list=[int(i) for i in list]
    list.reverse()
    dict[keys[x]]=list

print("dict : "+ str(dict))

while len(explored_list):
    y=explored_list.pop(-1)
    print(y,end=' ') #the DFS traversal

    if not y in explored or not explored[y]:
        explored[y]=1
        if dict.get(y,0):
            explored_list.extend(dict[y])
    