import sys
input = sys.stdin.readline
INF = 1000000
n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[[INF]*3 for _ in range(m)] for _ in range(n)]


for i in range(m):
    dp[0][i][0] = board[0][i]
    dp[0][i][1] = board[0][i]
    dp[0][i][2] = board[0][i]

for ri in range(1, n):
    for ci in range(m):

        if ci != 0:
            dp[ri][ci][0] = min(dp[ri-1][ci-1][1],dp[ri-1][ci-1][2])+board[ri][ci]
        dp[ri][ci][1] = min(dp[ri-1][ci][0],dp[ri-1][ci][2])+board[ri][ci]
        if ci != m-1:
            dp[ri][ci][2] = min(dp[ri - 1][ci + 1][0], dp[ri - 1][ci + 1][1]) + board[ri][ci]

res = INF
for i in range(m):
    res = min(res, min(dp[-1][i]))
    # print(dp[i])
print(res)