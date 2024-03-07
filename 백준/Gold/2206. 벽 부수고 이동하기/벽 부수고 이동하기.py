import sys
from collections import deque
input = sys.stdin.readline
dr = [0,0,-1,1]
dc = [-1,1,0,0]

n,m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]
visited = [[[False]*m for _ in range(n)] for _ in range(2)]
FLAG = False
res = n*n+1

q = deque()
q.append([0,0,1,1])
visited[1][0][0] = True
while q:
    r,c,cnt, can_break = q.popleft()
    # print(r,c,can_break)
    if (r,c) == (n-1,m-1):
        FLAG = True
        res = min(res, cnt)
    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]
        if nr<0 or nc<0 or nr>=n or nc>=m or visited[can_break][nr][nc]:
            continue
        if board[nr][nc] == '1':
            if can_break == 1:
                visited[0][nr][nc] = True
                q.append([nr,nc,cnt+1,0])
        else:
            visited[can_break][nr][nc] = True
            q.append([nr,nc,cnt+1, can_break])

if not FLAG:
    print(-1)
else:
    print(res)