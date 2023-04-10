from collections import deque
import sys

input = sys.stdin.readline
dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


def bfs():
    while q:
        x, y, z = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m and maps[nx][ny][nz] == 0:
                maps[nx][ny][nz] = maps[x][y][z] + 1
                q.append([nx, ny, nz])


m, n, h = map(int, input().split())
maps = []
q = deque()

for i in range(h):
    boxes = []
    for j in range(n):  # 익은 토마토 저장
        boxes.append(list(map(int, input().split())))
        for k in range(m):
            if boxes[j][k] == 1:
                q.append([i, j, k])
    maps.append(boxes)

bfs()

res = 0
for i in maps:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                exit(0)
        res = max(res, max(j))
print(res - 1)
