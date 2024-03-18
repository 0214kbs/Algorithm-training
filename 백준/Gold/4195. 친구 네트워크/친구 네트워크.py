import sys
input = sys.stdin.readline

def find(i):
    if parent[i] == i:
        return i
    else:
        parent[i] = find(parent[i])
        return parent[i]

def union(i,j):
    a = find(i)
    b = find(j)

    if a==b:
        return network[a]
    parent[b] = a
    network[a] += network[b]
    return network[a]

t = int(input())
for _ in range(t):
    n = int(input())
    network = dict()
    parent = dict()
    for _ in range(n):
        a,b = input().rstrip().split()
        if a not in network.keys():
            parent[a] = a
            network[a] = 1
        if b not in network.keys():
            parent[b] = b
            network[b] = 1
        print(union(a,b))