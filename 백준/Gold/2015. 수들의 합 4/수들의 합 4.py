import sys
input = sys.stdin.readline

n,k = map(int, input().split())
nums = list(map(int, input().split()))

dp = [0]*n
dp[0] = nums[0]

res = 0
dict = {}
for i in range(n):
    dp[i] = dp[i-1]+nums[i]

    if dp[i] == k:
        res += 1

    tmp = dp[i] - k

    if tmp in dict.keys():
        res += dict[tmp]

    if dp[i] not in dict.keys():
        dict[dp[i]] = 1
    else:
        dict[dp[i]] +=1

print(res)