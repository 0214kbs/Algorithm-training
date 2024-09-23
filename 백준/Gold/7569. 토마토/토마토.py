import sys
from collections import deque
input = sys.stdin.readline

# 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
drc = [(-1,0,0),(1,0,0),(0,-1,0), (0,1,0),(0,0,-1),(0,0,1)]
M, N, H = map(int, input().split())
storage = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

zero = 0
q = deque()
for k in range(H):
    for i in range(N):
        for j in range(M):
            if storage[k][i][j] == 1:
                q.append([0, k, i, j])
            elif storage[k][i][j] == 0:
                zero+=1

time = 0
while q:
    ct, ch, cr,cc = q.popleft()
    for dh, dr,dc in drc:
        nh, nr,nc = ch+dh, cr+dr, cc+dc
        if 0<=nr<N and 0<=nc<M and 0<=nh<H:
            if storage[nh][nr][nc] == 0:
                zero -=1
                storage[nh][nr][nc] = ct+1
                q.append([ct+1, nh, nr,nc])
                time = max(ct+1, time)

# print(storage)
if zero == 0:
    print(time)
else:
    print(-1)