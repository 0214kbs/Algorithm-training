from collections import deque
from collections import defaultdict
import sys
sys.setrecursionlimit(2000)

input = sys.stdin.readline
n, m, v = map(int, input().split())
graph = defaultdict(list)
for i in range(m):
    a, b = map(int, input.split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

# print(graph)
visited = [False] * n


def bfs(g):
    q = deque([g[v]])
    visited[v - 1] = True
    print(v, end=" ")
    while q:
        nxts = q.popleft()
        for nxt in nxts:
            if not visited[nxt - 1]:
                print(nxt, end=" ")
                visited[nxt - 1] = True
                q.append(g[nxt])


def dfs(g, cur):
    if False not in visited:
        return
    if not visited[cur - 1]:
        print(cur, end=" ")
        visited[cur - 1] = True
        # print(visited)
        for nxt in g[cur]:
            dfs(g, nxt)


dfs(graph, v)
print()
visited = [False] * n
bfs(graph)
