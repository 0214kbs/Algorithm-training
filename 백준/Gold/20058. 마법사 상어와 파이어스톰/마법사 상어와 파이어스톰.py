import sys
input = sys.stdin.readline
from collections import deque
# N, Q, board[][], visited[][], L[]
N,Q = map(int, input().split())
board = []
for _ in range(2**N):
    board.append(list(map(int,input().split())))
L = list(map(int, input().split()))
visited = [[False]*(2**N) for _ in range(2**N)]

dr = [0,0, -1, 1]
dc = [-1,1,0,0]

max_cnt = 0
total = 0
for r in range(2**N):
    for c in range(2**N):
        total += board[r][c]

def find_near_count(cr,cc):
    near_cnt  = 0
    for d in range(4):
        nr = cr + dr[d]
        nc = cc + dc[d]

        if nr < 0 or nc < 0 or nr >= 2 ** N or nc >= 2 ** N:
            continue
        if board[nr][nc] > 0:
            near_cnt+=1
    if near_cnt<3:
        return False
    else:
        return True
def find_ice_lump(r,c):
    global max_cnt
    visited[r][c] = True
    q = deque()
    q.append((r,c))
    cnt = 1
    while q:
        cr,cc = q.popleft()
        for d in range(4):
            nr = cr+dr[d]
            nc = cc+dc[d]
            if nr<0 or nc<0 or nr>=2**N or nc >= 2**N or visited[nr][nc] or board[nr][nc]<=0:
                continue
            visited[nr][nc] = True
            q.append((nr,nc))
            cnt+=1
    max_cnt = max(max_cnt, cnt)


def rotate(a):
    n = len(a)
    res = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            res[j][n-i-1] = a[i][j]
    # print(res)
    return res

def rotate_by_L(sizeL):
    tmp = 2**N//sizeL

    for ri in range(tmp):
        for ci in range(tmp):
            tmp_board = [[0]*sizeL for _ in range(sizeL)]
            for rj in range(ri*sizeL, ri*sizeL+sizeL):
                for cj in range(ci * sizeL, ci * sizeL + sizeL):
                    tmp_board[rj-ri*sizeL][cj-ci*sizeL] = board[rj][cj]
            tmp_board = rotate(tmp_board)
            for rj in range(ri*sizeL, ri*sizeL+sizeL):
                for cj in range(ci * sizeL, ci * sizeL + sizeL):
                    board[rj][cj] = tmp_board[rj-ri*sizeL][cj-ci*sizeL]



for l in L:
    arr =[]
    rotate_by_L(2**l)
    for i in range(2**N):
        for j in range(2**N):
            if board[i][j] >0 and not find_near_count(i,j):
                # print(board[i][j],i,j, board)
                arr.append((i,j))
                # board[i][j] -=1
                # total -=1
    for r,c in arr:
        board[r][c] -=1
        total -=1
for i in range(2 ** N):
    for j in range(2 ** N):
        if not visited[i][j] and board[i][j]>0:
            find_ice_lump(i, j)

print(total)
print(max_cnt)