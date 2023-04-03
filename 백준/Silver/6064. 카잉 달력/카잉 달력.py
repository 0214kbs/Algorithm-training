import sys
from math import gcd


def lcm(m, n):
    return m * n // gcd(m, n)


input = sys.stdin.readline
T = int(input())
for _ in range(T):
    M, N, x, y = map(int, input().split())
    maxK = lcm(M, N)
    k = 0
    # print(calendar(M,N,x,y))
    for i in range(x, maxK+1,M):
        if (i-y)%N == 0:
            k = i
            break
    print(k) if k else print(-1)
