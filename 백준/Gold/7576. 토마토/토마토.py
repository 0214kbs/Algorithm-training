import sys
from collections import deque
input = sys.stdin.readline

drc = [(-1,0),(1,0),(0,-1), (0,1)]
M, N = map(int, input().split())
storage = [list(map(int, input().split())) for _ in range(N)]

zero = 0
q = deque()
for i in range(N):
    for j in range(M):
        if storage[i][j] == 1:
            q.append([0, i, j])
        elif storage[i][j] == 0:
            zero+=1

time = 0
while q:
    ct, cr,cc = q.popleft()
    for dr,dc in drc:
        nr,nc = cr+dr, cc+dc
        if 0<=nr<N and 0<=nc<M and storage[nr][nc] == 0:
            zero -=1
            storage[nr][nc] = ct+1
            q.append([ct+1, nr,nc])
            time = max(ct+1, time)
# print(storage)
if zero == 0:
    print(time)
else:
    print(-1)