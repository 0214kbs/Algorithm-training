import sys

input = sys.stdin.readline

n, m = map(int, input().split())
cx, cy, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
# print(board)
dxy = [(-1, 0), (0, 1), (1, 0), (0, -1)]

res = 0


def robotclean(cx, cy, d):
    global res
    if board[cx][cy] == 0:
        board[cx][cy] = 2
        res += 1

    for i in range(4,0,-1):
        nd = (d+i-1)%4
        dx,dy = dxy[nd]
        nx = cx+dx
        ny = cy+dy
        if board[nx][ny]==0:
            robotclean(nx,ny,nd)
            return

    dx, dy = dxy[d]
    nx = cx - dx
    ny = cy - dy
    if board[nx][ny] == 1:
        return
    else:
        robotclean(nx,ny,d)


robotclean(cx, cy, d)
print(res)
