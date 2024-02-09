import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))

M = int(input())
dp = [[False]*N for _ in range(N)]
for i in range(N):
    dp[i][i] = True

for i in range(N-1):
    if nums[i] == nums[i+1]:
        dp[i][i+1] = True

for want_len in range(3,N+1):
    for start in range(N-want_len+1):
        end = start+want_len-1
        if nums[start] == nums[end] and dp[start+1][end-1]:
            dp[start][end] = True

for i in range(M):
    s, e = map(int, input().split())
    if dp[s-1][e-1]:
        print(1)
    else:
        print(0)