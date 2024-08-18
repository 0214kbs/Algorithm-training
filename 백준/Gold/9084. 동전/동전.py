import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())

    dp = [0 for _ in range(M+1)]
    for c in coins:
        if c>M:
            continue
        dp[c] += 1
        for i in range(M+1):
            if M+1>(i-c)>0:
                dp[i] = dp[i]+dp[i-c]

    print(dp[M])