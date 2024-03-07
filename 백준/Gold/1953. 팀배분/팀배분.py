import sys
from collections import deque
input = sys.stdin.readline

def bfs(i):
    check[i] = 1

    visited[i] = True
    q = deque()
    q.append(i)

    while q:
        cur = q.popleft()
        next = 2 if check[cur] == 1 else 1
        tmps = graph[cur]
        for i in range(len(tmps)):
            if check[tmps[i]] == 0:
                check[tmps[i]] = next
                visited[tmps[i]] = True
                q.append(tmps[i])


n = int(input())
check = [0]*(n+1)
visited = [False]*(n+1)
graph = {}
for i in range(1,n+1):
    tmp = list(map(int, input().split()))
    graph[i] = tmp[1:]

for i in range(1,n+1):
    if not visited[i]:
        bfs(i)

tmp1 = []
tmp2 = []
for i in range(1,n+1):
    if check[i] == 1:
        tmp1.append(i)
    else:
        tmp2.append(i)
print(len(tmp1))
print(*tmp1)
print(len(tmp2))
print(*tmp2)