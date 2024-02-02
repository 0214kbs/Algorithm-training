AB = []
N = int(input())
for _ in range(N):
    AB.append(list(map(int, input().split())))

AB.sort()

dp = [1]*N
for i in range(N):
    for j in range(0,i):
        if AB[i][1]>AB[j][1]:
            dp[i] = max(dp[i],dp[j]+1)

print(N-max(dp))