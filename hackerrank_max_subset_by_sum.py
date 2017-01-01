# n, k = [int(x) for x in input().strip().split()]
# a = [int(x) for x in input().strip().split()]
# sorted(a)
#
# dict1 = {}
#
#
# def pass_it(x, y):
#     for z in y:
#         if (z + x) % k == 0:
#             return False
#     return True
#
# for x in a:
#     if(x not in dict1):
#         dict1[x]=[x]
#         for y in a:
#             if(y!=x):
#                 tof = pass_it(y, dict1[x])
#                 if (tof):
#                     dict1[x].extend([y])
#
#     else:
#         pass
# max_l=0
# for x in dict1:
#     if(len(dict1[x])>max_l):
#         max_l=len(dict1[x])
# print(max_l)



n, k = [int(x) for x in input().strip().split()]
a = [int(x) for x in input().strip().split()]


def pass_it(x, y):
    if (y + x) % k == 0:
        return False
    return True


dict1={}

for x in a:
    dict1[x]=[x]
max_l=0
for x in dict1:
    for y in dict1:
        if x!=y:
            if(pass_it(x,y)):
                dict1[x].extend([y])
    max_l=len(dict1[x]) if len(dict1[x])>max_l else max_l
print(max_l)
