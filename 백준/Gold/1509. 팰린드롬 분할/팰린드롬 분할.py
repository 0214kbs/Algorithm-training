import sys
input = sys.stdin.readline

s = input().rstrip()
L = len(s)
dp = [2500 for _ in range(L+1)]
dp[-1] =0
is_p = [[False for _ in range(L)] for _ in range(L)] # 팰린드롬 여부

# 길이가 1짜리 팰린드롬
for i in range(L):
    is_p[i][i] = True

# 길이가 2짜리 팰린드롬 ex. AA, DD, ..
for i in range(1,L):
    if s[i-1] == s[i]:
        is_p[i-1][i]= True

# 길이가 3이상인 팰린드롬
for length in range(3,L+1):
    for start in range(L-length+1):
        end = start+length-1
        if s[start] == s[end] and is_p[start+1][end-1]:
            is_p[start][end] = True

# 분할
for end in range(L):
    for start in range(end+1):
        if is_p[start][end]:
            dp[end] = min(dp[end],dp[start-1]+1)
        else:
            dp[end] = min(dp[end],dp[end-1]+1)

print(dp[L-1])