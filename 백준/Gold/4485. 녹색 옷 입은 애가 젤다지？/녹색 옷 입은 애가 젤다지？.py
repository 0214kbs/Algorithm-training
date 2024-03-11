import sys, heapq
input = sys.stdin.readline

dr = [0,0,-1,1]
dc = [-1,1,0,0]
INF = int(1e9)

turn = 1
while True:
    n = int(input())
    if n==0:
        break

    board = [list(map(int, input().split())) for _ in range(n)]
    distance = [[INF]*n for _ in range(n)]

    q = []
    heapq.heappush(q,[board[0][0],0,0])
    distance[0][0] = 0

    while q:
        lost, cr,cc = heapq.heappop(q)
        if (cr,cc) == (n-1,n-1):
            print(f'Problem {turn}: {distance[cr][cc]}')
            break
        for d in range(4):
            nr,nc = cr+dr[d], cc+dc[d]
            if 0<=nr<n and 0<=nc<n:
                tmp = lost+board[nr][nc]
                if tmp<distance[nr][nc]:
                    distance[nr][nc] = tmp
                    heapq.heappush(q, [tmp, nr, nc])
    turn+=1