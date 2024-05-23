import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(node):
    visited[node] = True
    for next_node in tree[node]:
        if not visited[next_node]:
            find(next_node)
            dp[node][0] += dp[next_node][1]
            dp[node][1] += min(dp[next_node][0], dp[next_node][1])

N = int(input())
dp = [[0,1] for _ in range(N+1)]
tree = [[] for _ in range(N+1)]
for i in range(N-1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)

visited = [False for _ in range(N+1)]

find(1)
print(min(dp[1]))