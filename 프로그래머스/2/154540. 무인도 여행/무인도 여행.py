from collections import deque
drc = [(0,-1),(0,1),(1,0),(-1,0)]
board = []
visited = []
n, m = 0,0
def start(i,j):
    global visited
    cnt = int(board[i][j])
    q = deque()
    q.append([i,j])
    visited[i][j] = True
    while q:
        cr, cc = q.popleft()
        for dr, dc in drc:
            nr, nc = cr+dr, cc+dc
            
            if 0<=nr<n and 0<=nc<m and board[nr][nc] != 'X' and not visited[nr][nc]:
                visited[nr][nc] = True
                cnt += int(board[nr][nc])
                q.append([nr,nc])
    return cnt
    
def solution(maps):
    global board, visited,n,m
    answer = []
    n,m = len(maps), len(maps[0])
    board = [list(maps[i]) for i in range(n)]
    visited = [[False]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if board[i][j] != 'X' and not visited[i][j]:
                # print(i,j)
                answer.append(start(i,j))
    if len(answer) == 0:
        return [-1]
    else:
        answer.sort()
        return answer
