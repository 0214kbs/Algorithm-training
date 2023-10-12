import sys
from collections import deque

input = sys.stdin.readline

N,M,energy = map(int, input().split())
board = []
board2 = [[0]*N for _ in range(N)]
for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(N):
        board2[i][j] = board[i][j]

taxi_r, taxi_c = map(int, input().split())
taxi_r -= 1
taxi_c -= 1

start =[]
for i in range(M):
    st_r, st_c, des_r, des_c = map(int, input().split())
    start.append((st_r-1, st_c-1, des_r-1, des_c-1))
    # board[st_r-1][st_c-1] = 2 # 사람

start.sort()

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]
energy_flag = True # 연료 바닥 여부

# 1현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
    # - 행번호, 열번호 순
def cal_move(r, c, i, tag): # tag 0이면 taxi -> customer 계산 , 1이면 cust-> des
    # print('taxi : ',r,c)
    t1,t2,t3,t4 = start[i]
    if tag == 0:
        st_r, st_c = t1,t2


    else:
        st_r, st_c = t3,t4

    if tag == 0:
        if st_r == r and st_c == c:
            return 0

    board[st_r][st_c] = 0
    visited = [[0]*N for _ in range(N)]
    q = deque()
    q.append((r,c))
    visited[r][c] = 1
    # for j in range(N):
    #     print(board[j])
    while q:
        if visited[st_r][st_c]:
            break
        curr, curc = q.popleft()
        for d in range(4):
            nr = curr+dr[d]
            nc = curc+dc[d]

            if nr<0 or nc<0 or nr>=N or nc>=N:
                continue
            if board[nr][nc] >= 1 or visited[nr][nc]>0:
                continue

            visited[nr][nc] = visited[curr][curc]+1
            q.append((nr,nc))
    # print('--------')
    # if tag == 0:
    #     for i in range(N):
    #         print(visited[i])
    return visited[st_r][st_c]-1

def find_cust():
    board2[taxi_r][taxi_c] = 0
    visited = [[0]*N for _ in range(N)]
    q = deque()
    q.append((taxi_r,taxi_c))
    visited[taxi_r][taxi_c] = 1

    while q:
        curr, curc = q.popleft()
        for d in range(4):
            nr = curr+dr[d]
            nc = curc+dc[d]

            if nr<0 or nc<0 or nr>=N or nc>=N:
                continue
            if board2[nr][nc] >= 1 or visited[nr][nc]>0:
                continue

            visited[nr][nc] = visited[curr][curc]+1
            q.append((nr,nc))
    # for i in range(N):
    #     print(visited[i])
    min_move = INF
    min_i = 0
    for i in range(len(start)):
        t1,t2,t3,t4 = start[i]
        if min_move > visited[t1][t2]:
            min_move = visited[t1][t2]
            min_i = i
    return min_move-1, min_i
INF = N*N
def select_cust():
    global energy,energy_flag

    min_move, min_i = find_cust()
    # print('min : ', min_move, min_i)
    r,c,no,no2 = start[min_i]
    board[r][c] = 0

    energy -= min_move
    # print('energy: ', energy)
    if min_move <0 or energy <= 0:
        energy_flag = False
    return min_i


def cust_to_des(i):
    global taxi_r, taxi_c, energy, energy_flag
    # print('i : ', i)
    # print('start : ', start)
    taxi_r, taxi_c,no,no2 = start[i]
    # print('taxi : ',taxi_r, taxi_c)
    move = cal_move(taxi_r, taxi_c, i, 1)
    no, no2, taxi_r, taxi_c = start[i]
    # print('cust to des -  move :', move)
    energy -= move
    if move < 0 :
        energy_flag=False
    if energy < 0:
        energy_flag = False
    else:
        energy += move*2


for i in range(M):
    # print("-------------")
    min_i = select_cust()
    cust_to_des(min_i)
    start.remove(start[min_i])
    # print('cur energy : ' , energy)
    # for j in range(N):
    #     print(board[j])
    if not energy_flag:
        print(-1)
        break
if energy_flag:
    print(energy)