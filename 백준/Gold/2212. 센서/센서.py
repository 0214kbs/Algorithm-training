import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
censors = list(map(int, input().split()))

censors.sort()
subs_c = []
for i in range(n-1):
    subs_c.append(abs(censors[i+1]-censors[i]))

subs_c.sort()

res = 0
for i in range(n-k):
    res+= subs_c[i]


print(res)