import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
res = []

for _ in range(m):
    a, b = map(int, input().split())
    graph[b].append(a)

max_cnt = 1
for i in range(1,n+1):
    q = deque([i])
    visited = [0]*(n+1)
    visited[i] = 1
    cnt = 1
    while q:
        cur = q.popleft()
        for g in graph[cur]:
            if not visited[g]:
                q.append(g)
                visited[g] = 1
                cnt +=1

    if cnt>max_cnt:
        max_cnt = cnt
        res = []
        res.append(i)
    elif cnt == max_cnt:
        res.append(i)

print(*res)