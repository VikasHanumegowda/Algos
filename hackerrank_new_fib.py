import math
t1,t2,n1=[int(i) for i in input().strip().split()]
opt={}
def fib(n):
    if n==1:
        return t1
    if n==2:
        return t2
    if n in opt:
        return opt[n]
    var=int(fib(n-2)+pow(fib(n-1),2))
    opt[n]=int(var)
    return int(var)
print(fib(n1))
#print(t1,t2,n)