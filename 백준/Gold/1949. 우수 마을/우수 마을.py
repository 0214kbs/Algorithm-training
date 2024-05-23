import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(node):
    visited[node] = True
    for nxt in tree[node]:
        if not visited[nxt]:
            find(nxt)

            # 현재 마을을 우수마을로 선정
            dp[node][1] += dp[nxt][0]

            # 현재 마을 우수마을 X
            dp[node][0] += max(dp[nxt][0], dp[nxt][1])


N = int(input())
people = [0]+list(map(int, input().split()))

dp = [[0, people[i]]*2 for i in range(N+1)]
tree = [[] for _ in range(N+1)]
for i in range(N-1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)


visited = [False for _ in range(N+1)]
find(1)
print(max(dp[1]))