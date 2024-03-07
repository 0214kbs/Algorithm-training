import sys
from collections import deque
input = sys.stdin.readline

def bfs(i):
    q = deque()
    q.append(i)
    check[i] = 1
    visited[i] = True
    while q:
        cur = q.popleft()
        # print(cur, check)
        tmp = graph[cur]
        next = 1 if check[cur]==2 else 2
        for i in range(len(tmp)):
            visited[tmp[i]] = True
            if check[tmp[i]] == 0:
                check[tmp[i]] = next
                q.append(tmp[i])
            elif check[tmp[i]] != next:
                return False
    return True


k = int(input())
for _ in range(k):

    flag = True
    v,e = map(int, input().split())
    check = [0]*(v+1)
    visited = [True] + [False]*v
    graph = {}
    for i in range(1,v+1):
        graph[i] = []
    for i in range(e):
        a,b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1,v+1):
        if not visited[i]:
            flag = bfs(i)
            if not flag:
                break
    if not flag:
        print("NO")
    else:
        print("YES")