import sys
from collections import deque

input = sys.stdin.readline

N,M = map(int, input().split())
graph = {}
for i in range(1,N+1):
    graph[i] = []

check = [0 for _ in range(N+1)]
res = [0 for _ in range(N+1)]

for _ in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    check[b] += 1

q = deque()
cnt = 0
for i in range(1,N+1):
    if check[i] == 0:
        q.append([i,1])
        cnt +=1

res = [0 for _ in range(N+1)]
while q:
    now, term = q.popleft()
    res[now] = term
    tmp_lst = graph[now]
    for t in tmp_lst:
        check[t] -=1
        if check[t] == 0:
            q.append([t,term+1])

print(*res[1:])