import sys
input = sys.stdin.readline
n, m = map(int, input().split())
T = [int(input()) for _ in range(n)]

l = min(T)
r = max(T)*m
res = r

while l<=r:
    mid = (l+r)//2

    total = 0
    for i in range(n):
        total += mid//T[i]

    if total>=m:
        r = mid-1
        res = min(mid, res)
    else:
        l = mid+1
print(res)