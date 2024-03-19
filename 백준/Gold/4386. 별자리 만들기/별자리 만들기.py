import math, sys

input = sys.stdin.readline


def find(i):
    if parent[i] == i:
        return i
    else:
        parent[i] = find(parent[i])
        return parent[i]

def union(i, j):
    a = find(i)
    b = find(j)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
dots = []
for _ in range(n):
    dots.append(list(map(float, input().split())))

edges = []
for i in range(n-1):
    for j in range(i + 1, n):
        cost = math.sqrt((dots[i][0] - dots[j][0]) ** 2 + (dots[i][1] - dots[j][1]) ** 2)
        edges.append([cost, i, j])

parent = [i for i in range(n)]
edges.sort()

res = 0
for cost,a,b in edges:
    if find(a) != find(b):
        union(a,b)
        res+= cost

print(round(res,2))