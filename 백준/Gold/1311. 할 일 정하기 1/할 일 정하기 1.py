import sys
input = sys.stdin.readline
INF = int(1e9)
n = int(input())
d = [list(map(int, input().split())) for _ in range(n)]
dp = [[INF]*(1<<n) for _ in range(20)]
def dfs(x, visited):
    if visited == (1<<n)-1:
        return 0

    if dp[x][visited] != INF:
        return dp[x][visited]

    for i in range(n):
        bit = 1<<i
        if visited & bit:
            continue
        dp[x][visited] = min(dfs(x+1, visited|bit)+d[x][i], dp[x][visited])

    return dp[x][visited]

print(dfs(0,0))