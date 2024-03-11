import sys, heapq
input = sys.stdin.readline
INF = int(1e9)

n,m = map(int, input().split())
graph = {}
for i in range(1,n+1):
    graph[i] = []

distance = [INF]*(n+1)

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] <dist:
            continue
        for g in graph[now]:
            cost = dist+g[1]
            if cost<distance[g[0]]:
                distance[g[0]] = cost
                heapq.heappush(q,(cost,g[0]))

for _ in range(m):
    a,b,c = map(int, input().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

dijkstra(1)
print(distance[n])