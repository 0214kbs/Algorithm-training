import sys,math
input = sys.stdin.readline

def find(i):
    if parent[i] != i:
        parent[i] = find(parent[i])
    return parent[i]


def union(i,j):
    a = find(i)
    b = find(j)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int, input().split())
parent = [i for i in range(n)]

dots = []
edges = []
for _ in range(n):
    x,y = map(int, input().split())
    dots.append([x,y])

for _ in range(m):
    a,b = map(int,input().split())
    union(a-1,b-1)

for i in range(n-1):
    for j in range(i+1,n):
        if find(i) != find(j):
            tmp = math.sqrt((dots[i][0]-dots[j][0])**2+(dots[i][1]-dots[j][1])**2)
            edges.append([tmp,i,j])


edges.sort()
res = 0
for cost,a,b in edges:
    if find(a) != find(b):
        union(a,b)
        res+= cost
print("{:.2f}".format(res))