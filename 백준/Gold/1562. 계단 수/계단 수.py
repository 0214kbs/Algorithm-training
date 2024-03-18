import sys
input = sys.stdin.readline


n = int(input())
dp = [[[0 for _ in range(1<<10)] for _ in range(10)] for _ in range(n)]

mod = 1000000000
res = 0

for k in range(1,10):
    dp[0][k][1<<k] = 1


for i in range(1,n):
    for k in range(10):
        for bit in range(1024): # 2^10
            if k-1 >=0:
                dp[i][k][bit|(1<<k)] += dp[i-1][k-1][bit]
            if k+1 <=9:
                dp[i][k][bit|(1<<k)] += dp[i-1][k+1][bit]
            dp[i][k][bit|(1<<k)] %=mod


for k in range(10):
    res += dp[n-1][k][1023] # 1111111111(2) = 1023
    res%=mod

print(res)