import sys
input =sys.stdin.readline

C,N = map(int, input().split()) # C명
arr = []

INF = int(1e9)
dp = [[INF]*1101 for _ in range(N)]
for i in range(N):
	cost, nums = map(int, input().split())
	if i == 0:
		for j in range(1, 1101):
			if nums==j:
				dp[i][j] = cost
			elif j%nums == 0:
				dp[i][j] = dp[i][j-nums] + cost
	else:
		arr.append([cost, nums])
# print(dp[0])
for i in range(1,N):
	cost, nums = arr[i-1]
	dp[i][nums] = min(dp[i-1][nums], cost)
	for j in range(1101):
		if j<nums:
			dp[i][j] = dp[i-1][j]
		elif j%nums == 0 :
			if j != nums:
				dp[i][j] = min(dp[i][j-nums]+cost, dp[i-1][j])
		else:
			dp[i][j] = min(dp[i-1][j], dp[i][j-nums]+cost)
	# print(dp[i])
print(min(dp[-1][C:]))