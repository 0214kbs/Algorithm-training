import sys
from collections import deque
input = sys.stdin.readline
dr = [0,0,-1,1]
dc = [-1,1,0,0]
n,m = map(int,input().split())
board= [list(map(int, input().split())) for _ in range(n)]
cheese = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            cheese += 1

def bfs(i,j):
    global cheese
    q = deque()
    q.append([i,j])
    visited[i][j] = True
    while q:
        r,c = q.popleft()
        for d in range(4):
            nr = r+dr[d]
            nc = c+dc[d]

            if nr<0 or nc<0 or nr>=n or nc>=m or visited[nr][nc]:
                continue
            visited[nr][nc] = True
            if board[nr][nc] == 1:
                board[nr][nc] = 0
                cheese -=1
            else:
                q.append([nr,nc])

res = 0
check = [cheese]
while cheese>0:
    visited = [[False]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if not visited[i][j]:
                if i==0 or i==n-1 or j==0 or j==m-1:
                    bfs(i,j) # 구멍이 아닌경우에만 진행
    res +=1
    if cheese != 0:
        check.append(cheese)
    # print(res,cheese)
# print(check)
print(res)
print(check[-1])