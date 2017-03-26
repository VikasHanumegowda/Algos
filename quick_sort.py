n=int(input())
in_arr=[int(x) for x in input().split()]

def quicksort(A,lo,hi):
    if lo<hi:
        p = partition(A,lo,hi)
        quicksort(A,lo,p-1)
        quicksort(A,p+1,hi)
    
    
def partition(A,lo,hi):
    #print(lo,hi)
    pivot=hi
    i=lo-1
    for j in range(lo,hi):
        if A[j]<=A[pivot]:
            i+=1
            A[i],A[j]=A[j],A[i]
    A[i+1],A[pivot]=A[pivot],A[i+1]
    for x,y in enumerate(A):
        if x!=len(A)-1:
            print(y,end=" ")
        else:
            print(y)
    return i+1

quicksort(in_arr,0,n-1)
