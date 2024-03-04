import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

dp = [1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if arr[i]>arr[j]:
            dp[i] = max(dp[i],dp[j]+1)

# print(dp)
max_len = max(dp)
idx = dp.index(max_len)

res = []
while idx>=0:
    if dp[idx] == max_len:
        res.append(arr[idx])
        max_len -=1
        # print(res)
    idx -=1

res.reverse()
print(len(res))
print(*res)