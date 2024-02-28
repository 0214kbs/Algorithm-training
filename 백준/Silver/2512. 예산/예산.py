import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
total = int(input())

res = 0
s,e = 1, max(nums)
while s<=e:
    mid = (s+e)//2

    cnt = 0
    for i in range(n):
        if mid <= nums[i]:
            cnt += mid
        else:
            cnt += nums[i]
    if cnt<=total:
        res = max(res,mid)
        s = mid+1
    else:
        e = mid-1

print(res)