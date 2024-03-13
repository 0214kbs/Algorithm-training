n = int(input())
nums = list(map(int,input().split()))

nums.sort()
check = [False]*n
cnt = 0
for i in range(n):
    if check[i]:
        continue
    k = nums[i]
    start, end = 0,n-1

    while start<end:
        if i==start:
            start+=1
            continue
        elif i==end:
            end-=1
            continue
        if nums[start]+nums[end] == k:
            check[i] = True
            cnt+=1
            break
        elif nums[start]+nums[end]<k:
            start+=1
        else:
            end-=1

# print(check)
print(cnt)