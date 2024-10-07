import sys

input = sys.stdin.readline

INF = int(1e6 + 1)
N = int(input())
dp = [[INF, [i]] for i in range(N + 1)]

dp[1][0] = 0
for i in range(1, N):
    if i * 3 < N + 1 and dp[i * 3][0] > dp[i][0] + 1:
        dp[i * 3][0] = dp[i][0] + 1
        dp[i * 3][1] = dp[i][1] + [i*3]

    if i * 2 < N + 1 and dp[i * 2][0] > dp[i][0] + 1:
        dp[i * 2][0] = dp[i][0] + 1
        dp[i * 2][1] = dp[i][1] + [i*2]
    if dp[i + 1][0] > dp[i][0] + 1:
        dp[i + 1][0] = dp[i][0] + 1
        dp[i + 1][1] = dp[i][1] +[i+1]
print(dp[N][0] )
print(*dp[N][1][::-1])
