import sys
input = sys.stdin.readline

N = int(input())
students = [list(map(int, input().split())) for _ in range(N*N)]
board = [[0]*N for _ in range(N)]
checked = [(0,0)] * (N*N+1)

dr = [-1,0,0,1]
dc = [0,-1,1,0]

def count_blank(r,c):
    ret = 0
    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]
        if nr<0 or nc<0 or nr>=N or nc>=N:
            continue
        if board[nr][nc] ==0:
            ret+=1
    return ret

def count_love(r,c,lst):
    ret = 0
    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]
        if nr<0 or nc<0 or nr>=N or nc>=N:
            continue
        if board[nr][nc] in lst:
            ret+=1
    return ret

for snum in range(N*N):
    now = students[snum][0]

    # 1. 비어있는 칸 중에서 인접 좋아하는 학생 많은 칸
    count = 0
    can = []
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                tmp = count_love(i, j, students[snum][1:])
                if count < tmp:
                    count = tmp
                    can = [(i,j)]
                elif count == tmp:
                    can.append((i,j))

    if len(can) == 1:
        checked[now] = can[0]
        board[can[0][0]][can[0][1]] = now
        # print(board)
        continue

    if len(can) == 0:
        continue
    # 2. 1을 만족하는 게 여러 개면, 인접 빈칸이 많은 칸
    blank = 0
    small_can = []

    for cr,cc in can:
        now_blank = count_blank(cr, cc)
        if blank < now_blank:
            blank = now_blank
            small_can = [(cr,cc)]
        elif blank == now_blank:
            small_can.append((cr, cc))
        # 3. 그 중 행, 열이 제일 작은 칸
    small_can.sort()
    checked[now] = small_can[0]
    board[small_can[0][0]][small_can[0][1]] = now

# print(board)
# print(checked)
satisfy = 0
for snum in students:
    r,c = checked[snum[0]]

    tmp = count_love(r, c, snum[1:])
    # print(snum[0],r,c,tmp)
    if tmp != 0:
        satisfy += 10**(tmp-1)
print(satisfy)