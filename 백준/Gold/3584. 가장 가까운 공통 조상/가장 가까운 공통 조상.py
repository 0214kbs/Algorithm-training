import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
def find_depth(cur,d): # d : depth
    visited[cur] = True
    depth[cur] = d
    for t in tree[cur]:
        if not visited[t]:
            find_depth(t,d+1)

def LCA(a,b):
    while depth[a]!=depth[b]:
        if depth[a]>depth[b]:
            a = parent[a]
        else:
            b = parent[b]

    while a!=b:
        a = parent[a]
        b = parent[b]

    return a

T = int(input())
for _ in range(T):
    n = int(input())
    tree = [[] for _ in range(n+1)]
    depth = [0 for _ in range(n+1)]
    parent = [0 for _ in range(n+1)]
    visited = [False for _ in range(n+1)]

    for _ in range(n-1):
        a,b = map(int, input().split())
        tree[a].append(b)
        parent[b] = a

    a,b = map(int, input().split())

    for i in range(1,n+1):
        if parent[i] ==0:
            find_depth(i,0)
            break

    print(LCA(a,b))