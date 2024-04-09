from copy import deepcopy
dr = [-1,-1,0,1,1,1,0,-1]
dc = [0,-1,-1,-1,0,1,1,1]

def dfs(r,c,d,eat):
    global res,board,fish

    # 물고기 움직이기
    move_fish(r,c)

    # 상어 움직이기
    while True:
        nr,nc = r+dr[d], c+dc[d]
        if not 0<=nr<4 or not 0<=nc<4: # 상어 이동 X
            res = max(res,eat)
            return
        if not board[nr][nc]: # 빈 칸
            r,c = nr,nc # 다음 좌표
            continue

        tmp_board, tmp_fish = deepcopy(board), deepcopy(fish)
        nd,num = fish[board[nr][nc][0]], board[nr][nc]
        fish[board[nr][nc][0]],board[nr][nc] = [],[] # 먹은 자리 초기화
        dfs(nr,nc,num[1],eat+num[0]+1)

        # 원래대로 되돌리기
        board,fish = tmp_board,tmp_fish
        fish[board[nr][nc][0]], board[nr][nc] = nd,num

        # 다음좌표로 이동
        r,c = nr,nc


def move_fish(sr,sc):
    for i in range(16):
        if fish[i]:
            r,c = fish[i][0], fish[i][1]
            for _ in range(9):
                d = board[r][c][1]
                nr,nc = r+dr[d], c+dc[d]
                if not 0<=nr<4 or not 0<=nc<4 or (nr==sr and nc==sc):
                    board[r][c][1] = (board[r][c][1]+1)%8
                    continue
                # 물고기 있으면
                if board[nr][nc]:
                    fish[board[nr][nc][0]] = [r,c]
                board[nr][nc], board[r][c] = board[r][c], board[nr][nc]
                fish[i] = [nr,nc]
                break

board = [[] for _ in range(4)]
fish = [[] for _ in range(16)]

for i in range(4):
    tmp = list(map(int, input().split()))
    for j in range(0,7,2):
        board[i].append([tmp[j]-1,tmp[j+1]-1])
        fish[tmp[j]-1] = [i,j//2]

res = 0
d,eat = board[0][0][1], board[0][0][0]+1
fish[board[0][0][0]] , board[0][0] = [],[]
dfs(0,0,d,eat)
print(res)