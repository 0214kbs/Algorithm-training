import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    return parent[a]


V, E = map(int, input().split())
parent = [ i for i in range(V+1)]
edges = []
min_cost = 0
for _ in range(E):
    a,b,c = map(int, input().split())
    edges.append([c,a,b])

edges.sort()
for cost, a,b in edges:
    pa = find(parent,a)
    pb = find(parent,b)
    if pa != pb:
        if pa>pb:
            parent[pa] = pb
        else:
            parent[pb] = pa
        min_cost += cost # 간선 비용
print(min_cost)