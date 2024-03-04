import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr = list(map(int, input().split()))

res = 0
left = 0
right = max(arr)

def divide(x):
    max_v,  min_v = arr[0], arr[0]
    cnt = 1
    for i in range(1,n):
        max_v = max(max_v,arr[i])
        min_v = min(min_v, arr[i])
        if max_v -min_v>x:
            cnt+=1
            max_v = arr[i]
            min_v = arr[i]
    return cnt

while left<=right:
    mid = (left+right)//2
    if divide(mid) > m:
        left = mid+1
    else:
        right =mid-1
        res = mid
print(res)