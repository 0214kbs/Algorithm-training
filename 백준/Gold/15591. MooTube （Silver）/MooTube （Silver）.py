import sys
from collections import deque
input = sys.stdin.readline

N, Q = map(int, sys.stdin.readline().split())

G = {n: deque() for n in range(1, N + 1)}
for _ in range(N - 1):
    p, q, v = map(int, input().split())
    G[p].append((q, v))
    G[q].append((p, v))

for _ in range(Q):
    ki, vi = map(int, input().split())
    visited, queue, ans = [0] * (N + 1), deque(), 0

    visited[vi] = 1
    for v, k in G[vi]:
        visited[v] = 1
        queue.append((v, k))

    while queue:
        v, k = queue.popleft()

        if k >= ki:
            ans += 1
            for nv, nk in G[v]:
                if not visited[nv]:
                    visited[nv] = 1
                    queue.append((nv, min(k, nk)))

    print(ans)
