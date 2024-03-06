import sys
from collections import deque
input = sys.stdin.readline

n,min_p,max_p = map(int, input().split())
board = [list(map(int,input().split())) for _ in range(n)]
dr = [1,-1,0,0]
dc = [0,0,-1,1]

def check(i,j,num):
    q = deque()
    q.append([i,j])
    sum_v = board[i][j]
    visited[i][j] = num
    cnt = 1

    while q:
        r,c = q.popleft()
        for d in range(4):
            nr = dr[d]+r
            nc= dc[d]+c

            if 0<=nr<n and 0<=nc<n and visited[nr][nc] ==0 :
                if min_p<=abs(board[nr][nc] - board[r][c])<=max_p:
                    visited[nr][nc] = num
                    sum_v+=board[nr][nc]
                    q.append([nr,nc])
                    cnt +=1
    if cnt>1:
        for r in range(n):
            for c in range(n):
                if visited[r][c] == num:
                    board[r][c] = sum_v//cnt
        return True
    return False

for t in range(2001):
    cnt = 0; tmp = 1
    visited = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j]==0:
                if check(i,j, tmp):
                    cnt+=1
                tmp+=1
    if cnt == 0:
        print(t)
        break