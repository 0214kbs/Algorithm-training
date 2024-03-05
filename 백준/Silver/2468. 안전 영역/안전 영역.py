import sys
from collections import deque
input = sys.stdin.readline

dr = [0,0,-1,1]
dc = [1,-1,0,0]

n = int(input())
max_v = 0
board = []
for i in range(n):
    tmp = list(map(int, input().split()))
    max_v = max(max_v, max(tmp))
    board.append(tmp)

res = 0
for time in range(max_v+1):
    cnt = 0
    visited = [[False]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if not visited[i][j] and board[i][j]-time>0:
                q = deque()
                q.append([i,j])
                cnt+=1
                while q:
                    r,c = q.popleft()
                    for d in range(4):
                        nr = r+dr[d]
                        nc = c+dc[d]
                        if nr<0 or nc<0 or nr>=n or nc>=n:
                            continue
                        if visited[nr][nc]:
                            continue
                        visited[nr][nc] = True
                        if board[nr][nc]-time>0:
                            q.append([nr,nc])
    res = max(res, cnt)
print(res)
