import sys
input = sys.stdin.readline

n,m = map(int, input().split())
a = list(map(int, input().split()))

s,e = 0,0
res = 0
while s<=e and e<=n:
    sum_l = a[s:e]
    total = sum(sum_l)

    if total == m:
        res+=1
        e+=1
    elif total<m:
        e+=1
    else:
        s+=1
print(res)