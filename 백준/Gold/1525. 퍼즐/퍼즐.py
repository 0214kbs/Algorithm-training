import sys
from collections import deque
input = sys.stdin.readline
board = ""
for i in range(3):
    board += "".join(list(input().split()))

visited = {board:0}
q= deque([board])

dr = [-1,1,0,0]
dc = [0,0,-1,1]

def bfs():
    while q:
        cur = q.popleft()
        cnt = visited[cur]

        if cur == '123456780':
            return cnt

        b = cur.index('0')
        r = b//3
        c = b%3

        cnt += 1
        for d in range(4):
            nr,nc = r+dr[d],c+dc[d]
            if 0<=nr<3 and 0<=nc<3:
                nb = nr*3 + nc
                cur_list = list(cur)
                cur_list[b],cur_list[nb] = cur_list[nb],cur_list[b]
                new = "".join(cur_list)

                if visited.get(new,0) == 0:
                    visited[new] = cnt
                    q.append(new)
    return -1


print(bfs())