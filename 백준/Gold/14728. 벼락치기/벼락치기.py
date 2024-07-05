import sys
input =sys.stdin.readline

N, T = map(int, input().split())
arr = [[0,0]]
for _ in range(N):
    k,s = map(int, input().split())
    arr.append([k,s])

dp = [[0 for _ in range(T+1)] for _ in range(N+1)]
for i in range(1,N+1):
    for j in range(1,T+1):
        if j < arr[i][0]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1])
print(dp[N][T])