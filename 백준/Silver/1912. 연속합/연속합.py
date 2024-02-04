import sys

input = sys.stdin.readline
n = int(input())
cur = list(map(int, input().split()))

dp = [0] * n
dp[0] = cur[0]
on = True
if cur[0]<0:
    on = False
check = 0

for i in range(1, len(cur)):
    if not on:
        if cur[i]<0:
            check += cur[i]
            if dp[i-1]+check<0:
                dp[i] = cur[i]
                check = 0
            else:
                dp[i] = dp[i-1]
        else:
            dp[i] = max(cur[i], cur[i] + check + dp[i - 1])
            on = True
            check = 0
    else: # on
        if cur[i] < 0:
            check += cur[i]
            dp[i] = dp[i - 1]
            on = False
        else:
            dp[i] = cur[i] + dp[i - 1]

#print(dp)
print(max(dp))