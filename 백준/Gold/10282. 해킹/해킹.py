import sys,heapq
input =sys.stdin.readline

INF = float('inf')
T = int(input())
for _ in range(T):
    n, d, c = map(int, input().split())
    deps = [[] for _ in range(n + 1)]
    for _ in range(d):
        a, b, s = map(int, input().split())
        deps[b].append([a, s])

    heap = []
    dist = [INF for _ in range(n + 1)]
    visited = [0 for _ in range(n + 1)]
    dist[c] = 0
    heapq.heappush(heap, [0, c])

    while heap:
        cost, node = heapq.heappop(heap)
        if visited[node] == 1:
            continue
        visited[node] = 1
        for nxt, d in deps[node]:
            if not visited[nxt]:
                if dist[nxt] > cost + d:
                    dist[nxt] = cost + d
                    heapq.heappush(heap, [dist[nxt], nxt])

    count, time = 0, 0
    for c in range(1, n + 1):
        if visited[c]:
            count += 1
            time = max(time, dist[c])

    print(count, time)