import sys,heapq
input = sys.stdin.readline
INF = int(1e9)
T = int(input())
for _ in range(T):
    n, d, c = map(int, input().split())
    deps = [[] for _ in range(n+1)]
    for _ in range(d):
        a,b,s = map(int, input().split())
        deps[b].append([s,a])

    hq = []
    dp = [INF for _ in range(n+1)]
    heapq.heappush(hq,[0, c])
    dp[c] = 0
    # print(dp)
    while hq:
        time, cur = heapq.heappop(hq)
        # print(time,cur)
        for nxt in deps[cur]:
            nxt_time = time+nxt[0]
            if nxt_time < dp[nxt[1]]:
                dp[nxt[1]] = nxt_time
                heapq.heappush(hq,[nxt_time, nxt[1]])
    # print(dp)
    res = [0,0]
    for i in range(1,n+1):
        if dp[i] < INF:
            res[1] = max(res[1],dp[i])
            res[0] += 1
    print(*res)