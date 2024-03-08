import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)
def dfs(idx,v):
    for n_idx, n_val in tree[idx]:
        if visited[n_idx] == -1:
            visited[n_idx] = v+n_val
            dfs(n_idx,v+n_val)

n = int(input())
tree = {}
for i in range(1,n+1):
    tree[i] = []
for _ in range(n-1):
    a,b,c = map(int, input().split())
    tree[a].append([b,c])
    tree[b].append([a,c])


visited = [-1]*(n+1)
visited[1] =0
dfs(1,0)
last_node = visited.index(max(visited))
visited = [-1] * (n + 1)
visited[last_node] = 0
dfs(last_node,0)
print(max(visited))