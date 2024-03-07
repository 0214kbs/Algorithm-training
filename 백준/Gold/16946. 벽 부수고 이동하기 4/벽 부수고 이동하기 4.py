import sys
from collections import deque

input = sys.stdin.readline
dr = [0, 0, -1, 1]
dc = [-1, 1, 0, 0]


def bfs(r, c):
    q = deque()
    q.append([r, c])
    visited[r][c] = True
    cnt = 1
    while q:
        cr, cc = q.popleft()
        zeros[cr][cc] = group
        for d in range(4):
            nr, nc = cr + dr[d], cc + dc[d]
            if 0 <= nr < n and 0 <= nc < m and board[nr][nc] == 0 and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append([nr,nc])
                cnt+=1
    return cnt

def countMoves(r,c):
    tmp = set()
    for d in range(4):
        nr, nc = r+ dr[d], c + dc[d]
        if 0 <= nr < n and 0 <= nc < m and zeros[nr][nc]>0:
            tmp.add(zeros[nr][nc])
    cnt = 1
    for t in tmp:
        cnt += info[t]
        cnt = cnt%10
    return cnt


n, m = map(int, input().split())
board = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
zeros = [[0 for _ in range(m)] for _ in range(n)]
group = 1
info ={}

for i in range(n):
    for j in range(m):
        if board[i][j] == 0 and not visited[i][j]:
            cnt = bfs(i, j)
            info[group] = cnt
            group +=1

answer = [[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] ==1:
            answer[i][j] = countMoves(i,j)

# print(info)
for i in range(n):
    for j in range(m):
        print(answer[i][j], end="")
    print()