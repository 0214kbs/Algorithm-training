import sys
input = sys.stdin.readline

def bs(arr,target):
    left, right = 0, len(arr)-1
    while left<= right:
        mid = (left+right)//2
        if arr[mid]<target:
            left = mid+1
        else:
            right = mid-1
    return left

n = int(input())
arr = list(map(int, input().split()))
INF = int(1e10)

check = [0]*n
inc_arr = [INF]*n

for i, x in enumerate(arr):
    idx = bs(inc_arr,x)
    inc_arr[idx] = x
    check[i] = idx
    # print(inc_arr)
    # print(check)

max_len = max(check)
idx = check.index(max_len)

res = []
while idx>=0:
    if check[idx] == max_len:
        res.append(arr[idx])
        max_len -=1
        # print(res)
    idx -=1

res.reverse()
print(len(res))
print(*res)