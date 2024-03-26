import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int, input().split())
graph = [[] for _ in range(n+1)]
check = [0 for _ in range(n+1)]
for _ in range(m):
    a,b = map(int, input().split())
    graph[a].append(b)
    check[b]+=1

res = []
q = deque()
for i in range(1, n+1):
    if check[i] == 0:
        q.append(i)

while q:
    cur= q.popleft()
    res.append(cur)
    for i in graph[cur]:
        check[i] -=1
        if check[i] == 0:
            q.append(i)

print(*res)