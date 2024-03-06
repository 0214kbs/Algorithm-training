import sys
from collections import deque
input = sys.stdin.readline

n,m,a,b,k = map(int,input().split())
board = [[0]*m for _ in range(n)]
visited = [[0]*m for _ in range(n)]

dr = [0,0,1,-1]
dc = [1,-1,0,0]

for i in range(k):
    r,c=map(int,input().split())
    board[r-1][c-1]=1

sr,sc = map(int,input().split())
er,ec = map(int,input().split())
sr,sc = sr-1,sc-1
er,ec = er-1,ec-1

if board[sr][sc] == 1 or board[er][ec] == 1:
    print(-1)
    exit()

q = deque()
q.append((sr,sc))
visited[sr][sc]=1


def check(r,c,dir):
    for i in range(a):
        for j in range(b):
            nr = r+dr[dir]+i
            nc = c+dc[dir]+j
            if nr<0 or nc<0 or nr>=n or nc>=m:
                return False
            if board[nr][nc]==1:
                return False
    return True

while q:
    r,c=q.popleft()
    for dir in range(4):
        nr=r+dr[dir]
        nc=c+dc[dir]
        if nr<0 or nc<0 or nr>=n or nc>=m:
            continue
        if visited[nr][nc]:
            continue
        if check(r,c,dir):
            visited[nr][nc]=visited[r][c]+1
            q.append((nr,nc))
if visited[er][ec]:
    print(visited[er][ec]-1)
else:
    print(-1)