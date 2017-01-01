a=int(input())
b=int(input())

print(len([x for x in range(a)]+[x for x in range(b)]))
while(a!=0):
    s=(a^b)
    c=a&b
    a=c<<1
    b=s
print(b)


# c=a&b
# print((c<<1)+(a^b))