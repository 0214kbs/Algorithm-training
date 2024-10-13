import sys
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


N, M = map(int, input().split())
parent = [ i for i in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    union(parent, u,v)
for i in range(1,N+1):
    find(parent, i)

print(len(set(parent[1:])))