import sys
input = sys.stdin.readline

n,m,h = map(int, input().split())
blocks = []
for i in range(n):
    blocks.append(list(map(int, input().split())))
blocks.sort()
# print(blocks)
dp = [[0]*(h+1) for _ in range(n)]
dp[0][0] = 1
for i in range(len(blocks[0])):
    dp[0][blocks[0][i]] += 1

for i in range(1,n):
    for j in range(len(blocks[i])):
        for k in range(h+1):
            if dp[i-1][k]>0:
                tmp = blocks[i][j] + k
                if tmp<=h:
                    dp[i][tmp] += dp[i-1][k]
    for k in range(h+1):
        if dp[i-1][k]>0:
            dp[i][k] += dp[i - 1][k]
        # dp[i][blocks[i][j]] += 1

print(dp[-1][h]%10007)