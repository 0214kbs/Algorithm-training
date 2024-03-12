import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
m = int(input())

graph= [[INF]*(n+1) for _ in range(n+1)]

for i in range(n+1):
    graph[i][i] = 0

for _ in range(m):
    a,b = map(int, input().split())
    graph[a][b] =1

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

for i in range(1,n+1):
    res = 0
    for j in range(1,n+1):
        if graph[i][j] == INF and graph[j][i] == INF:
            res+=1
    print(res)