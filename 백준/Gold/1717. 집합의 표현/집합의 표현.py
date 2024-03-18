import sys
input = sys.stdin.readline

def find(idx):
    if parent[idx] == idx:
        return idx
    else:
        parent[idx] = find(parent[idx])
        return parent[idx]

def union(i,j):
    a = find(i)
    b = find(j)

    if a==b:
        return
    elif a>b:
        parent[b] = a
    else:
        parent[a] = b


n,m  = map(int, input().split())

parent = [i for i in range(n+1)]
for _ in range(m):
    q,a,b = map(int, input().split())
    if q == 1:
        if find(a) == find(b):
            print("YES")
        else:
            print("NO")
    else:
        union(a,b)