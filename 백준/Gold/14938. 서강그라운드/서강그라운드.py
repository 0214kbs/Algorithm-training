import sys
from collections import deque
input = sys.stdin.readline

n,m,r = map(int, input().split())
items = [0]+list(map(int, input().split()))
graph = {}
for i in range(1,n+1):
    graph[i] = []
for _ in range(r):
    a,b,l = map(int, input().split())
    graph[a].append([b,l])
    graph[b].append([a,l])

res = 0
for i in range(1,n+1):
    q = deque()
    visit = [False]*(n+1)
    visit[i] = True
    q.append([m, i])
    tmp = items[i]
    while q:
        remain_m, cur= q.popleft()
        for nxt,length in graph[cur]:
            if length <= remain_m:
                if not visit[nxt]:
                    visit[nxt] = True
                    q.append([remain_m-length,nxt])
                    tmp += items[nxt]
                else: # 방문해도 지나가는 용도
                    q.append([remain_m-length,nxt])
    res = max(res,tmp)
print(res)