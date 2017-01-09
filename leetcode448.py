import time
nums=[4,3,2,7,8,2,3,1]
out = []
t1=time.time()
for x in range(len(nums)):
    if nums[abs(nums[x]) - 1]>0:
        nums[abs(nums[x]) - 1] = -nums[abs(nums[x]) - 1]

for x in range(len(nums)):
    if nums[x] > 0:
        out.extend([x + 1])
t2=time.time()
t3=t2-t1
print()
print(out)

t1=time.time()
nums=[4,3,2,7,8,2,3,1]

out=[]

for x in range(len(nums)):
    if x+1 not in nums:
        out.extend([x+1])


t2=time.time()
t4=t2-t1
print(t4-t3)
print(out)