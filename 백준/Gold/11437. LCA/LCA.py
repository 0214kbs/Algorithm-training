import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

def find_depth(cur,d):
    visited[cur] = True
    depth[cur] = d
    for t in tree[cur]:
        if not visited[t]:
            parent[t] = cur
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

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a,b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

depth = [0 for _ in range(n+1)] # 각 노드까지 깊이
parent = [0 for _ in range(n+1)] # 부모 노드 정보
visited = [False for _ in range(n+1)] # 깊이 계산 여부

find_depth(1,0)

m = int(input())
for _ in range(m):
    a,b = map(int, input().split())
    print(LCA(a,b))