import sys
from collections import deque

input = sys.stdin.readline

a,b = map(int,input().split())
board = [list(input().rstrip()) for _ in range(a)]

dr = [0,0,-1,1]
dc = [-1,1,0,0]
res = 0
for i in range(a):
    for j in range(b):
        if board[i][j] == 'L':
            q = deque()
            q.append([i,j,0])
            visited = [[False]*b for _ in range(a)]
            visited[i][j] = True
            max_tmp = 0
            while q:
                r,c,cnt = q.popleft()
                for d in range(4):
                    nr = dr[d]+r
                    nc = dc[d]+c

                    if nr<0 or nc<0 or nr>=a or nc>=b:
                        continue
                    if visited[nr][nc]:
                        continue
                    visited[nr][nc] = True
                    if board[nr][nc] == 'L':
                        q.append([nr,nc,cnt+1])
                        max_tmp = max(max_tmp, cnt+1)
            res = max(max_tmp, res)
print(res)