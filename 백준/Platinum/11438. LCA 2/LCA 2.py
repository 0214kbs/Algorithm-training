import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline
LENGTH = 21

def find_depth(cur,d):
    visited[cur] = True
    depth[cur] = d
    for t in tree[cur]:
        if not visited[t]:
            parent[t][0] = cur
            find_depth(t,d+1)


# 모든 노드의 전체 부모 관계 갱신
def set_parent():
    find_depth(1,0)
    for i in range(1,LENGTH):
        for j in range(1,n+1):
            # 각 노드에 대해 2**i 번째 부모 정보 갱신
            parent[j][i] = parent[parent[j][i-1]][i-1]

def LCA(a,b):
    if depth[a]>depth[b]: # 무조건 b가 더 깊게
        a,b = b,a
    # a,b 깊이가 동일하게
    for i in range(LENGTH-1,-1,-1):
        if depth[b] - depth[a] >= 2**i:
            b = parent[b][i]

    if a == b:
        return a

    for i in range(LENGTH-1,-1,-1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]

    return parent[a][0]

n = int(input())
tree = [[] for _ in range(n+1)]
for _ in range(n-1):
    a,b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

depth = [0 for _ in range(n+1)] # 각 노드까지 깊이
parent = [[0]*LENGTH for _ in range(n+1)] # 부모 노드 정보
visited = [False for _ in range(n+1)] # 깊이 계산 여부

set_parent()
m = int(input())
for _ in range(m):
    a,b = map(int, input().split())
    print(LCA(a,b))