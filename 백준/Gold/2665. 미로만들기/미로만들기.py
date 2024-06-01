import sys
from collections import deque
drc = [(0,-1),(0,1),(-1,0),(1,0)]
input = sys.stdin.readline

n = int(input())
board= [[int(c) for c in input().rstrip()] for _ in range(n)]

visit = [[False]*n for _ in range(n)]
visit[0][0] = True

q= deque()
q.append([0,0,0])
res = n*n
while q:
    cr,cc,cn= q.popleft()
    if (cr,cc) == (n-1,n-1):
        res = min(res,cn)
        continue
    for dr,dc in drc:
        nr,nc = cr+dr, cc+dc
        if 0<=nr<n and 0<=nc<n and not visit[nr][nc]:
            if board[nr][nc] == 1:
                visit[nr][nc] = True
                q.appendleft([nr,nc,cn])
            else:
                visit[nr][nc] = True
                q.append([nr,nc,cn+1])
print(res)