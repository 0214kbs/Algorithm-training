import sys
input = sys.stdin.readline

chars = input().rstrip() # azck
password = input().rstrip() # akz
chars_i = {}
for i in range(len(chars)):
    chars_i[chars[i]] = i+1

dp = [1]*len(password)
for i in range(1, len(password)):
    dp[i] = (dp[i-1]*len(chars))%900528

# print(cnt)
tmp = 0
for i in range(len(password)):
    tmp += chars_i[password[i]]*(dp[len(password)-i-1])
# print(tmp)
print(tmp%900528)

#