import sys, heapq
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    return parent[a]

def union(parent, a,b):
    a = find(parent,a)
    b = find(parent,b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b


V, E = map(int, input().split())
parent = [ i for i in range(V+1)]
heap = []
min_cost = 0
for _ in range(E):
    a,b,c = map(int, input().split())
    heapq.heappush(heap, [c,a,b])

while heap:
    cost, a,b = heapq.heappop(heap)

    if find(parent,a) != find(parent,b):
        union(parent,a,b)
        min_cost += cost # 간선 비용
print(min_cost)