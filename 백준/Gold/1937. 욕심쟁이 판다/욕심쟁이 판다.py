import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

dr = [0,0,-1,1]
dc = [-1,1,0,0]


def dfs(r,c):
    if dp[r][c] != 0:
        return dp[r][c]
    dp[r][c] = 1
    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]

        if 0<=nr<n and 0<=nc<n and board[r][c] < board[nr][nc]:
            dp[r][c] = max(dp[r][c], dfs(nr,nc)+1)
    return dp[r][c]

n = int(input())
board= [list(map(int, input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]
res = 0
for i in range(n):
    for j in range(n):
        res = max(res, dfs(i,j))
print(res)