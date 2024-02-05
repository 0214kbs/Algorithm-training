import sys

input = sys.stdin.readline

T = int(input())
k = int(input())
coins = [[0,0]]
for i in range(k):
    coins.append(list(map(int, input().split())))

coins.sort()

dp = [[0] * (T + 1) for _ in range(k + 1)]

for i in range(k + 1):
    dp[i][0] = 1

for i in range(1, k + 1):
    for num in range(coins[i][1] + 1):
        for j in range(T + 1):
            tmp = j + num * coins[i][0]
            if tmp == 0:
                continue
            if tmp < T + 1:
                dp[i][tmp] += dp[i - 1][j]
            else:
                break

print(dp[-1][-1])