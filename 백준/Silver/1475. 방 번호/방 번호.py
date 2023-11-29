import sys
input = sys.stdin.readline

N = input()
dp = [0 for _ in range(10)]
for i in range(len(N)-1):
    tmp = int(N[i])
    if tmp == 6 or tmp == 9:
        if dp[6] == dp[9] and dp[6]>0:
            dp[6] +=1
        elif dp[6] > dp[9]:
            dp[9]+=1
        else:
            dp[6]+=1
    else:
        dp[tmp] += 1

maxV = 0
for i in range(len(dp)):
    if maxV < dp[i]:
        maxV = dp[i]

print(maxV)