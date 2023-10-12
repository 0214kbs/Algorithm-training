import sys
input = sys.stdin.readline

N = int(input())
board = []
for i in range(N):
    board.append(list(map(int, input().split())))


# x기준 좌표
# (0,-2)는 알파 -> 따로 계산하기
spread_sand = [(-2,-1), (-1,-2), (-1,-1),(-1,0),(0,-3),(1,-2), (1,-1),(1,0),(2,-1)]
spread_sand_value = [0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02 ]
# 방향에 따른 spread sand :
# spread_sand_d = [(1,1),(-1,1),(-1,-1),(-1,0)]


# 좌 하 우 상
dir = [(0,-1),(1,0),(0,1),(-1,0)]

# 현재 위치
xr = N//2
xc = N//2

# 벗어난 모래
out_sand = 0

def real_rc(r,c,d):
    if d == 0:
        return r,c
    elif d == 1:
        return -c, -r
    elif d == 2:
        return -r,-c
    else: #d == 3:
        return c,r
def moving_sand(d): # d 이동 방향

    # print('d' ,d)
    global out_sand, xr, xc
    dr, dc = dir[d]
    # print('dr, dc', dr,dc)
    yr = xr+dr
    yc = xc+dc
    # print('x :', xr,xc)
    # print('y : ',yr,yc)
    y_val = board[yr][yc]
    # print(y_val)
    count = 0

    # spread
    for spread_i in range(len(spread_sand)):
        sr_tmp, sc_tmp = spread_sand[spread_i]

        # 위치 계산
        sr, sc = real_rc(sr_tmp, sc_tmp,d)
        sr+= xr
        sc += xc
        # 해당 위치에 더해질 모래 양
        sdv = int(spread_sand_value[spread_i] * y_val)
        # print(sr, sc, sdv)
        count+= sdv

        # 위치가 board 벗어난 경우, 
        if sr<0 or sc<0 or sr>=N or sc>=N:
            out_sand += sdv
            continue
        board[sr][sc] += sdv

    # (0,-2) 알파
    # ar, ac = real_rc(0,2,d)
    ar = yr + dr
    ac = yc + dc
    # print('a :',ar,ac)
    a_val = y_val -count
    if ar<0 or ac<0 or ar>=N or ac>=N:
        out_sand += a_val
    else :
        board[ar][ac] += y_val - count

    board[yr][yc] = 0
    # print('y',yr,yc)
    xr = yr
    xc = yc

    # for b in range(N):
    #     print(board[b])
    # print('-----------------------------')


for i in range(1, N):
    # print(i)
    if i%2 == 1:
        # d = 0, 1
        for j in range(i):
            moving_sand(0)
        for j in range(i):
            moving_sand(1)
    else:
        # d = 2, 3
        for j in range(i):
            moving_sand(2)
        for j in range(i):
            moving_sand(3)
for i in range(N-1):
    moving_sand(0)
print(out_sand)