import sys
input = sys.stdin.readline

INF= 2**31

n = int(input())
matrix = [[]]
for _ in range(n):
    matrix.append(list(map(int, input().split())))
dp = [[INF]*(n+1) for _ in range(n+1)]

for i in range(n+1):
    dp[i][i] = 0

for a in range(n-1,0,-1):
    dif = n-a # 각 칸의 i,j 차이
    for b in range(1,a+1): # i
        for k in range(b,b+dif):
            dp[b][b+dif] = min(dp[b][b+dif], dp[b][k]+dp[k+1][b+dif] + matrix[b][0]*matrix[k][1]*matrix[b+dif][1])

print(dp[1][n])