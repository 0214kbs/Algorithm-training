k = 1000000
n = int(input())

# 피사드 주기
p = 15*k//10
n %= p

# 피보나치 수 Fi = Fi-2 + Fi-1
f1,f2 = 0,1
for i in range(n-1):
    f1,f2 = f2,(f1+f2)%k
print(f2)