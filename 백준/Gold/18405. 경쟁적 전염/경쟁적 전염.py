import sys, heapq
input = sys.stdin.readline

dr = [-1,1,0,0]
dc = [0,0,-1,1]

n,k = map(int, input().split())
board = []
q = []
for i in range(n):
    virus =list(map(int, input().split()))
    board.append(virus)
    for j, v in enumerate(virus):
        if v>0:
            heapq.heappush(q,[0,v,i,j])

s,x,y = map(int, input().split())

while q:
    time, v_num, r, c = heapq.heappop(q)

    if time == s:
        continue
    for d in range(4):
        nr = r+dr[d]
        nc = c +dc[d]

        if nr<0 or nc<0 or nr>=n or nc>=n or board[nr][nc]>0:
            continue
        board[nr][nc] = v_num
        heapq.heappush(q,[time+1, v_num, nr,nc])

print(board[x-1][y-1])