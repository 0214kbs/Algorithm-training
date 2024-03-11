import sys
from collections import deque
input = sys.stdin.readline

n,m,k,x = map(int, input().split())
graph = {}
for i in range(1,n+1):
    graph[i] = []
for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)


q = deque()
q.append([0,x])
visit = [False]*(n+1)
visit[x] = True
res = []
while q:
    dist, cur = q.popleft()
    if dist == k:
        res.append(cur)
        continue

    for i in range(len(graph[cur])):
        if not visit[graph[cur][i]]:
            visit[graph[cur][i]] = True
            q.append([dist+1, graph[cur][i]])

res.sort()
if len(res) == 0:
    print(-1)
else:
    for r in res:
        print(r)
