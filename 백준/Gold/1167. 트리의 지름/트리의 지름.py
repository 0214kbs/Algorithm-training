import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

def dfs(idx,val):
    for n_idx,n_val in tree[idx]:
        if visited[n_idx] == -1:
            visited[n_idx] = val+n_val
            dfs(n_idx,n_val+val)

n = int(input())
tree = {}
for i in range(1,n+1):
    tree[i] = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    for t in range(1,len(tmp)-1,2):
        tree[tmp[0]].append([tmp[t],tmp[t+1]])

visited = [-1]*(n+1)
visited[1] = 0
dfs(1,0)

max_idx = visited.index(max(visited))
visited = [-1]*(n+1)
visited[max_idx] = 0
dfs(max_idx, 0)
print(max(visited))