import sys
import heapq
input = sys.stdin.readline

n,d = map(int, input().split())

INF = int(1e9)

graph = [[] for _ in range(d+1)]
distance = [INF]*(d+1)

for i in range(d):
    graph[i].append((i+1,1))

for i in range(n):
    a,b,c = map(int, input().split())
    if b>d:
        continue
    graph[a].append((b,c))

def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0

    while q:
        dist,now = heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            # print(i[0])
            if cost <distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(0)
print(distance[d])