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
dp = [arr[0]]
for i in range(n):
    if arr[i] > dp[-1]:
        dp.append(arr[i])
    else:
        idx = bs(dp,arr[i])
        dp[idx] = arr[i]

print(len(dp))