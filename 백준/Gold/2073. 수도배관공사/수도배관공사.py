import sys
input = sys.stdin.readline
D,P = map(int, input().split())
dp = [0] * (D + 1)
dp[0] = 1e9

for _ in range(P):
    li,ci = map(int, input().split())
    tmp = dp[:]
    for i in range(li,D+1):
        if tmp[i-li]:
            dp[i] = max(dp[i], min(tmp[i-li], ci))
print(dp[D])

