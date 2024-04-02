import sys
input = sys.stdin.readline

T= int(input())
for _ in range(T):
    n = int(input())
    data = list(map(int, input().split()))
    dp = [[0]*n for _ in range(n)]
    
    for i in range(n-1):
        # 각 행의 첫번째 값 : i~(i+1)의 합
        dp[i][i+1] = data[i]+data[i+1]
        
        for j in range(i+2,n): # i~j의 누적합
            dp[i][j] = dp[i][j-1] + data[j]
    for k in range(2,n):
        for i in range(n-k):
            j = i+k
            # i~x 의 최소 비용 + i+1~j 의 최소비용.. 들 중에 최솟 값
            costs = []
            for x in range(i,j):
                costs.append(dp[i][x] + dp[x+1][j])
            dp[i][j] += min(costs)

    print(dp[0][n-1])