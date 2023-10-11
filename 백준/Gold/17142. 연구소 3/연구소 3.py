import sys
input = sys.stdin.readline
from collections import deque

dr = [0,0,-1,1]
dc = [-1,1,0,0]

N,M = map(int, input().split())
board = []
virus = []
blank_cnt = 0
INF = N*N


# 0 : 빈칸, 1 벽, 2 바이러스
for i in range(N):
    board.append(list(map(int, input().split())))
    for j in range(N):
        if board[i][j] == 2:
            virus.append([i,j])
        elif board[i][j] == 0:
            blank_cnt+=1


def comb(virus, M):
    select_virus = []
    if M == 0:
        return [[]]

    for i in range(len(virus)):
        el = virus[i]
        for c in comb(virus[i+1:], M-1):
            select_virus.append([el]+c)
    return select_virus


def spread_virus(q, blanks):
    visited = [[-1]*N for _ in range(N)]
    cnt = 0
    while True:
        # print(q)
        if blanks == 0:
            return cnt
        if len(q) == 0:
            return INF
        cnt+=1

        for i in range(len(q)):
            r, c = q.popleft()
            if visited[r][c] == -1:
                visited[r][c] = 1
            for d in range(4):
                nr = r+dr[d]
                nc = c+dc[d]

                if 0>nr or 0>nc or nr>=N or nc>=N:
                    continue
                if visited[nr][nc] == -1:
                    if board[nr][nc]  == 0:
                        q.append((nr,nc))
                        # print('append: ',nr,nc)
                        visited[nr][nc] = 1
                        blanks -=1
                    elif board[nr][nc] == 2:
                        q.append((nr,nc))
                        # print('append: ',nr,nc)
                        visited[nr][nc] =1


# virus list 조합
virus_comb = comb(virus,M)
res = INF
for virus_list in virus_comb:
    q = deque()
    for v in virus_list:
        q.append(v)

    tmp = spread_virus(q, blank_cnt)
    res = min(res,tmp)

if res == INF:
    print(-1)
else:
    print(res)