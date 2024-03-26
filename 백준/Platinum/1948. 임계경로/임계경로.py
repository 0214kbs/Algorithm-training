import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
graphR = [[] for _ in range(n+1)]
degree = [0 for _ in range(n+1)]
res = [0 for _ in range(n+1)]
check = [0 for _ in range(n+1)]

for _ in range(m):
    a, b, t = map(int,input().split())
    graph[a].append([b,t])
    graphR[b].append([a,t])
    degree[b]+=1

start,end= map(int, input().split())
q = deque()
q.append(start)

while q:
    cur = q.popleft()
    for nxt,time in graph[cur]:
        degree[nxt] -=1
        res[nxt] = max(res[nxt],res[cur]+time)
        if degree[nxt] == 0:
            q.append(nxt)

cnt = 0
q.append(end)
while q:
    cur = q.popleft()
    for nxt, time in graphR[cur]:
        if res[cur]-res[nxt] == time:
            cnt +=1
            if check[nxt] == 0:
                q.append(nxt)
                check[nxt] = 1

print(res[n])
print(cnt)