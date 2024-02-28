import sys
input = sys.stdin.readline
n, c = map(int, input().split())
x = [int(input()) for _ in range(n)]

x.sort()

if c==2:
    print(x[-1]-x[0])
    exit()


# 거리 기준
l,r = 0, x[-1]-x[0]
res = 0
while l<=r:
    mid = (l+r)//2
    cur = x[0]
    cnt = 1

    for i in range(1, len(x)):
        if x[i]>=cur+mid:
            cnt +=1
            cur = x[i]
    if cnt >= c:
        l = mid+1
        res = mid
    else:
        r = mid-1

print(res)