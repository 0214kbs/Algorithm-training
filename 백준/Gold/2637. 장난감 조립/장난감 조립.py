import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
needs = [[0]*(n+1) for _ in range(n+1)]
check = [0]*(n+1)
for _ in range(m):
    x,y,k = map(int, input().split())
    graph[y].append([x, k])
    check[x]+=1

q = deque()
for i in range(1,n+1):
    if check[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    for nxt, nxt_need in graph[cur]:
        if needs[cur].count(0) == n+1:
            needs[nxt][cur] += nxt_need
        else:
            for i in range(1,n+1):
                needs[nxt][i] += needs[cur][i]*nxt_need
        check[nxt] -=1
        if check[nxt] == 0:
            q.append(nxt)

for i in range(1,len(needs[n])):
    if needs[n][i]>0:
        print(i, needs[n][i])