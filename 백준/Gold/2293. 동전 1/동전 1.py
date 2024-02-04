n,k = map(int, input().split())
values = [int(input()) for _ in range(n)]
values.sort()
dp = [0]*(k+1)
dp[0] = 1

for v in values:
    for i in range(v,k+1):
        dp[i] += dp[i-v]

# print(dp)
print(dp[k])