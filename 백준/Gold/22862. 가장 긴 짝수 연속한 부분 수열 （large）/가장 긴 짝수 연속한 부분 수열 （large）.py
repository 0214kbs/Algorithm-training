n,k = map(int, input().split())
nums = list(map(int, input().split()))

start, end = 0,0
res,odd, length = 0,0,0

for start in range(n):
    while odd<=k and end<n:
        if nums[end]%2==1:
            odd+=1
        else:
            length +=1
        if start == 0 and end == n:
            res = length
            break
        end+=1
    res = max(res, length)

    if nums[start]%2==1:
        odd -=1
    else:
        length -=1

print(res)