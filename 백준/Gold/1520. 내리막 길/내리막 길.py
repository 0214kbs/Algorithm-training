import sys
from collections import deque
input = sys.stdin.readline
dr = [0,0,-1,1]
dc = [-1,1,0,0]

n, m = map(int, input().split())
board= [list(map(int, input().split())) for _ in range(n)]

dp = [[-1]*m for _ in range(n)]

def dfs(r,c):
    if (r,c) == (n-1,m-1):
        return 1

    if dp[r][c] != -1:
        return dp[r][c]

    dp[r][c] = 0

    for d in range(4):
        nr,nc = r+dr[d], c+dc[d]
        if 0<=nr<n and 0<=nc<m:
            if board[nr][nc] < board[r][c]:
                dp[r][c] += dfs(nr,nc)
    return dp[r][c]

print(dfs(0,0))