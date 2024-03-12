import sys
input = sys.stdin.readline
INF= int(1e9)

def bf(s):
    dist[s] = 0
    for i in range(n):
        for j in range(m): # 간선
            cur = edges[j][0]
            next_node = edges[j][1]
            cost = edges[j][2]

            if dist[cur] != INF and dist[next_node]>dist[cur]+cost:
                dist[next_node] = dist[cur]+cost

                if i == n-1:
                    return True
    return False

n,m = map(int, input().split())
edges = []
dist = [INF]*(n+1)
for _ in range(m):
    a,b,c = map(int, input().split())
    edges.append((a,b,c))

minus_cycle = bf(1)
if minus_cycle:
    print(-1)
else:
    for i in range(2,n+1):
        if dist[i] == INF:
            print(-1)
        else:
            print(dist[i])