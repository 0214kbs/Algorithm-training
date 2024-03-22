n, m, x, y, k = map(int, input().split())

dxy = [(0,0),(0,1),(0,-1),(-1,0),(1,0)]
dice = [0, 0, 0, 0, 0, 0]

def turn(dir):
    a, b, c, d, e, f = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]
    if dir == 1: #동
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = d, b, a, f, e, c

    elif dir == 2: #서
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = c, b, f, a, e, d

    elif dir == 3: #북
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = e, a, c, d, f, b

    else: #남
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = b, f, c, d, a, e

board= [list(map(int, input().split())) for _ in range(n)]
orders = list(map(int, input().split()))

cur = [x, y]
for d in orders:
    nx,ny = cur[0]+dxy[d][0], cur[1]+dxy[d][1]

    if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
    turn(d)
    if board[nx][ny] == 0:
        board[nx][ny] = dice[-1]
    else:
        dice[-1] = board[nx][ny]
        board[nx][ny] = 0
    cur = [nx,ny]
    print(dice[0])