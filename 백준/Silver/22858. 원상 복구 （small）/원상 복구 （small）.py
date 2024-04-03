import sys
input =sys.stdin.readline

n,k = map(int, input().split())
si = list(map(int, input().split()))
di = list(map(int, input().split()))

for _ in range(k):
    tmp = [0 for _ in range(n)]
    for d in range(n):
        tmp[di[d]-1] = si[d]
    si = tmp
print(*si)