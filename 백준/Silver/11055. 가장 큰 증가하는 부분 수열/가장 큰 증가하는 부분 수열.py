import sys

input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))

dp = [0]*1001
dp[A[0]] = A[0]

for i in range(1,n):
    tmp = 0
    for j in range(0,i):
        if A[j]<A[i]:
            tmp = max(tmp,dp[A[j]])
    dp[A[i]] = tmp+A[i]

print(max(dp))