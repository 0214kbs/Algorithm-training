import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))

dp = [1000000000]*n
dp[0] = 0

for i in range(1,n):

    for j in range(i):
        power = max((i-j)*(1+abs(A[i]-A[j])), dp[j])
        dp[i] = min(power, dp[i])

print(dp[-1])