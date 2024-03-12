import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())
graph = [[INF]*(n+1) for _ in range(n+1)]
path = [[-1]*(n+1) for _ in range(n+1)]

for i in range(n+1):
    graph[i][i] = 0

for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)
    path[a][b] = a

for k in range(1,n+1):
    path[k][k] = -1
    for a in range(1,n+1):
        for b in range(1,n+1):
            if graph[a][b] > graph[a][k]+graph[k][b]:
                graph[a][b] = graph[a][k]+graph[k][b]
                path[a][b] = path[k][b]


for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j] == INF:
            print(0, end=" ")
        else:
            print(graph[i][j], end=" ")
    print()


for i in range(1,n+1):
    for j in range(1,n+1):
        if path[i][j] == -1:
            print(0)
            continue
        v = j
        res = []
        while True:
            if v == i:
                break
            res.append(v)
            v = path[i][v]
        print(len(res)+1, i, *res[::-1])