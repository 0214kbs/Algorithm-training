import sys
from heapq import heappush, heappop

input = sys.stdin.readline
INF = int(1e9)


def dijkstra(start):
    heap = []
    heappush(heap, [0,start])
    dp = [INF] * (n+1)
    dp[start] = 0
    while heap:
        w, now = heappop(heap)
        for n_n, wei in graph[now]:
            n_w = wei + w
            if n_w < dp[n_n]:
                dp[n_n] = n_w
                heappush(heap,[n_w,n_n])
    return dp

T = int(input())

for _ in range(T):
    n, m, t = map(int, input().split())
    s, g, h = map(int, input().split())

    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, d = map(int, sys.stdin.readline().split())  # 노드1,노드2,거리
        graph[a].append([b, d])
        graph[b].append([a, d])

    x = []
    for _ in range(t):  # 목적지 저장
        x.append(int(input()))

    s_d = dijkstra(s)  # 출발지에서의 거리
    g_d = dijkstra(g)  # g에서 출발
    h_d = dijkstra(h)  # h에서 출발

    ans = []
    for i in x:  # 후보지들 하나씩 비교
        # s->g->h->c이 s->c와 같거나
        # s->h->g->c가 s->c와 같다면 후보지이다.
        if s_d[g] + g_d[h] + h_d[i] == s_d[i] or s_d[h] + h_d[g] + g_d[i] == s_d[i]:
            ans.append(i)

    ans.sort()

    for i in range(len(ans)):
        print(ans[i])
    # print(*ans) 로 출력 가능
