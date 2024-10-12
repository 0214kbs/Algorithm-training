import sys
input = sys.stdin.readline

n, k = map(int, input().split())

dp = [[0]*n for _ in range(n)]
for _ in range(k):
    a,b = map(int, input().split())
    # a -> b 순서
    dp[a-1][b-1] = -1
    dp[b-1][a-1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            if dp[i][k] == 1 and dp[k][j] == 1:
                dp[i][j] = 1
            elif dp[i][k] == -1 and dp[k][j] == -1:
                dp[i][j] = -1

s = int(input())
for _ in range(s):
    a,b = map(int, input().split())
    print(dp[a-1][b-1])