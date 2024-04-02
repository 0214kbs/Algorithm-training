import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
time= [0]*(n+1)
res = [0]*(n+1)
indegree = [0]*(n+1)
graph = [[] for _ in range(n+1)]

for i in range(1,n+1):
    tmp = list(map(int, input().split()))[:-1]
    time[i] = tmp[0]
    for t in tmp[1:]:
        graph[t].append(i)
        indegree[i]+=1

# print(indegree)
q = deque()
for i in range(1,n+1):
    if indegree[i] == 0:
        q.append(i)
        res[i] = time[i]

while q:
    cur = q.popleft()
    for g in graph[cur]:
        indegree[g] -=1
        res[g] =max(res[g], res[cur]+time[g])
        if indegree[g] == 0:
            q.append(g)
# print(res)
for r in res[1:]:
    print(r)