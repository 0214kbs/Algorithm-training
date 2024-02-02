n= int(input())
dp = [0]*n

cups = [int(input()) for i in range(n)]

if n==1:
    print(cups[0])
elif n==2:
    print(cups[1] + cups[0])
else:
    dp[0] = cups[0]
    dp[1] = cups[1]+cups[0]
    dp[2] = max(cups[0]+cups[2], cups[2]+cups[1], dp[1])

    for i in range(3, n):
        dp[i] = max(cups[i]+dp[i-2], cups[i]+cups[i-1]+dp[i-3],dp[i-1])

    print(max(dp))