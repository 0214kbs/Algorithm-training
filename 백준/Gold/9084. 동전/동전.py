import sys
input = sys.stdin.readline

T = int(input())
for t in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    want = int(input())
    dp = [0]*(want+1)
    dp[0] = 1

    coins.sort()
    for c in coins:
        for i in range(c,want+1):
            dp[i] += dp[i-c]
    print(dp[want])