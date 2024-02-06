T = int(input())

dp = [[0]*2001 for _ in range(11)]
dp[0][0] = 1
for i in range(1,11):
    for j in range(1, 2001):
        tmp = 0
        for k in range(j//2+1):
            tmp += dp[i-1][k]
        dp[i][j] = tmp

for t in range(T):
    n, m = map(int, input().split())
    tmp = 0
    for k in range(2**(n-1),m+1):
        tmp += dp[n][k]
    print(tmp)