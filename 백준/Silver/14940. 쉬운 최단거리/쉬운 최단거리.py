import sys
from collections import deque

dr = [0,0,-1,1]
dc = [-1,1,0,0]

input = sys.stdin.readline

n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
q = deque()
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            q.append([i,j,0])
            break

result = [[0]*m for _ in range(n)]

while q:
    cr,cc,cn = q.popleft()
    for d in range(4):
        nr,nc = cr+dr[d], cc+dc[d]
        if 0<=nr<n and 0<=nc<m:
            if board[nr][nc] == 1 and result[nr][nc] == 0:
                q.append([nr,nc,cn+1])
                result[nr][nc] = cn+1

for i in range(n):
    for j in range(m):
        if result[i][j] == 0 and board[i][j] == 1:
            result[i][j] = -1

for i in range(n):
    print(*result[i])