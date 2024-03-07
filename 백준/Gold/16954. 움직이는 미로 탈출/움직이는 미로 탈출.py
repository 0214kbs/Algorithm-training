import sys
from collections import deque

input = sys.stdin.readline
dr = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
dc = [-1, 0, 1, -1, 0, 1, -1, 0, 1]


board = [list(input().rstrip()) for _ in range(8)]
walls = []
for i in range(8):
    for j in range(8):
        if board[i][j] == '#':
            walls.append([i, j])

# 시작 : (7,0) 끝 : (0..
def bfs():
    time = 0
    q = deque()
    q.append([7, 0])
    while q:
        for _ in range(len(q)):
            r, c = q.popleft()
            # print(r,c)
            if [r, c] in walls:
                continue
            if r == 0 or time == 9:
                print(1)
                return
            for d in range(9):
                nr = dr[d] + r
                nc = dc[d] + c
                if 0 <= nr < 8 and 0 <= nc < 8:
                    if [nr, nc] not in walls:
                        q.append([nr,nc])
        for w in range(len(walls)):
            walls[w] = [walls[w][0] + 1, walls[w][1]]
        time += 1
    print(0)

if len(walls) == 0:
    print(1)
else:
    bfs()