import sys
input = sys.stdin.readline

def find(i):
    if i==parent[i]:
        return i
    else:
        parent[i] = find(parent[i])
        return parent[i]

def union(i,j):
    a = parent[i]
    b = parent[j]

    if a>b:
        parent[a] = b
    else:
        parent[b] = a

while True:
    n,m = map(int, input().split())
    if (n,m) == (0,0):
        break
    parent = [i for i in range(n+1)]
    edges = []
    for _ in range(m):
        x,y,z = map(int, input().split())
        edges.append([z,x,y])
    edges.sort()


    res = 0
    for cost,a,b in edges:
        if find(a) != find(b):
            union(a,b)
        else:
            res+=cost
    print(res)