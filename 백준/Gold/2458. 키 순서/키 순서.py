import sys
input = sys.stdin.readline
INF = int(1e9)
n,m = map(int, input().split())
graph = [[INF]*(n+1) for _ in range(n+1)]
for i in range(n+1):
    graph[i][i] = 0

for _ in range(m):
    a,b = map(int, input().split())
    graph[b][a] = 1

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

res  = 0
for i in range(1,n+1):
    Flag = True
    for j in range(1,n+1):
        if graph[i][j] == 1e9 and graph[j][i] == 1e9:
            Flag = False
            break
    if Flag: res+=1

print(res)