nums1=[1,2]
nums2=[2,1]
nums1.sort()
nums2.sort()
len1=len(nums1)
len2=len(nums2)
listo=[]
cont=1
x=0
y=0
if len1==0 or len2==0:
    print(listo)
while True:
    if nums1[x]==nums2[y]:
        listo.extend([nums1[x]])
        x+=1
        y+=1
    elif nums1[x]>nums2[y]:
        y+=1
    else:
        x+=1
    if x<len1 and y<len2:
        continue
    else:
        break
print(listo)