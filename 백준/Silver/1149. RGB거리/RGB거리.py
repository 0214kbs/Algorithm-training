import sys
input = sys.stdin.readline

N = int(input())
dp = [[0]*3 for _ in range(N)]

for i in range(N):
    r,g,b = map(int, input().split())
    if i == 0:
        dp[i][0], dp[i][1], dp[i][2] = r,g,b
    else:
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + r
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + g
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + b

print(min(dp[N-1]))