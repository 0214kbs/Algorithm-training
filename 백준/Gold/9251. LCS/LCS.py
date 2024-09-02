import sys
input = sys.stdin.readline

str1 = input().rstrip()
str2 = input().rstrip()

dp = [[0]*(len(str1)+1) for _ in range(len(str2)+1)]
res = 0
for i in range(len(str2)):
    for j in range(len(str1)):
        if str2[i] == str1[j]:
            dp[i+1][j+1] = dp[i][j]+1
        else:
            dp[i+1][j+1] = max(dp[i+1][j],dp[i][j+1])
        res = max(res, dp[i+1][j+1])
print(res)