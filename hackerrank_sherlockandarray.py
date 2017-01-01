k = int(input().strip())


def add(i1, j1, arr1):
    sum1 = 0
    for x in range(i1, j1 + 1):
        sum1 += arr1[x]
    return sum1

count = 0
for i in range(k):
    n = int(input().strip())
    count = 0
    arr = [int(x) for x in input().strip().split()]
    for p in range(n):
        sum_l = 0
        sum_r = 0
        count = 0
        if p == 0:
            sum_l = 0
            sum_r = add(1, n - 1, arr)
            if sum_l == sum_r:
                count += 1
        elif p == n - 1:
            sum_r = 0
            sum_l = add(0, n - 2, arr)
            if sum_l == sum_r:
                count += 1
        # elif p == n - 2:
        #     sum_r = arr[n - 1]
        #     sum_l = add(0, p - 1, arr)
        #     if sum_l == sum_r:
        #         count += 1
        # elif p == 1:
        #     sum_l = arr[0]
        #     for x in range(p + 1, n):
        #         sum_r += arr[x]
        #     if sum_l == sum_r:
        #         count += 1

        else:
            sum_l=add(0,p-1,arr)
            sum_r=add(p+1,n-1,arr)
            if sum_l == sum_r:
                count += 1
        if count != 0:
            print("YES")
            break
    if not count:
        print("NO")
