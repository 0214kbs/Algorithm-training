import sys
input = sys.stdin.readline
drc = [(0,-1),(0,1),(1,0),(-1,0)]
max_v = 0

def other_ttmn(r,c,tmp,cnt):
    global max_v

    if cnt == 4:
        max_v = max(max_v, tmp)
        return
    for dr,dc in drc:
        nr,nc = dr+r, dc+c
        if nr<0 or nc<0 or nr>=n or nc>=m or visited[nr][nc]:
            continue
        visited[nr][nc] = True
        other_ttmn(nr,nc,tmp+board[nr][nc], cnt+1)
        visited[nr][nc] = False

def ttmn_ㅗ(r,c):
    global max_v

    arr = []
    for dr,dc in drc:
        nr,nc = r+dr, c+dc
        if nr < 0 or nc < 0 or nr >= n or nc >= m:
            continue
        arr.append(board[nr][nc])
    if len(arr) == 4:
        arr.sort()
        arr = arr[1:]
        max_v = max(max_v, sum(arr)+board[r][c])
    elif len(arr) == 3:
        max_v = max(max_v, sum(arr)+board[r][c])
    return

n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        other_ttmn(i,j,board[i][j],1)
        ttmn_ㅗ(i,j)
        visited[i][j] = False

print(max_v)