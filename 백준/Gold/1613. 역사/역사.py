import sys
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int, input().split())
graph = [[INF]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a,b = map(int, input().split())
    graph[a][b] = 1

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

s = int(input())
for _ in range(s):
    i, j = map(int, input().split())
    if graph[i][j] == INF and graph[j][i] == INF:
        print(0)
        continue
    if graph[i][j] < graph[j][i]:
        print(-1)
    else:
        print(1)