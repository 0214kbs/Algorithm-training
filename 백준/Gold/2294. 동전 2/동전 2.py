n,k = map(int, input().split())
values = [int(input()) for _ in range(n)]
values.sort()
# print(set(values))
dp = [0]*(k+1)

for i in range(1,k+1):
    tmp = 1e9
    for v in values:
        if i>=v:
            if dp[i-v] == -1 and tmp == 1e9:
                tmp = 1e9
            elif dp[i-v]>=0:
                tmp = min(dp[i-v]+1,tmp)
    if tmp != 1e9:
        dp[i] = tmp
    else:
        dp[i] = -1
# print(dp)
print(dp[k])