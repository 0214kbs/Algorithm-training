import sys
input = sys.stdin.readline

n,m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, list(input().rstrip()))))

dp = [[0]*m for _ in range(n)]

for r in range(n):
    dp[r][0] = board[r][0]

for c in range(m):
    dp[0][c] = board[0][c]

res = 0
for r in range(1, n):
    for c in range(1, m):
        if board[r][c] == 0:
            continue
        dp[r][c] = min(dp[r-1][c],dp[r][c-1],dp[r-1][c-1])+1

for i in range(n):
    # print(dp[i])
    res = max(res, max(dp[i]))
print(res*res)