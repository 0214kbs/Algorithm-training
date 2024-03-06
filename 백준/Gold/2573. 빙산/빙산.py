import sys
from copy import deepcopy
from collections import deque
input = sys.stdin.readline

dr = [0,0,-1,1]
dc = [-1,1,0,0]
n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

def count(i,j):
    cnt = 0
    for d in range(4):
        nr = i+dr[d]
        nc = j+dc[d]
        if 0 <= nr < n and 0 <= nc < m and board[nr][nc] <= 0:
            cnt+=1
    return cnt

def melting(i,j):
    global board
    board2 = deepcopy(board)
    board2[i][j] = board2[i][j] - count(i,j)
    visited[i][j] = True
    q = deque()
    q.append([i, j])
    while q:
        r, c = q.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < n and 0 <= nc < m and board[nr][nc] > 0 and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append([nr,nc])
                board2[nr][nc] = board2[nr][nc]- count(nr,nc)

    board = board2

time = 0
while True:
    visited = [[False] * m for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] >0 and not visited[i][j]:
                if cnt == 0:
                    melting(i,j)
                    cnt+=1
                else:
                    print(time)
                    exit()
    if cnt ==0:
        print(0)
        break
    # print(board)
    time+=1