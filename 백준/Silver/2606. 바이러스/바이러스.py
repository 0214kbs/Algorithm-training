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

N = int(input())
E = int(input())

parent = [i for i in range(N+1)]

for _ in range(E):
    a,b = map(int, input().split())
    union(parent,a,b)

for i in range(1,N+1):
    find(parent, i)
cnt = 0
for i in range(2,N+1):
    if parent[i] == 1:
        cnt+=1
print(cnt)