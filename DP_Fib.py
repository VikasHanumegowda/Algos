import time

print("hello\n")
dict1={}
def fib(x):
    if x==0:return 0
    if x==1:return 1
    if x in dict1:
        return dict1[x]
    else:
        dict1[x]=fib(x-1)+fib(x-2)
        return dict1[x]
start=time.time()
print(fib(40))
end=time.time()
print(end-start)


start=time.time()
n=2
x,y=0,1
while(n<=40):
    z=x+y
    x=y
    y=z
    n+=1
print(z)
end=time.time()
print(end-start)
# while(n<=40)
# {
#     if()
# }