import sys
input = sys.stdin.readline

str = input()
n = int(input())
can_erase_list = []
for _ in range(n):
    can_erase_list.append(list(input().split()))

can_erase_list.sort()

dp = [0]*(len(str)-1)
dp[0] = 1
for erase in can_erase_list:
    if str[:len(erase[0])] == erase[0]:
        dp[len(erase[0])-1] = int(erase[1])

for i in range(1, len(str)-1):
    for erase in can_erase_list:
        if str[i:i+len(erase[0])] == erase[0]:
            dp[i+len(erase[0])-1] = max(dp[i-1]+int(erase[1]),dp[i+len(erase[0])-1])
    dp[i] = max(dp[i-1]+1, dp[i])

print(dp[-1])