import sys, heapq
input = sys.stdin.readline

dr = [0,0,-1,1]
dc =[1,-1,0,0]
m,n = map(int, input().split())
board =[list(input().rstrip()) for _ in range(n)]

q = []
heapq.heappush(q,(0,0,0))
visit = [[False]*m for _ in range(n)]
visit[0][0] = True
res = n*m
while q:
    broken,cr,cc = heapq.heappop(q)
    if (cr,cc) == (n-1,m-1):
        # print('here')
        res = min(res,broken)
        continue
    for d in range(4):
        nr,nc = cr+dr[d], cc+dc[d]

        if 0<=nr<n and 0<=nc<m and not visit[nr][nc]:
            visit[nr][nc] = True
            if board[nr][nc] == '1':
                heapq.heappush(q,(broken+1, nr,nc))
            else:
                heapq.heappush(q,(broken,nr,nc))

print(res)